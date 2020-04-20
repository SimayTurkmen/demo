package com.luckycatlabs.sunrisesunset.api.demo.RandomDateGenerator;

import com.google.gson.JsonObject;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class RandomDate {
    public LocalDate randomDateGenerateAndWrite() {
        ArrayList<Object> randomDates = new ArrayList<>();
//        for (int i = 0; i < 10; i++) {
            LocalDate randomDate = createRandomDate(1900, 2020);
            randomDates.add(randomDate);
            writeToFile(randomDates);
//        }
        return randomDate;
    }

    public static int createRandomIntBetween(int start, int end) {
        return start + (int) Math.round(Math.random() * (end - start));
    }

    public static LocalDate createRandomDate(int startYear, int endYear) {
        int day = createRandomIntBetween(1, 28);
        int month = createRandomIntBetween(1, 12);
        int year = createRandomIntBetween(startYear, endYear);
        return LocalDate.of(year, month, day);
    }

    public static void writeToFile(ArrayList<Object> dates) {
        FileWriter fileWriter = null;
        JSONObject jsonObject = new JSONObject();
        for (int i=0;i<dates.size();i++){

        }


        JSONArray jsonArray1 = new JSONArray();
        jsonArray1.add(dates);
        try {
            fileWriter = new FileWriter("C:/Users/asus/Desktop/job/dates.json");
            fileWriter.write(jsonArray1.toJSONString());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileWriter != null) {
                    fileWriter.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
