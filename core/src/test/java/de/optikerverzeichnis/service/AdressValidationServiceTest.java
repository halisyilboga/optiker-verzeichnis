package de.optikerverzeichnis.service;

import de.optikerverzeichnis.entity.Optician;
import org.junit.Test;

import static org.junit.Assert.*;

public class AdressValidationServiceTest {

    @Test
    public void testValidateAdress() throws Exception {
        Optician optician = new Optician();
        optician.setStreet("FELDSTR. 63");
        optician.setPostalcode(19386);
        optician.setCity("LUEBZ/MECKL.");
        optician.setCountry("D");

        AdressValidationService adressValidationService = new AdressValidationService();
        Optician opticianValidated = adressValidationService.validateAdress(optician);

        System.out.println("Optician: " + optician.toString());

        assertNotNull(opticianValidated);
        assertNotNull(opticianValidated.getMapsCity());
        assertNotNull(opticianValidated.getMapsCountry());
        assertNotNull(opticianValidated.getMapsLatitude());
        assertNotNull(opticianValidated.getMapsLongitude());
        assertNotNull(opticianValidated.getMapsPostalCode());
        assertNotNull(opticianValidated.getMapsState());
        assertNotNull(opticianValidated.getMapsStreet());
        assertNotNull(opticianValidated.getMapsStreetNumber());
    }
}