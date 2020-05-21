package com.luckycatlabs.sunrisesunset.api.demo.api;

import com.luckycatlabs.sunrisesunset.api.demo.controller.WriteToFile;
import com.luckycatlabs.sunrisesunset.api.demo.model.AstronomicalInfoModel;
import com.luckycatlabs.sunrisesunset.api.demo.model.AstronomicalInfoWrapper;
import com.luckycatlabs.sunrisesunset.api.demo.service.SonarSystemService;
import com.luckycatlabs.sunrisesunset.api.demo.controller.TimeConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.text.ParseException;
import java.time.OffsetDateTime;
import java.util.Map;

@RestController
@RequestMapping("abc")
public class SonarController {
    private static final Logger LOGGER = LoggerFactory.getLogger(SonarController.class);
    @Autowired
    private SonarSystemService sonarSystemService;


    public static final int SECOND_MILLIS = 1000;
    public static final int MINUTE_MILLIS = 60 * SECOND_MILLIS;
    public static final int HOUR_MILLIS = 60 * MINUTE_MILLIS;

    @Autowired
    RestTemplate restTemplate;

    Map<String, Object> params;

    public SonarController(SonarSystemService sonarSystemService) {
        this.sonarSystemService = sonarSystemService;
    }

    public SonarController() {
    }

    @PostConstruct
    public void init() throws Exception {
    }

//    @GetMapping("/getSunRiseTime")
//    public LocalDateTime getSunRiseTime(String date, double lat, double lon) throws ParseException {
//        OffsetDateTime offsetDateTime = OffsetDateTime.parse(date);
//        long millis = offsetDateTime.toInstant().toEpochMilli();
//
//        SunPositionModel solarModelForDate = sonarSystemService.
//                getSolarModelForDate(millis, lat, lon);
//        Date sunrise = solarModelForDate.getSunrise();
//        long sunriseTime = sunrise.getTime();
//        LocalDateTime ldtSunRise =
//                LocalDateTime.ofInstant(Instant.ofEpochMilli(sunriseTime), ZoneId.systemDefault());
//        return ldtSunRise;
//    }
//
//    @GetMapping("/getSunSetTime")
//    public LocalDateTime getSunSetTime(String date, double lat, double lon) throws ParseException {
//        OffsetDateTime offsetDateTime = OffsetDateTime.parse(date);
//        long millis = offsetDateTime.toInstant().toEpochMilli();
//
//        SunPositionModel solarModelForDate = sonarSystemService.
//                getSolarModelForDate(millis, lat, lon);
//        Date sunset = solarModelForDate.getSunset();
//        long sunsetTime = sunset.getTime();
//        LocalDateTime ldtSunSet =
//                LocalDateTime.ofInstant(Instant.ofEpochMilli(sunsetTime), ZoneId.systemDefault());
//        return ldtSunSet;
//    }
//
//    @GetMapping("/getDayLength")
//    public LocalDateTime getDayLength(String date, double lat, double lon) throws ParseException {
//        OffsetDateTime offsetDateTime = OffsetDateTime.parse(date);
//        long millis = offsetDateTime.toInstant().toEpochMilli();
//        SunPositionModel solarModelForDate = sonarSystemService.
//                getSolarModelForDate(millis, lat, lon);
//        Date dayTime = solarModelForDate.getDayTime();
//        long time = dayTime.getTime();
//        LocalDateTime ldt =
//                LocalDateTime.ofInstant(Instant.ofEpochMilli(time), ZoneId.systemDefault());
//
//        return ldt;
//    }
//
//    @GetMapping("/getMoonRiseTime")
//    public LocalDateTime getMoonRiseTime(String date, double lat, double lon) throws ParseException {
//        OffsetDateTime offsetDateTime = OffsetDateTime.parse(date);
//        long millis = offsetDateTime.toInstant().toEpochMilli();
//        SunPositionModel solarModelForDate = sonarSystemService.
//                getSolarModelForDate(millis, lat, lon);
//        Date moonRise = solarModelForDate.getMoonRise();
//        long time = moonRise.getTime();
//        LocalDateTime ldt =
//                LocalDateTime.ofInstant(Instant.ofEpochMilli(time), ZoneId.systemDefault());
//
//        return ldt;
//    }
//
//    @GetMapping("/getMoonSetTime")
//    public String getMoonSetTime(String date, double lat, double lon) throws ParseException {
//        OffsetDateTime offsetDateTime = OffsetDateTime.parse(date);
//        long millis = offsetDateTime.toInstant().toEpochMilli();
//        SunPositionModel solarModelForDate = sonarSystemService.
//                getSolarModelForDate(millis, lat, lon);
//        String forDateMoonSet = solarModelForDate.getMoonSet();
//        if (forDateMoonSet == "Not Calculated") {
//            solarModelForDate.setMoonSet("Not Calculated");
//        } else {
//            solarModelForDate.setMoonSet(forDateMoonSet);
//        }
//        return forDateMoonSet;
//    }
//
//    @GetMapping("/getMoonVisualPerc")
//    public Double getMoonVisualPercentage(String date, double lat, double lon) throws ParseException {
//        OffsetDateTime offsetDateTime = OffsetDateTime.parse(date);
//        long millis = offsetDateTime.toInstant().toEpochMilli();
//        SunPositionModel solarModelForDate = sonarSystemService.
//                getSolarModelForDate(millis, lat, lon);
//        double moonVisualPercentage = solarModelForDate.getMoonVisualPercentage();
//
//        return moonVisualPercentage;
//    }
//
//    @GetMapping("/getAll")
//    public SunPositionModelWrapper getAll(String date, double lat, double lon) throws ParseException {
//        OffsetDateTime offsetDateTime = OffsetDateTime.parse(date);
//        long millis = offsetDateTime.toInstant().toEpochMilli();
//
//        SunPositionModel solarModelForDate = sonarSystemService.getSolarModelForDate(millis, lat, lon);
//
//        TimeConverter timeConverter = new TimeConverter();
//        SunPositionModelWrapper sunPositionModelWrapper = timeConverter.timeConvert(solarModelForDate);
//
//        WriteToFile writeToFile = new WriteToFile(solarModelForDate);
//
//        return sunPositionModelWrapper;
//    }

    @GetMapping("/getAstronomicalInfo")
    public AstronomicalInfoWrapper getAstronomicalInfo(String date, double lat, double lon) throws ParseException, IOException {
        OffsetDateTime offsetDateTime = OffsetDateTime.parse(date);
        long millis = offsetDateTime.toInstant().toEpochMilli();

        AstronomicalInfoModel astronomicalInfoModel = sonarSystemService.getSolarModelForDate(millis, lat, lon);

        TimeConverter timeConverter = new TimeConverter();
        AstronomicalInfoWrapper astronomicalInfoWrapper = timeConverter.timeConvert(astronomicalInfoModel);

        WriteToFile writeToFile = new WriteToFile(astronomicalInfoWrapper);

        return astronomicalInfoWrapper;
    }
}
