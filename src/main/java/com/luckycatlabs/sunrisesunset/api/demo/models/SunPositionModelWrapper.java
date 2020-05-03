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

    private String moonSet;

    private Double moonVisualPercentage;

    private LocalDateTime nextNewMoon;

    private LocalDateTime nextFullMoon;

    private Double moonAzimuth;

    private Double moonAltitude;

    private Double moonDistance;


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

    public LocalDateTime getNextNewMoon() {
        return nextNewMoon;
    }

    public void setNextNewMoon(LocalDateTime nextNewMoon) {
        this.nextNewMoon = nextNewMoon;
    }

    public LocalDateTime getNextFullMoon() {
        return nextFullMoon;
    }

    public void setNextFullMoon(LocalDateTime nextFullMoon) {
        this.nextFullMoon = nextFullMoon;
    }

    public Double getMoonAzimuth() {
        return moonAzimuth;
    }

    public void setMoonAzimuth(Double moonAzimuth) {
        this.moonAzimuth = moonAzimuth;
    }

    public Double getMoonAltitude() {
        return moonAltitude;
    }

    public void setMoonAltitude(Double moonAltitude) {
        this.moonAltitude = moonAltitude;
    }

    public Double getMoonDistance() {
        return moonDistance;
    }

    public void setMoonDistance(Double moonDistance) {
        this.moonDistance = moonDistance;
    }
}
