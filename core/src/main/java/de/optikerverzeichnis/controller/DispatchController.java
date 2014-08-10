package de.optikerverzeichnis.controller;


import de.optikerverzeichnis.service.OfyService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Controller
public class DispatchController {

    private static final Log logger = LogFactory.getLog(DispatchController.class);

    @RequestMapping(value = {"/", "/*"})
    public String dispatch(ModelMap model, HttpServletRequest request, HttpServletResponse response) {

        String requestUri = request.getRequestURI();

        if ("/".equals(requestUri)) {
            return "homepage";
        }

        return "homepage";
    }
}
