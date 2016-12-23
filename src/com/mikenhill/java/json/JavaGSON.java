/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mikenhill.java.json;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author mhill
 */
public class JavaGSON {
    public Gson gson;
    public static final String jsonData = "{\n" +
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
        JavaGSON javaGson = new JavaGSON();
        try {
            Gson gson = new Gson();
            javaGson.gson = gson;
            javaGson.processJSON();
          
        } catch (Exception pe) {
            System.out.println (pe.getMessage());
        }
    }
    
    private void processJSON () throws Exception {
        JsonObject parentObject = gson.fromJson(jsonData, JsonObject.class);
        processJSONObject(parentObject);
    }
    
    private void processJSONArray (JsonArray obj) throws Exception {
        System.out.println ("JsonArray -> " + obj);
         for (JsonElement element : obj) {
            if (element instanceof JsonPrimitive) {
                
                processJSONPrimitive((JsonPrimitive)element);
                
            } else if (element instanceof JsonArray) {
                
                processJSONArray((JsonArray)element);
                
            } else if (element instanceof JsonObject) {
                
                processJSONObject((JsonObject)element);
                
            } else {
                System.out.println ("Unknown -> " + element);
            }
        }
    }
    
    private void processJSONPrimitive (JsonPrimitive obj) throws Exception {
        System.out.println ("JsonPrimitive -> " + obj);
    }
    
    private void processJSONObject (JsonObject obj) throws Exception {
        
        System.out.println ("JsonObject -> " + obj);
        
        Set<Map.Entry<String, JsonElement>> entrySet = obj.entrySet();
        for(Map.Entry<String, JsonElement> entry : entrySet) {
            //System.out.println ("entry -> " + entry);
            JsonElement element = entry.getValue();
            if (element instanceof JsonPrimitive) {
                
                processJSONPrimitive((JsonPrimitive)element);
                
            } else if (element instanceof JsonArray) {
                
                processJSONArray((JsonArray)element);
                
            } else if (element instanceof JsonObject) {
                
                processJSONObject((JsonObject)element);
                
            } else {
                System.out.println ("Unknown -> " + element);
            }
            int gg = 0;
        } 
        
        //Get the first address city value
        
        
        
        //Iterate over all objects
//        for (Object o : parentObject.) {
//            //Look at each type
//            if (o instanceof JsonElement) {
//                System.out.println ("0 -> " + o);
//            }
//        }
        
        //Now select by name
        //JsonElement addressObj = parentObject.get("address");
        //System.out.println (addressObj.  "address -> " + addressObj);
        
        
        //System.out.println ("1 -> " + parentObject);
    }
}
