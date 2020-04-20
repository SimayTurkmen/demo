//package com.luckycatlabs.sunrisesunset.api.demo.service;
//
//import com.luckycatlabs.sunrisesunset.api.demo.model.DayLengthInfo;
//import com.luckycatlabs.sunrisesunset.api.demo.model.LocationInfo;
//import com.luckycatlabs.sunrisesunset.api.demo.model.MoonInfo;
//import com.luckycatlabs.sunrisesunset.api.demo.model.SunInfo;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//
//@Service
//public class MainService {
//    @Autowired
//    MoonInfo moonInfo;
//
//    @Autowired
//    DayLengthInfo dayLengthInfo;
//
//    public SunInfo getSunRiseInfo(String date, double latitude, double longitude) throws ParseException {
//        SunInfo sunInfo = new SunInfo();
//
//        Date convertedDate = new SimpleDateFormat("yyyy-dd-mm").parse(date);
//        sunInfo.setDate(convertedDate);
//
//        LocationInfo locationInfo = new LocationInfo();
//        locationInfo.setLatitude(latitude);
//        locationInfo.setLongitude(longitude);
//        sunInfo.setLocationInfo(locationInfo);
////        sunInfo.setSun_rise();
//        return sunInfo;
//    }
//
//    public SunInfo getSunSetInfo(Date date, double latitude, double longitude) {
//        SunInfo sunInfo = new SunInfo();
//        sunInfo.setDate(date);
//        LocationInfo locationInfo = new LocationInfo();
//        locationInfo.setLatitude(latitude);
//        locationInfo.setLongitude(longitude);
//        sunInfo.setLocationInfo(locationInfo);
////        sunInfo.setSun_rise();
//        return sunInfo;
//    }
//
//    public MoonInfo getMoonRiseInfo() {
//        return moonInfo;
//    }
//
//    public MoonInfo getMoonSetInfo() {
//        return moonInfo;
//    }
//
//    public DayLengthInfo getDayLengthInfo() {
//        return dayLengthInfo;
//    }
//}
