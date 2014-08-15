package de.optikerverzeichnis.entity;

import org.junit.Test;

import static org.junit.Assert.*;

public class OpticianTest {

    @Test
    public void testBeautifyName() throws Exception {
        // Uppercase after space
        assertEquals("Viva Brillenmode Udo Stehr", Optician.beautifyName("VIVA BRILLENMODE UDO STEHR"));

        // Uppercase afer -
        assertEquals("Wenzel-Optik", Optician.beautifyName("WENZEL-OPTIK"));

        // must be same
        assertEquals("Wilke-Optik", Optician.beautifyName("Wilke-Optik"));

        // check abbr.
        assertEquals("Boecker + Schursch Die Optiker GbR.", Optician.beautifyName("BOECKER + SCHURSCH DIE OPTIKER GBR."));
        assertEquals("Brillengalerie Joseph GmbH", Optician.beautifyName("BRILLENGALERIE JOSEPH GMBH"));
    }
}