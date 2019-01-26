package com.weatherforecastapp.data.model;

import com.google.gson.annotations.SerializedName;

public class Coord {

    @SerializedName("lat")
    public Double lat;

    @SerializedName("lon")
    public Double lon;

    public Double getLat() {
        return lat;
    }

    public Double getLon() {
        return lon;
    }
}
