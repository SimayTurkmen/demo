package com.luckycatlabs.sunrisesunset.api.demo.model;

import java.util.Date;

public class AstronomicalInfoModel {
    private Double latitude;

    private Double longitude;

    private Date sunrise;

    private Date sunset;

    private Date dayTime;

    private Date twilight_begin;

    private Date twilight_end;

    private Date moonRise;

    private String moonSet;

    private double moonVisualPercentage;

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

    public Date getSunrise() {
        return sunrise;
    }

    public void setSunrise(Date sunrise) {
        this.sunrise = sunrise;
    }

    public Date getSunset() {
        return sunset;
    }

    public void setSunset(Date sunset) {
        this.sunset = sunset;
    }

    public Date getDayTime() {
        return dayTime;
    }

    public void setDayTime(Date dayTime) {
        this.dayTime = dayTime;
    }

    public Date getTwilight_begin() {
        return twilight_begin;
    }

    public void setTwilight_begin(Date twilight_begin) {
        this.twilight_begin = twilight_begin;
    }

    public Date getTwilight_end() {
        return twilight_end;
    }

    public void setTwilight_end(Date twilight_end) {
        this.twilight_end = twilight_end;
    }

    public Date getMoonRise() {
        return moonRise;
    }

    public void setMoonRise(Date moonRise) {
        this.moonRise = moonRise;
    }

    public String getMoonSet() {
        return moonSet;
    }

    public void setMoonSet(String moonSet) {
        this.moonSet = moonSet;
    }

    public double getMoonVisualPercentage() {
        return moonVisualPercentage;
    }

    public void setMoonVisualPercentage(double moonVisualPercentage) {
        this.moonVisualPercentage = moonVisualPercentage;
    }
}
