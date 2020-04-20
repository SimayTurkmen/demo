package com.luckycatlabs.sunrisesunset.api.demo.sunCalculator;

import com.luckycatlabs.sunrisesunset.api.demo.models.SunPositionModel;
import com.luckycatlabs.sunrisesunset.api.demo.models.SunPositionModelWrapper;

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
        Date moonSet = sunPositionModel.getMoonSet();
        Date dayTime = sunPositionModel.getDayTime();

        long sunriseTime = sunrise.getTime();
        long sunsetTime = sunset.getTime();
        long moonRiseTime = moonRise.getTime();
        long moonSetTime = moonSet.getTime();
        long dayTimeTime = dayTime.getTime();

        LocalDateTime ldt =
                LocalDateTime.ofInstant(Instant.ofEpochMilli(sunriseTime), ZoneId.systemDefault());
        LocalDateTime ldt1 =
                LocalDateTime.ofInstant(Instant.ofEpochMilli(sunsetTime), ZoneId.systemDefault());
        LocalDateTime ldt2 =
                LocalDateTime.ofInstant(Instant.ofEpochMilli(moonRiseTime), ZoneId.systemDefault());
        LocalDateTime ldt3 =
                LocalDateTime.ofInstant(Instant.ofEpochMilli(moonSetTime), ZoneId.systemDefault());
        LocalDateTime ldt4 =
                LocalDateTime.ofInstant(Instant.ofEpochMilli(dayTimeTime), ZoneId.systemDefault());

        SunPositionModelWrapper sunPositionModelWrapper = new SunPositionModelWrapper();
        sunPositionModelWrapper.setLatitude(latitude);
        sunPositionModelWrapper.setLongitude(longitude);
        sunPositionModelWrapper.setSunrise(ldt);
        sunPositionModelWrapper.setSunset(ldt1);
        sunPositionModelWrapper.setMoonRise(ldt2);
        sunPositionModelWrapper.setMoonSet(ldt3);
        sunPositionModelWrapper.setDayTime(ldt4);

        return sunPositionModelWrapper;
    }
}