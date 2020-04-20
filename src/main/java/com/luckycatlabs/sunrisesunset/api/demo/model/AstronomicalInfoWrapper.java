package com.luckycatlabs.sunrisesunset.api.demo.model;

import lombok.Data;

@Data
public class AstronomicalInfoWrapper {
    LocationInfo location;
    String date;
    String sunrise;
    String sunset;
    String moonrise;
    String moonset;
    String solar_noon;
    String day_length;

}
