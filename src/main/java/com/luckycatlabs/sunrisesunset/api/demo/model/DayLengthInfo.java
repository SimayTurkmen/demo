package com.luckycatlabs.sunrisesunset.api.demo.model;

import lombok.Data;

import java.util.Date;

@Data
public class DayLengthInfo {
    private LocationInfo locationInfo;
    private Date date;
    private Date day_length;

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

    public Date getDay_length() {
        return day_length;
    }

    public void setDay_length(Date day_length) {
        this.day_length = day_length;
    }
}
