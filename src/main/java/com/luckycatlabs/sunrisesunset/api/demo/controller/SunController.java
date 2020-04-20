//package com.luckycatlabs.sunrisesunset.api.demo.controller;
//
//import com.luckycatlabs.sunrisesunset.api.demo.RandomDateGenerator.RandomDate;
//import com.luckycatlabs.sunrisesunset.api.demo.model.AstronomicalInfo;
//import org.json.simple.parser.ParseException;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.client.RestTemplate;
//
//import java.io.IOException;
//
//@RestController
//public class SunController {
//    @Autowired
//    RestTemplate restTemplate;
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
//}
