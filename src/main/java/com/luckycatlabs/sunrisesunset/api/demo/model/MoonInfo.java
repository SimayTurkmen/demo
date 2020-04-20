package com.luckycatlabs.sunrisesunset.api.demo.model;

import lombok.Data;

import java.util.Date;

@Data
public class MoonInfo {
    private LocationInfo locationInfo;
    private Date date;
    private Date moon_rise;
    private Date moon_set;

    public LocationInfo getLocationInfo() {
        return locationInfo;
    }

    public void setLocationInfo(LocationInfo locationInfo) {
        this.locationInfo = locationInfo;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getMoon_rise() {
        return moon_rise;
    }

    public void setMoon_rise(Date moon_rise) {
        this.moon_rise = moon_rise;
    }

    public Date getMoon_set() {
        return moon_set;
    }

    public void setMoon_set(Date moon_set) {
        this.moon_set = moon_set;
    }
}
