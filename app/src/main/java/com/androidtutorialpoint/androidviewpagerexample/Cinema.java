package com.androidtutorialpoint.androidviewpagerexample;


import java.io.Serializable;

public class Cinema implements Serializable {
    private String name;
    private String vicinity;
    private double lon;
    private double lat;

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public String get_Name() {
        return name;
    }

    public void set_Name(String name) {
        this.name = name;
    }

    public String getVicinity() {
        return vicinity;
    }

    public void setVicinity(String vicinity) {
        this.vicinity = vicinity;
    }
}

