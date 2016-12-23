/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mikenhill.java.json;

import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;



/**
 *
 * @author mhill
 */
public class JSONJava {
    private static final String uberToken = "{\n" +
"  \"UberToken\": {\n" +
"    \"WCToken\": \"24701%2C%2B1xIpiLIXday742eodBJS6r1tYR52NlUhWo1%2FaDBm1Q%2F9hzbDIV03lU70cAD3Mfu3c4UWfVs%2FVftxIxHbx4Z0dnLyl4TDIX88exQ%2F4PiMdv9pSxEqb9I5LVILrXSWe8CObHnvAcVFTlY9qEsWYTayAThsodaKWSe5PVALlAsZo1G2i3CeptjXaz%2FhlcD5AzJmnMuHWmLOgaQyHosd5U4EfzLUkVYUU5B%2BCcvKBo%2FKm4%3D\",\n" +
"    \"userId\": \"24701\",\n" +
"    \"WCTrustedToken\": \"24701%2CtMKSaONAu5TUTfKfqh2%2BKp78EmTu0wKXwWeaVd0of5g%3D\",\n" +
"    \"personalizationID\": \"1482157639241-1\"\n" +
"  }\n" +
"}";
    
    private static final String payLoad = "{\n" +
"  \"WCToken\": \"24701%2CSRDpjZKa2%2FspO0dvLsXTETp4BshjdwClriwyp4QldvcqYLQUQhbMSI%2Fj1hpNuRI3%2FRSQ%2BOZShIiti8WS2OqWtCC35S858WAilQcpn24ZCXINX2cOiGS4uemo5i90FCqH0bMQzTg5kW6%2FuQmLrgbYb58MIZ3jE2VNbE5iL7oOtcOjosTqvpKfK%2B6m%2FNdWIdU9ZEPJc8nDXq%2BiVIpIUzyPkNXCuBZu00la2LTYrK%2BEw8M%3D\",\n" +
"  \"userId\": \"24701\",\n" +
"  \"WCTrustedToken\": \"24701%2CxBmmeT9Vafi7ESrlFHSlglkycadhx0yZjCkipey9dBw%3D\",\n" +
"  \"personalizationID\": \"1482157639241-1\"\n" +
"}";
    
    private static final String jsonData = "{\n" +
"    \"name\": \"Alice\",\n" +
"    \"age\": 20,\n" +
"    \"address\": {\n" +
"        \"streetAddress\": \"100 Wall Street\",\n" +
"        \"city\": \"New York\"\n" +
"    },\n" +
"    \"phoneNumber\": [\n" +
"        {\n" +
"            \"type\": \"home\",\n" +
"            \"number\": \"212-333-1111\"\n" +
"        },{\n" +
"            \"type\": \"fax\",\n" +
"            \"number\": \"646-444-2222\"\n" +
"        }\n" +
"    ]\n" +
"}";
    
    public static void main (String[] args) {
        JSONJava jsonJava = new JSONJava();
        try {
            jsonJava.processJSON3();
          
        } catch (Exception pe) {
            System.out.println (pe.getMessage());
        }
    }
    
    private void processJSON3 () throws Exception {
        JSONParser parser = new JSONParser();
        JSONObject jsonObject = (JSONObject)parser.parse(jsonData);
        System.out.println ("1 -> " + jsonObject);
    }
    
    private void processJSON2 () throws Exception {
        //This example unpacks the UberToken
        //Step 1 - Parse the Uber
        JSONParser parser = new JSONParser();
        JSONObject jsonObject = (JSONObject)parser.parse(uberToken);
        System.out.println ("1 -> " + jsonObject);
        
        JSONObject objUberToken = (JSONObject)jsonObject.get("UberToken");
        for (Object childObj : objUberToken.keySet()) {
            Object childObj2 = objUberToken.get(childObj);
            System.out.println(childObj + "-> " + childObj2);
            
        }
        
    }
    
    private void processJSON () throws Exception {
        JSONParser parser = new JSONParser();
        
        Object resultObject = parser.parse(payLoad);

        if (resultObject instanceof JSONArray) {
            System.out.println ("JSONArray");
        }else if (resultObject instanceof JSONObject) {
            System.out.println ("JSONObject");
            JSONObject obj =(JSONObject)resultObject;
            System.out.println(obj.get("personalizationID"));
            
            //Create a new JSON object
            JSONObject newObj = new JSONObject();
            //newObj.put(resultObject, resultObject)
            
        }

        //Write out the starting position
        System.out.println (resultObject.toString());
        //Now add the Uber elements
        JSONObject uberToken2 = new JSONObject();
        uberToken2.put("UberToken", resultObject);
        System.out.println (uberToken2);
        
        
    }
    
}
