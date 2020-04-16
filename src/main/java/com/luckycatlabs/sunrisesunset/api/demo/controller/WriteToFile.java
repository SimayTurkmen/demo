package com.luckycatlabs.sunrisesunset.api.demo.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class WriteToFile {
    public WriteToFile(Object yazilacak) {
        ArrayList<Object> objects = new ArrayList<>();
        try {
            Scanner myReader = new Scanner(String.valueOf(yazilacak));
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                objects.add(data);
                File file = new File("C:/Users/asus/Desktop/job/sonuc.json");
                FileWriter fileWriter = new FileWriter(file,true);
                fileWriter.write(String.valueOf(objects));
                fileWriter.close();
                System.out.println(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
