package com.luckycatlabs.sunrisesunset.api.demo.sunCalculator;

import com.luckycatlabs.sunrisesunset.api.demo.models.SunPositionModel;
import com.luckycatlabs.sunrisesunset.api.demo.models.SunPositionModelWrapper;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class TimeConverter {
    public SunPositionModelWrapper timeConvert(SunPositionModel sunPositionModel) {
        Double latitude = sunPositionModel.getLatitude();
        Double longitude = sunPositionModel.getLongitude();
        Date sunrise = sunPositionModel.getSunrise();
        Date sunset = sunPositionModel.getSunset();
        Date moonRise = sunPositionModel.getMoonRise();
        Date dayTime = sunPositionModel.getDayTime();
        Date nextNewMoon = sunPositionModel.getNextNewMoon();
        Date nextFullMoon = sunPositionModel.getNextFullMoon();
        Double moonAzimuth = sunPositionModel.getMoonAzimuth();
        Double moonAltitude = sunPositionModel.getMoonAltitude();
        Double moonDistance = sunPositionModel.getMoonDistance();


        double moonVisualPercentage = sunPositionModel.getMoonVisualPercentage();

        long sunriseTime = sunrise.getTime();
        long sunsetTime = sunset.getTime();
        long moonRiseTime = moonRise.getTime();
        long dayTimeTime = dayTime.getTime();
        long newMoonTime = nextNewMoon.getTime();
        long nextFullMoonTime = nextFullMoon.getTime();

        LocalDateTime ldt =
                LocalDateTime.ofInstant(Instant.ofEpochMilli(sunriseTime), ZoneId.systemDefault());
        LocalDateTime ldt1 =
                LocalDateTime.ofInstant(Instant.ofEpochMilli(sunsetTime), ZoneId.systemDefault());
        LocalDateTime ldt2 =
                LocalDateTime.ofInstant(Instant.ofEpochMilli(moonRiseTime), ZoneId.systemDefault());
        LocalDateTime ldt4 =
                LocalDateTime.ofInstant(Instant.ofEpochMilli(dayTimeTime), ZoneId.systemDefault());
        LocalDateTime ldt5 =
                LocalDateTime.ofInstant(Instant.ofEpochMilli(newMoonTime), ZoneId.systemDefault());
        LocalDateTime ldt6 =
                LocalDateTime.ofInstant(Instant.ofEpochMilli(nextFullMoonTime), ZoneId.systemDefault());

        SunPositionModelWrapper sunPositionModelWrapper = new SunPositionModelWrapper();
        sunPositionModelWrapper.setLatitude(latitude);
        sunPositionModelWrapper.setLongitude(longitude);
        sunPositionModelWrapper.setSunrise(ldt);
        sunPositionModelWrapper.setSunset(ldt1);
        sunPositionModelWrapper.setMoonRise(ldt2);
        sunPositionModelWrapper.setMoonSet(sunPositionModel.getMoonSet());
        sunPositionModelWrapper.setDayTime(ldt4);
        sunPositionModelWrapper.setMoonVisualPercentage(moonVisualPercentage);
        sunPositionModelWrapper.setNextNewMoon(ldt5);
        sunPositionModelWrapper.setNextFullMoon(ldt6);
        sunPositionModelWrapper.setMoonAzimuth(Math.round(moonAzimuth * 100.0) / 100.0);
        sunPositionModelWrapper.setMoonAltitude(Math.round(moonAltitude * 100.0) / 100.0);
        sunPositionModelWrapper.setMoonDistance(Math.round(moonDistance * 100.0) / 100.0);

        return sunPositionModelWrapper;
    }
}