package com.luckycatlabs.sunrisesunset.api.demo.controller;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.luckycatlabs.sunrisesunset.api.demo.model.AstronomicalInfoWrapper;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class WriteToFile {
    public WriteToFile(Object yazilacak) throws FileNotFoundException {
        ArrayList<AstronomicalInfoWrapper> astronomicalInfoWrappers = new ArrayList<>();
        astronomicalInfoWrappers.add((AstronomicalInfoWrapper) yazilacak);
        Gson gson = new Gson();
        String s = gson.toJson(astronomicalInfoWrappers);
        try {
            File file = new File("C:/Users/asus/Desktop/job/sonuc.json");
            FileWriter fileWriter = new FileWriter(file, true);
            fileWriter.write(s);
            fileWriter.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //File reader starts
        File myObj = new File("C:/Users/asus/Desktop/job/sonuc.json");
        final Type REVIEW_TYPE = new TypeToken<List<AstronomicalInfoWrapper>>() {
        }.getType();
        JsonReader reader = new JsonReader(new FileReader(myObj));
        List<AstronomicalInfoWrapper> data = gson.fromJson(reader, REVIEW_TYPE); // contains the whole reviews list
        for (int i = 0; i < data.size(); i++) {
            for (int j = 0; j < data.size(); j++) {
                System.out.println(data.get(i).getMoonRise());
            }
        }
        //File reader ends
    }
}
