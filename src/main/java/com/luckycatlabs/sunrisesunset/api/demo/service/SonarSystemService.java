package com.luckycatlabs.sunrisesunset.api.demo.service;

import com.luckycatlabs.sunrisesunset.api.demo.TimezoneMapper;
import com.luckycatlabs.sunrisesunset.api.demo.moonCalculator.MoonFx;
import com.luckycatlabs.sunrisesunset.api.demo.sunCalculator.Location;
import com.luckycatlabs.sunrisesunset.api.demo.sunCalculator.SunriseSunsetCalculator;
import com.luckycatlabs.sunrisesunset.api.demo.models.SunPositionModel;
import com.luckycatlabs.sunrisesunset.api.demo.moonRiseSet.MoonTimes;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

@Service
public class SonarSystemService {
    public SunPositionModel getSolarModelForDate(long utcTimeMillis, double latitude, double longitude) throws ParseException {
        TimeZone timeZone = TimeZone.getTimeZone(ZoneOffset.systemDefault());

        Calendar calendar = Calendar.getInstance(timeZone);
        calendar.setTimeInMillis(utcTimeMillis);

        Location location = new Location(latitude, longitude);

        SunriseSunsetCalculator calculator = new SunriseSunsetCalculator(location, timeZone);

        long officialSunrise = calculator.getOfficialSunriseCalendarForDate(calendar).getTimeInMillis();
        long officialSunset = calculator.getOfficialSunsetCalendarForDate(calendar).getTimeInMillis();

        MoonFx mnf = new MoonFx();

        Instant instant = Instant.ofEpochMilli(utcTimeMillis);
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
        mnf.setDate(localDateTime);
        long moonVisualPercentage = Math.round(mnf.getIlluminatedRatio(mnf.getSynodicPhase()) * 100);

        Instant instant1 = Instant.ofEpochMilli(utcTimeMillis);
        LocalDateTime localDateTime1 = LocalDateTime.ofInstant(instant1, ZoneOffset.UTC);
        Date date = Date.from(localDateTime1.atZone(ZoneId.systemDefault()).toInstant());
        MoonTimes moonTimes = MoonTimes.compute().on(date).at(latitude, longitude).execute();

        SunPositionModel model = new SunPositionModel();

        model.setLatitude(latitude);
        model.setLongitude(longitude);
        model.setSunrise(Date.from(Instant.ofEpochMilli(officialSunrise)));
        model.setSunset(Date.from(Instant.ofEpochMilli(officialSunset)));
        model.setDayTime(Date.from(Instant.ofEpochMilli(officialSunset - officialSunrise - 7200000)));
        model.setMoonVisualPercentage(moonVisualPercentage);
        model.setMoonRise(moonTimes.getRise());
        model.setMoonSet(moonTimes.getSet());

        return model;
    }
}