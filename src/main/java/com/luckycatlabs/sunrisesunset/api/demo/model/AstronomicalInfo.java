package com.luckycatlabs.sunrisesunset.api.demo.model;

import lombok.Data;

@Data
public class AstronomicalInfo {
    LocationInfo location;
    String date;
    String sunrise;
    String sunset;
    String moonrise;
    String moonset;
    String solar_noon;
    String day_length;
}
