package com.luckycatlabs.sunrisesunset.api.demo.model.test;

public class LatLngModel {
    String lat, lng;

    public LatLngModel(String lat, String lng) {
        this.lat = lat;
        this.lng = lng;
    }

    public LatLngModel() {
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }
}
