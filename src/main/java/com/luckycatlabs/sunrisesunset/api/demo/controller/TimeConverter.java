package com.luckycatlabs.sunrisesunset.api.demo.controller;

import com.luckycatlabs.sunrisesunset.api.demo.model.AstronomicalInfoModel;
import com.luckycatlabs.sunrisesunset.api.demo.model.AstronomicalInfoWrapper;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class TimeConverter {
    public AstronomicalInfoWrapper timeConvert(AstronomicalInfoModel astronomicalInfoModel) {
        Double latitude = astronomicalInfoModel.getLatitude();
        Double longitude = astronomicalInfoModel.getLongitude();
        Date sunrise = astronomicalInfoModel.getSunrise();
        Date sunset = astronomicalInfoModel.getSunset();
        Date moonRise = astronomicalInfoModel.getMoonRise();
        Date dayTime = astronomicalInfoModel.getDayTime();

//        Date nextNewMoon = sunPositionModel.getNextNewMoon();
//        Date nextFullMoon = sunPositionModel.getNextFullMoon();
//        Double moonAzimuth = sunPositionModel.getMoonAzimuth();
//        Double moonAltitude = sunPositionModel.getMoonAltitude();
//        Double moonDistance = sunPositionModel.getMoonDistance();

        long twilight_start = astronomicalInfoModel.getTwilight_begin().getTime();
        long twilight_end = astronomicalInfoModel.getTwilight_end().getTime();


        double moonVisualPercentage = astronomicalInfoModel.getMoonVisualPercentage();

        long sunriseTime = sunrise.getTime();
        long sunsetTime = sunset.getTime();
        long moonRiseTime = moonRise.getTime();
        long dayTimeTime = dayTime.getTime();
//        long newMoonTime = nextNewMoon.getTime();
//        long nextFullMoonTime = nextFullMoon.getTime();

        LocalDateTime ldt =
                LocalDateTime.ofInstant(Instant.ofEpochMilli(sunriseTime), ZoneId.systemDefault());

        LocalDateTime ldt1 =
                LocalDateTime.ofInstant(Instant.ofEpochMilli(sunsetTime), ZoneId.systemDefault());

        LocalDateTime ldt2 =
                LocalDateTime.ofInstant(Instant.ofEpochMilli(moonRiseTime), ZoneId.systemDefault());

        LocalDateTime ldt4 =
                LocalDateTime.ofInstant(Instant.ofEpochMilli(dayTimeTime), ZoneId.systemDefault());

//        LocalDateTime ldt5 =
//                LocalDateTime.ofInstant(Instant.ofEpochMilli(newMoonTime), ZoneId.systemDefault());
//
//        LocalDateTime ldt6 =
//                LocalDateTime.ofInstant(Instant.ofEpochMilli(nextFullMoonTime), ZoneId.systemDefault());

        LocalDateTime ldtTwilightBegin =
                LocalDateTime.ofInstant(Instant.ofEpochMilli(twilight_start), ZoneId.systemDefault());

        LocalDateTime ldtTwilightEnd =
                LocalDateTime.ofInstant(Instant.ofEpochMilli(twilight_end), ZoneId.systemDefault());

        AstronomicalInfoWrapper astronomicalInfoWrapper = new AstronomicalInfoWrapper();

        astronomicalInfoWrapper.setLatitude(latitude);
        astronomicalInfoWrapper.setLongitude(longitude);
        astronomicalInfoWrapper.setSunrise(ldt);
        astronomicalInfoWrapper.setSunset(ldt1);
        astronomicalInfoWrapper.setDayTime(ldt4);

        astronomicalInfoWrapper.setTwilight_begin(ldtTwilightBegin);
        astronomicalInfoWrapper.setTwilight_end(ldtTwilightEnd);

        astronomicalInfoWrapper.setMoonRise(ldt2);
        astronomicalInfoWrapper.setMoonSet(astronomicalInfoModel.getMoonSet());
        astronomicalInfoWrapper.setMoonVisualPercentage(moonVisualPercentage);
//        sunPositionModelWrapper.setNextNewMoon(ldt5);
//        sunPositionModelWrapper.setNextFullMoon(ldt6);
//        sunPositionModelWrapper.setMoonAzimuth(Math.round(moonAzimuth * 100.0) / 100.0);
//        sunPositionModelWrapper.setMoonAltitude(Math.round(moonAltitude * 100.0) / 100.0);
//        sunPositionModelWrapper.setMoonDistance(Math.round(moonDistance * 100.0) / 100.0);
//        sunPositionModelWrapper.setAstronomicalInfoWrapper(astronomicalInfoWrapper);

        return astronomicalInfoWrapper;
    }
}