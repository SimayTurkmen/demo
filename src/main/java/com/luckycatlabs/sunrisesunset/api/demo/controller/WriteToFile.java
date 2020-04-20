package com.luckycatlabs.sunrisesunset.api.demo.controller;

import com.google.gson.Gson;
import com.luckycatlabs.sunrisesunset.api.demo.models.SunPositionModel;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class WriteToFile {
    public WriteToFile(Object yazilacak) {
        ArrayList<SunPositionModel> sunPositionModels = new ArrayList<>();
        sunPositionModels.add((SunPositionModel) yazilacak);
        Gson gson = new Gson();
        String s = gson.toJson(sunPositionModels);
//        ArrayList<Object> objects = new ArrayList<>();
        try {
//            Scanner myReader = new Scanner(sunPositionModels.toString());
//            for (int i = 0; i < s.length(); i++) {
            File file = new File("C:/Users/asus/Desktop/job/sonuc.json");
            FileWriter fileWriter = new FileWriter(file, true);
            fileWriter.write(s);
            fileWriter.close();
//                System.out.println(data);
//            }
//            while (myReader.hasNextLine()) {
//                String data = myReader.nextLine();
//                objects.add(data);
//                File file = new File("C:/Users/asus/Desktop/job/sonuc.json");
//                FileWriter fileWriter = new FileWriter(file, true);
//                fileWriter.write(String.valueOf(objects));
//                fileWriter.close();
//                System.out.println(data);
//            }
//            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
