package com.luckycatlabs.sunrisesunset.api.demo.model;

import java.time.LocalDateTime;

public class AstronomicalInfoWrapper {
    private Double latitude;

    private Double longitude;

    private LocalDateTime sunrise;

    private LocalDateTime sunset;

    private LocalDateTime dayTime;

    private LocalDateTime twilight_begin;

    private LocalDateTime twilight_end;

    private LocalDateTime moonRise;

    private String moonSet;

    private Double moonVisualPercentage;

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

    public LocalDateTime getTwilight_begin() {
        return twilight_begin;
    }

    public void setTwilight_begin(LocalDateTime twilight_begin) {
        this.twilight_begin = twilight_begin;
    }

    public LocalDateTime getTwilight_end() {
        return twilight_end;
    }

    public void setTwilight_end(LocalDateTime twilight_end) {
        this.twilight_end = twilight_end;
    }

    public LocalDateTime getMoonRise() {
        return moonRise;
    }

    public void setMoonRise(LocalDateTime moonRise) {
        this.moonRise = moonRise;
    }

    public String getMoonSet() {
        return moonSet;
    }

    public void setMoonSet(String moonSet) {
        this.moonSet = moonSet;
    }

    public Double getMoonVisualPercentage() {
        return moonVisualPercentage;
    }

    public void setMoonVisualPercentage(Double moonVisualPercentage) {
        this.moonVisualPercentage = moonVisualPercentage;
    }
}
