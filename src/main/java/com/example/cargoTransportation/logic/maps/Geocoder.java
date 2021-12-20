package com.example.cargoTransportation.logic.maps;


import org.json.JSONArray;
import org.json.JSONObject;
import org.testcontainers.shaded.okhttp3.OkHttpClient;
import org.testcontainers.shaded.okhttp3.Request;
import org.testcontainers.shaded.okhttp3.Response;

import java.io.IOException;

public class Geocoder {

    private final static String apiKey = "a5fb2166-83c8-4b50-9e06-bdbc43976fd6";

    public static String getCoordinates(String address){
        double latitude = -1;
        double longitude = -1;
        String result = null;
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://graphhopper.com/api/1/geocode?q=" + address + "&locale=de&debug=true&key=" + apiKey)
                .get()
                .build();
        Response response = null;
        try{
          response = client.newCall(request).execute();;
          String jsonString = response.body().string();
          result = parseJson(jsonString);
        }catch(IOException ex){
            ex.printStackTrace();
        }
        return result;
    }

    private static String parseJson(String jsonResponse){
        double latitude = -1;
        double longitude = -1;
        JSONObject jsonObject = new JSONObject(jsonResponse);
        JSONObject hit = jsonObject.getJSONArray("hits").getJSONObject(0);
        latitude = hit.getJSONObject("point").getDouble("lat");
        longitude = hit.getJSONObject("point").getDouble("lng");
        String result = latitude + "," + longitude;
        System.out.println(String.format("Parsed response from Geocoder: %s", result));
        return result;
    }
}
