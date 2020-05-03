package com.luckycatlabs.sunrisesunset.api.demo.models;

import java.text.ParseException;
import java.util.Date;

public class SunPositionModel {
    private Double latitude;

    private Double longitude;

    private Date sunrise;

    private Date sunset;

    private Date dayTime;

    private Date moonRise;

    private String moonSet;

    private double moonVisualPercentage;

    private Date nextNewMoon;

    private Date nextFullMoon;

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

    public Date getDayTime() {
        return dayTime;
    }

    public void setDayTime(Date dayTime) throws ParseException {
        this.dayTime = dayTime;
    }

    public double getMoonVisualPercentage() {
        return moonVisualPercentage;
    }

    public void setMoonVisualPercentage(double moonVisualPercentage) {
        this.moonVisualPercentage = moonVisualPercentage;
    }

    public Date getNextNewMoon() {
        return nextNewMoon;
    }

    public void setNextNewMoon(Date nextNewMoon) {
        this.nextNewMoon = nextNewMoon;
    }

    public Date getNextFullMoon() {
        return nextFullMoon;
    }

    public void setNextFullMoon(Date nextFullMoon) {
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