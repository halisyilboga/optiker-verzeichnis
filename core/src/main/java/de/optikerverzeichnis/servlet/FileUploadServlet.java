package de.optikerverzeichnis.servlet;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.optikerverzeichnis.entity.Optician;
import de.optikerverzeichnis.service.AdressValidationService;
import de.optikerverzeichnis.service.OfyService;
import org.apache.commons.fileupload.*;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class FileUploadServlet extends HttpServlet {

    public static Log logger = LogFactory.getLog(FileUploadServlet.class);

    private static final long serialVersionUID = -8244073279641189889L;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        try {
            ServletFileUpload upload = new ServletFileUpload();
            res.setContentType("text/plain");

            FileItemIterator iterator = upload.getItemIterator(req);
            while (iterator.hasNext()) {
                FileItemStream item = iterator.next();
                InputStream stream = item.openStream();

                if (item.isFormField()) {
                    logger.info("Got a form field: " + item.getFieldName());
                } else {
                    logger.info("Got an uploaded file: " + item.getFieldName() +
                            ", name = " + item.getName());
                    AdressValidationService adressValidationService = new AdressValidationService();
                    List<Optician> opticians = readOpticians(stream);
                    for (Optician optician : opticians) {
                        optician = adressValidationService.validateAdress(optician);
                        optician.setName(Optician.beautifyName(optician.getName()));
                        try {
                            logger.info("wait...");
                            Thread.sleep(1000); // sleep to get no trouble with service quota
                        } catch (InterruptedException ie) {
                            logger.error("uh... unexpected.", ie);
                        }
                        OfyService.ofy().save().entity(optician).now();
                    }
                }
            }
        } catch (Exception ex) {
            throw new ServletException(ex);
        }
    }

    protected static List<Optician> readOpticians(InputStream is) {

        List<Optician> list = new ArrayList<Optician>();

        try {
            LineNumberReader lnr = new LineNumberReader(new InputStreamReader(is, StandardCharsets.UTF_8));
            String line;
            while ((line = lnr.readLine()) != null) {
                logger.info("parsing line: " + line);
                String[] fields = line.split("','");
                Optician optician = new Optician();
                optician.setName(fields[0].substring(1));
                optician.setStreet(fields[1]);
                optician.setPostalcode(Integer.parseInt(fields[2]));
                optician.setCity(fields[3]);
                optician.setCountry(fields[4]);
                optician.setPhone(clearNullValues(fields[5]));
                optician.setFax(clearNullValues(fields[6]));
                optician.setEmail(clearNullValues(fields[7]));
                optician.setWebsite(clearNullValues(fields[8].substring(0, fields[8].length()-1)));
                list.add(optician);
            }
        } catch (IOException ioe) {
            logger.error("Problem on parsing bulk import", ioe);
        }
        return list;
    }

    public static String clearNullValues(String str) {
        return "".equals(str.trim()) ? null : str.trim();
    }
}
