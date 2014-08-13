package de.optikerverzeichnis.servlet;

import de.optikerverzeichnis.entity.Optician;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;

import static org.junit.Assert.*;

public class FileUploadServletTest {

    @Test
    public void testReadOpticians() throws Exception {

        String file = "'3 B DESIGN','BLUMENSTR.33','71106','MAGSTADT  ','D',' +49 (0)7159 9448550','  ',' ',' '\n" +
                "'Abele Optik GmbH','MAXIMILIANSTR.2','95444','BAYREUTH  ','D',' +49 (0)921 5166793','  ',' serviceline@abele-optik.com',' www.abele-optik.com'\n" +
                "'AHLMANN AUGENOPTIK','FELDSTR. 63','19386','LUEBZ/MECKL.  ','D',' +49 (0)38731 2341','  ',' ',' '\n";
        List<Optician> opticians = FileUploadServlet.readOpticians( new ByteArrayInputStream(file.getBytes(StandardCharsets.UTF_8)));
        assertEquals("wrong size", 3, opticians.size());

        assertNull(opticians.get(0).getWebsite());
        assertNull(opticians.get(0).getEmail());
        assertNull(opticians.get(0).getFax());

        for (Optician optician : opticians) {
            System.out.println(optician.toString());
        }
    }
}