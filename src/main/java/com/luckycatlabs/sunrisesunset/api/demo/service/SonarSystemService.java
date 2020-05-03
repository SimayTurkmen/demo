package com.luckycatlabs.sunrisesunset.api.demo.service;

import com.luckycatlabs.sunrisesunset.api.demo.TimezoneMapper;
import com.luckycatlabs.sunrisesunset.api.demo.moonCalculator.MoonFx;
import com.luckycatlabs.sunrisesunset.api.demo.moonRiseSet.MoonIllumination;
import com.luckycatlabs.sunrisesunset.api.demo.moonRiseSet.MoonPhase;
import com.luckycatlabs.sunrisesunset.api.demo.moonRiseSet.MoonPosition;
import com.luckycatlabs.sunrisesunset.api.demo.sunCalculator.Location;
import com.luckycatlabs.sunrisesunset.api.demo.sunCalculator.SunriseSunsetCalculator;
import com.luckycatlabs.sunrisesunset.api.demo.models.SunPositionModel;
import com.luckycatlabs.sunrisesunset.api.demo.moonRiseSet.MoonTimes;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
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
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneOffset.UTC);
        mnf.setDate(localDateTime);
//        long moonVisualPercentage = Math.round(mnf.getIlluminatedRatio(mnf.getSynodicPhase()) * 100);

        Instant instant1 = Instant.ofEpochMilli(utcTimeMillis);
        LocalDateTime localDateTime1 = LocalDateTime.ofInstant(instant1, ZoneOffset.UTC);
        Date date = Date.from(localDateTime1.atZone(ZoneId.systemDefault()).toInstant());

        MoonTimes moonTimes = MoonTimes.compute().on(date).at(latitude, longitude).execute();
        MoonIllumination moonIllumination = MoonIllumination.compute().on(date).execute();

        MoonPhase newMoonPhase = MoonPhase.compute().phase(MoonPhase.Phase.NEW_MOON).execute();
        MoonPhase fullMoonPhase = MoonPhase.compute().phase(MoonPhase.Phase.FULL_MOON).execute();

        System.out.println(newMoonPhase);
        System.out.println(fullMoonPhase);

        MoonPosition moonPosition = MoonPosition.compute().on(date).at(latitude, longitude).execute();
        System.out.println(moonPosition);

        double fraction = moonIllumination.getFraction();
        System.out.println(fraction * 100);
        long round = Math.round(fraction * 100);

        SunPositionModel model = new SunPositionModel();

        model.setLatitude(latitude);
        model.setLongitude(longitude);
        model.setSunrise(Date.from(Instant.ofEpochMilli(officialSunrise)));
        model.setSunset(Date.from(Instant.ofEpochMilli(officialSunset)));
        model.setDayTime(Date.from(Instant.ofEpochMilli(officialSunset - officialSunrise - 7200000)));
        model.setMoonRise(moonTimes.getRise());
        model.setMoonVisualPercentage(round);

        Date newMoonPhaseTime = newMoonPhase.getTime();
        model.setNextNewMoon(newMoonPhaseTime);

        Date fullMoonPhaseTime = fullMoonPhase.getTime();
        model.setNextFullMoon(fullMoonPhaseTime);
        model.setMoonAzimuth(moonPosition.getAzimuth());
        model.setMoonAltitude(moonPosition.getAltitude());
        model.setMoonDistance(moonPosition.getDistance());

        if (moonTimes.getSet() == null) {
            model.setMoonSet("Not Calculated");
        } else {
            Date set = moonTimes.getSet();
            long time = set.getTime();
            LocalDateTime ldt =
                    LocalDateTime.ofInstant(Instant.ofEpochMilli(time), ZoneId.systemDefault());

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String format = ldt.format(formatter);
            model.setMoonSet(format);
        }

        return model;
    }
}