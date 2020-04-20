package com.luckycatlabs.sunrisesunset.api.demo.models;

import java.time.LocalDateTime;
import java.util.Date;

public class SunPositionModelWrapper {
    private Double latitude;

    private Double longitude;

    private LocalDateTime sunrise;

    private LocalDateTime sunset;

    private LocalDateTime dayTime;

    private LocalDateTime moonRise;

    private LocalDateTime moonSet;

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public LocalDateTime getSunrise() {
        return sunrise;
    }

    public void setSunrise(LocalDateTime sunrise) {
        this.sunrise = sunrise;
    }

    public LocalDateTime getSunset() {
        return sunset;
    }

    public void setSunset(LocalDateTime sunset) {
        this.sunset = sunset;
    }


    public LocalDateTime getDayTime() {
        return dayTime;
    }

    public void setDayTime(LocalDateTime dayTime) {
        this.dayTime = dayTime;
    }

    public LocalDateTime getMoonRise() {
        return moonRise;
    }

    public void setMoonRise(LocalDateTime moonRise) {
        this.moonRise = moonRise;
    }

    public LocalDateTime getMoonSet() {
        return moonSet;
    }

    public void setMoonSet(LocalDateTime moonSet) {
        this.moonSet = moonSet;
    }
}
