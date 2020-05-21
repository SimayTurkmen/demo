package com.luckycatlabs.sunrisesunset.api.demo.service;

import com.luckycatlabs.sunrisesunset.api.demo.model.AstronomicalInfoModel;
import com.luckycatlabs.sunrisesunset.api.demo.models.SunPositionModel;
import com.luckycatlabs.sunrisesunset.api.demo.moonCalculator.MoonFx;
import com.luckycatlabs.sunrisesunset.api.demo.moonRiseSet.*;
import com.luckycatlabs.sunrisesunset.api.demo.sunCalculator.Location;
import com.luckycatlabs.sunrisesunset.api.demo.sunCalculator.SunriseSunsetCalculator;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

@Service
public class SonarSystemService {
    public AstronomicalInfoModel getSolarModelForDate(long utcTimeMillis, double latitude, double longitude) throws ParseException {
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

        Instant instant1 = Instant.ofEpochMilli(utcTimeMillis);
        LocalDateTime localDateTime1 = LocalDateTime.ofInstant(instant1, ZoneOffset.UTC);
        Date date = Date.from(localDateTime1.atZone(ZoneId.systemDefault()).toInstant());

        MoonTimes moonTimes = MoonTimes.compute().on(date).at(latitude, longitude).execute();

//        SunTimes sunTimes = SunTimes.compute().on(date).at(latitude, longitude).execute();
//        System.out.println("sunrise:" + sunTimes.getRise());
//        System.out.println("sunset:" + sunTimes.getSet());
//        System.out.println("sun nadir" + sunTimes.getNadir());
//        System.out.println("sun noon" + sunTimes.getNoon());
//        System.out.println("moonrise:" + moonTimes.getSet());
//        System.out.println("moonset:" + moonTimes.getRise());

        //Civil twilight begin-end
        AstronomicalInfoModel astronomicalInfo = new AstronomicalInfoModel();

        Calendar[] civilTwilight = TwilightCalculator.getCivilTwilight(calendar, latitude, longitude);
        for (int i = 0; i < civilTwilight.length; i++) {
            astronomicalInfo.setTwilight_begin(Date.from(Instant.ofEpochMilli(civilTwilight[0].getTimeInMillis())));
            astronomicalInfo.setTwilight_end(Date.from(Instant.ofEpochMilli(civilTwilight[1].getTimeInMillis())));
//            System.out.println("Civil twilight" + Date.from(Instant.ofEpochMilli(civilTwilight[i].getTimeInMillis())));
        }

        MoonIllumination moonIllumination = MoonIllumination.compute().on(date).execute();

//        MoonPhase newMoonPhase = MoonPhase.compute().phase(MoonPhase.Phase.NEW_MOON).execute();
//        MoonPhase fullMoonPhase = MoonPhase.compute().phase(MoonPhase.Phase.FULL_MOON).execute();

//        System.out.println(newMoonPhase);
//        System.out.println(fullMoonPhase);

        MoonPosition moonPosition = MoonPosition.compute().on(date).at(latitude, longitude).execute();
//        System.out.println(moonPosition);

        double fraction = moonIllumination.getFraction();
//        System.out.println(fraction * 100);
        long round = Math.round(fraction * 100);

        astronomicalInfo.setLatitude(latitude);
        astronomicalInfo.setLongitude(longitude);
        astronomicalInfo.setSunrise(Date.from(Instant.ofEpochMilli(officialSunrise)));
        astronomicalInfo.setSunset(Date.from(Instant.ofEpochMilli(officialSunset)));
        astronomicalInfo.setDayTime(Date.from(Instant.ofEpochMilli(officialSunset - officialSunrise - 7200000)));
        astronomicalInfo.setMoonRise(moonTimes.getRise());
        astronomicalInfo.setMoonVisualPercentage(round);

//        Date newMoonPhaseTime = newMoonPhase.getTime();
//        model.setNextNewMoon(newMoonPhaseTime);

//        Date fullMoonPhaseTime = fullMoonPhase.getTime();
//        model.setNextFullMoon(fullMoonPhaseTime);
//        model.setMoonAzimuth(moonPosition.getAzimuth());
//        model.setMoonAltitude(moonPosition.getAltitude());
//        model.setMoonDistance(moonPosition.getDistance());
//        model.setAstronomicalInfo(astronomicalInfo);

        if (moonTimes.getSet() == null) {
            astronomicalInfo.setMoonSet("Not Calculated");
        } else {
            Date set = moonTimes.getSet();
            long time = set.getTime();
            LocalDateTime ldt =
                    LocalDateTime.ofInstant(Instant.ofEpochMilli(time), ZoneId.systemDefault());

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String format = ldt.format(formatter);
            astronomicalInfo.setMoonSet(format);
        }
        return astronomicalInfo;
    }
}