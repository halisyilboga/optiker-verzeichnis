package de.optikerverzeichnis.service;

import de.optikerverzeichnis.entity.Optician;
import org.apache.commons.io.IOUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class AdressValidationService {

    public static Log logger = LogFactory.getLog(AdressValidationService.class);

    public Optician validateAdress(Optician optician) {

        try {
            String uri = "http://maps.googleapis.com/maps/api/geocode/json?address=" +
                    URLEncoder.encode(optician.getStreet() + "," +
                            optician.getPostalcode() + " " +
                            optician.getCity() + ",", "UTF-8");

            URL url = new URL(uri);
            String json = IOUtils.toString(url.openStream(), "UTF-8");
            logger.info(json);
            JSONObject obj = new JSONObject(json);
            if (obj.getJSONArray("results").length()==1) {
                JSONObject obj2 = obj.getJSONArray("results").getJSONObject(0);
                logger.info("address_components.length: " + obj2.getJSONArray("address_components").length());
                for (int i=0; i<obj2.getJSONArray("address_components").length(); i++) {
                    JSONObject obj3 = obj2.getJSONArray("address_components").getJSONObject(i);
                    if (jsonArrayContains(obj3.getJSONArray("types"), "street_number")) {
                        optician.setMapsStreetNumber(obj3.getString("long_name"));
                    }
                    if (jsonArrayContains(obj3.getJSONArray("types"), "route")) {
                        optician.setMapsStreet(obj3.getString("long_name"));
                    }
                    if (jsonArrayContains(obj3.getJSONArray("types"), "sublocality_level_2")) {
                        optician.setMapsDistrict(obj3.getString("long_name"));
                    }
                    if (jsonArrayContains(obj3.getJSONArray("types"), "sublocality_level_1")) {
                        optician.setMapsArea(obj3.getString("long_name"));
                    }
                    if (jsonArrayContains(obj3.getJSONArray("types"), "locality")) {
                        optician.setMapsCity(obj3.getString("long_name"));
                    }
                    if (jsonArrayContains(obj3.getJSONArray("types"), "administrative_area_level_1")) {
                        optician.setMapsState(obj3.getString("long_name"));
                    }
                    if (jsonArrayContains(obj3.getJSONArray("types"), "country")) {
                        optician.setMapsCountry(obj3.getString("long_name"));
                    }
                    if (jsonArrayContains(obj3.getJSONArray("types"), "postal_code")) {
                        optician.setMapsPostalCode(obj3.getString("long_name"));
                    }
                }

                optician.setMapsLatitude(obj2.getJSONObject("geometry").getJSONObject("location").getDouble("lat"));
                optician.setMapsLongitude(obj2.getJSONObject("geometry").getJSONObject("location").getDouble("lng"));

            } else {
                logger.warn("Address for " + uri + " has " + obj.getJSONArray("results").length() + "results. SKIPPED.");
            }

        } catch (Exception e) {
            logger.error("problem on retrieving address", e);
        }

        return optician;
    }

    public boolean jsonArrayContains(JSONArray jsonArray, String value) {
        for (int i=0; i<jsonArray.length(); i++) {
            if (jsonArray.getString(i).equals(value)) {
                return true;
            }
        }
        return false;
    }
}
