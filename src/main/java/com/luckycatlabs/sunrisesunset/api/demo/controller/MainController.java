//package com.luckycatlabs.sunrisesunset.api.demo.controller;
//
//import com.luckycatlabs.sunrisesunset.api.demo.CountryList.CountryList;
//import com.luckycatlabs.sunrisesunset.api.demo.RandomDateGenerator.RandomDate;
//import com.luckycatlabs.sunrisesunset.api.demo.model.AstronomicalInfo;
//import com.luckycatlabs.sunrisesunset.api.demo.model.SunInfo;
//import com.luckycatlabs.sunrisesunset.api.demo.model.test.LatLngModel;
//import com.luckycatlabs.sunrisesunset.api.demo.service.MainService;
//import com.luckycatlabs.sunrisesunset.api.demo.sunCalculator.Location;
//import org.json.simple.JSONArray;
//import org.json.simple.parser.ParseException;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.client.RestTemplate;
//
//import java.io.*;
//import java.time.LocalDate;
//import java.time.OffsetDateTime;
//import java.util.List;
//
//@RestController
//public class MainController {
//    @Autowired
//    RestTemplate restTemplate;
//
//    @Autowired
//    MainService mainService;
//
//    @GetMapping("/getSunRise")
//    @ResponseBody
//    public String getSunRiseInfo(@RequestParam Double lat, @RequestParam Double lng, @RequestParam String date) throws java.text.ParseException {
//        //todo:burada bir model dönecek bu modelin get ile sunrise  bilgisi dönecek.
//        SunInfo sunRiseInfo = mainService.getSunRiseInfo(date,lat,lng);
//        String sun_rise = sunRiseInfo.getSun_rise();
//
//        return sun_rise;
//    }
//
//    @GetMapping("/getSunSet")
//    @ResponseBody
//    public String getSunSetInfo(@RequestParam Double lat, @RequestParam Double lng, @RequestParam String date) {
//        //todo:burada bir model dönecek bu modelin get ile sunset bilgisi dönecek.
//
//        return "sunsetINFO!";
//    }
//
//    @GetMapping("/getMoonRise")
//    @ResponseBody
//    public String getMoonRiseInfo(@RequestParam Double lat, @RequestParam Double lng, @RequestParam String date) {
//        //todo:burada bir model dönecek bu modelin get ile moonrise  bilgisi dönecek.
//
//        return "moonriseINFO";
//    }
//
//    @GetMapping("/getMoonSet")
//    @ResponseBody
//    public String getMoonSetInfo(@RequestParam Double lat, @RequestParam Double lng, @RequestParam String date) {
//        //todo:burada bir model dönecek bu modelin get ile  sunset bilgisi dönecek.
//
//        return "moonsetINFO";
//    }
//
//
//    @GetMapping("/getDay")
//    @ResponseBody
//    public String getDayLengthInfo(@RequestParam Double lat, @RequestParam Double lng, @RequestParam String date) {
//        //todo:burada bir model dönecek bu modelin get ile daylenth bilgisi dönecek.
//
//        return "dayINFO";
//    }
//
//
//    @GetMapping("/info")
//    @ResponseBody
//    public ResponseEntity<AstronomicalInfo> info(@RequestParam Double lat, @RequestParam Double lng, @RequestParam String date) throws IOException, ParseException {
//
//        final String uri = "https://api.ipgeolocation.io/astronomy?apiKey=73dbaa437e154fd5af96e407eb75267c&lat=" + lat + "&long=" + lng + "&date=" + date + "";
//
//        AstronomicalInfo result = restTemplate.getForObject(uri, AstronomicalInfo.class);
//        restTemplate.getForObject(uri, AstronomicalInfo.class);
//        RandomDate randomDate = new RandomDate();
//
//        return ResponseEntity.ok(result);
//    }
//
//
////    @GetMapping("/date")
////    @ResponseBody
////    public String dateGenerate(@RequestParam Double lat, @RequestParam Double lng, @RequestParam String date) throws IOException, ParseException {
////
////        final String uri = "https://api.ipgeolocation.io/astronomy?apiKey=73db" +
////                "aa437e154fd5af96e407eb75267c&lat="
////                + lat + "&long=" + lng + "&date=" + date + "";
////
////        restTemplate.getForObject(uri, AstronomicalInfo.class);
////        RandomDate randomDate = new RandomDate();
////        randomDate.randomDateGenerateAndWrite();
////        return "Date üretildi ve dosyaya yazıldı!";
////    }
////
////    @GetMapping("/country")
////    public List<LatLngModel> countryInfo() throws IOException, ParseException {
////        final String uri = "https://restcountries.eu/rest/v2/all";
////        JSONArray result = restTemplate.getForObject(uri, JSONArray.class);
////        CountryList countryList = new CountryList();
////        List<LatLngModel> latLngModels = countryList.countryBring(result);
////
////        return latLngModels;
////    }
////
////    @GetMapping("/test")
////    @ResponseBody
////    public Object test(@RequestParam Double lat, @RequestParam Double lng, @RequestParam String date) throws IOException {
////        final String uri = "https://api.ipgeolocation.io/astronomy?apiKey=73dbaa437e154fd5af96e407eb75267c&lat=" + lat + "&long=" + lng + "&date=" + date + "";
////        Object result = restTemplate.getForObject(uri, Object.class);
////        WriteToFile fileWrite = new WriteToFile(result);
////        return result;
////    }
////
////    @RequestMapping("/multi")
////    @ResponseBody
////    public String testVerisiOlustur() throws IOException, ParseException {
////        final String country_uri = "https://restcountries.eu/rest/v2/all";
////        JSONArray country_result = restTemplate.getForObject(country_uri, JSONArray.class);
////
////        CountryList countryList = new CountryList();
////        List<LatLngModel> latLngModels = countryList.countryBring(country_result);
////
////        LatLngModel latLngModel = new LatLngModel();
////        for (int i = 0; i < latLngModels.size(); i++) {
////            LatLngModel latLngModel1 = latLngModels.get(i);
////            String lat = latLngModel1.getLat();
////            String lng = latLngModel1.getLng();
////            RandomDate randomDate = new RandomDate();
////            LocalDate localDate = randomDate.randomDateGenerateAndWrite();
////            final String uri = "https://api.ipgeolocation.io/astronomy?apiKey=73dbaa437e154fd5af96e407eb75267c&lat=" + lat + "&long=" + lng + "&date=" + localDate + "";
////            Object result = restTemplate.getForObject(uri, Object.class);
////            WriteToFile fileWrite = new WriteToFile(result);
////        }
////        return "Test Verisi Oluşturuldu!";
////    }
//
//}
