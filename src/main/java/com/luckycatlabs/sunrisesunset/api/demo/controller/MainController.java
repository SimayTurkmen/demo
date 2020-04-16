package com.luckycatlabs.sunrisesunset.api.demo.controller;

import com.luckycatlabs.sunrisesunset.api.demo.countrylist.CountryList;
import com.luckycatlabs.sunrisesunset.api.demo.randomdate.RandomDate;
import com.luckycatlabs.sunrisesunset.api.demo.model.AstronomicalInfo;
import com.luckycatlabs.sunrisesunset.api.demo.model.test.LatLngModel;
import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@RestController
public class MainController {
    @Autowired
    RestTemplate restTemplate;

    //Girilen date ve locationa göre AstronomicalInfo bilgisini döner.
    @GetMapping("/info")
    @ResponseBody
    public ResponseEntity<AstronomicalInfo> info(@RequestParam Double lat, @RequestParam Double lng, @RequestParam String date) throws IOException, ParseException {

        final String uri = "https://api.ipgeolocation.io/astronomy?apiKey=73dbaa437e154fd5af96e407eb75267c&lat=" + lat + "&long=" + lng + "&date=" + date + "";

        AstronomicalInfo result = restTemplate.getForObject(uri, AstronomicalInfo.class);
        restTemplate.getForObject(uri, AstronomicalInfo.class);
        RandomDate randomDate = new RandomDate();

        return ResponseEntity.ok(result);
    }

    //Girilen date ve locationa göre AstronomicalInfo bilgisini döner.
    // Ayrıca random date üretip bu dateleri file a yazar.
    @GetMapping("/date")
    @ResponseBody
    public String dateGenerate(@RequestParam Double lat, @RequestParam Double lng, @RequestParam String date) throws IOException, ParseException {

        final String uri = "https://api.ipgeolocation.io/astronomy?apiKey=73db" +
                "aa437e154fd5af96e407eb75267c&lat="
                + lat + "&long=" + lng + "&date=" + date + "";

        restTemplate.getForObject(uri, AstronomicalInfo.class);
        RandomDate randomDate = new RandomDate();
        randomDate.randomDateGenerateAndWrite();
        return "Date üretildi ve dosyaya yazıldı!";
    }

    //Ülke bilgileri bulunan api üzerinden bu ülkelerin konum bilgilerini çeker.
    @GetMapping("/country")
    public List<LatLngModel> countryInfo() throws IOException, ParseException {
        final String uri = "https://restcountries.eu/rest/v2/all";
        JSONArray result = restTemplate.getForObject(uri, JSONArray.class);
        CountryList countryList = new CountryList();
        //Yalnızca konumları çekme işlemi burada olur.
        List<LatLngModel> latLngModels = countryList.countryBring(result);
        return latLngModels;
    }

    //Girilen date ve locationa göre AstronomicalInfo bilgisini döner.
    //Ayrıca dönen her bir response u json formatında dosyaya yazar.
    @GetMapping("/test")
    @ResponseBody
    public Object test(@RequestParam Double lat, @RequestParam Double lng, @RequestParam String date) throws IOException {
        final String uri = "https://api.ipgeolocation.io/astronomy?apiKey=73dbaa437e154fd5af96e407eb75267c&lat=" + lat + "&long=" + lng + "&date=" + date + "";
        Object result = restTemplate.getForObject(uri, Object.class);
        WriteToFile fileWrite = new WriteToFile(result);
        return result;
    }

    //Ülkelere ait konumları api üzerinden çeker ve random date üretilir.
    //Gelen random date ve ülke konumlarına göre apiye istek atar dönen bilgileri dosyaya json formatında yazar.
    @RequestMapping("/multi")
    @ResponseBody
    public String getTestData() throws IOException, ParseException {
        //Ülke bilgisini getirecek api
        final String country_uri = "https://restcountries.eu/rest/v2/all";
        JSONArray country_result = restTemplate.getForObject(country_uri, JSONArray.class);

        CountryList countryList = new CountryList();
        //Api üzerinden ülke konumlarının çekildiği kısım
        List<LatLngModel> latLngModels = countryList.countryBring(country_result);

        LatLngModel latLngModel = new LatLngModel();
        for (int i = 0; i < latLngModels.size(); i++) {
            LatLngModel latLngModel1 = latLngModels.get(i);
            String lat = latLngModel1.getLat();
            String lng = latLngModel1.getLng();
            RandomDate randomDate = new RandomDate();
            LocalDate localDate = randomDate.randomDateGenerateAndWrite();
            //Burada istek yapılacak api ye parametre olarak random date ve location gelir.
            final String uri = "https://api.ipgeolocation.io/astronomy?apiKey=73dbaa437e154fd5af96e407eb75267c&lat=" + lat + "&long=" + lng + "&date=" + localDate + "";
            Object result = restTemplate.getForObject(uri, Object.class);
            //Burada çekilen bilgileri json formatında dosyaya yazar.
            WriteToFile fileWrite = new WriteToFile(result);
        }
        return "Test Verisi Oluşturuldu!";
    }
}
