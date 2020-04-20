package com.luckycatlabs.sunrisesunset.api.demo.CountryList;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.luckycatlabs.sunrisesunset.api.demo.model.test.LatLngModel;
import org.json.simple.JSONArray;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CountryList {
    public List<LatLngModel> countryBring(JSONArray array) {
        List<LatLngModel> arr = new ArrayList<>();
        int limit = 0;
        Random random = new Random();
        int c = random.nextInt(5);
        int d = random.nextInt(20);
        List list = array.subList(c, d);
        for (int a = 0; a < list.size(); a++) {
            //5 ülkeye ait bilgi döndürüyor
//            if (limit < 5) {
                Gson gson = new Gson();
                String text = gson.toJson(array.get(a));
                JsonObject jsonObject = new Gson().fromJson(text, JsonObject.class);
                JsonArray jsonArray = new Gson().fromJson(gson.toJson(jsonObject.get("latlng")), JsonArray.class);
                String ar3 = gson.toJson(jsonArray);
                System.out.println(ar3);
                String[] parts = ar3.split(",");

                if (parts.length == 2) {
                    LatLngModel latLngModel = new LatLngModel(parts[0].replace("[", ""), parts[1].replace("]", ""));
                    arr.add(latLngModel);
                } else {
                    System.out.println("Bir hata oldu!");
                }
//            }
//            limit++;
        }
        return arr;
    }
}
