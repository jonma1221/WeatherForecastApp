package com.weatherforecastapp.data.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ForecastDetail {

    @SerializedName("dt")
    public Integer dt;

    @SerializedName("main")
    public Main main;

    @SerializedName("weather")
    public List<Weather> weather = null;

    @SerializedName("clouds")
    public Clouds clouds;

    @SerializedName("wind")
    public Wind wind;

    @SerializedName("sys")
    public Sys sys;

    @SerializedName("dt_txt")
    public String dtTxt;

    @SerializedName("rain")
    public Rain rain;

    @SerializedName("snow")
    public Snow snow;

    public Integer getDt() {
        return dt;
    }

    public Main getMain() {
        return main;
    }

    public List<Weather> getWeather() {
        return weather;
    }

    public Clouds getClouds() {
        return clouds;
    }

    public Wind getWind() {
        return wind;
    }

    public Sys getSys() {
        return sys;
    }

    public String getDtTxt() {
        return dtTxt;
    }

    public Rain getRain() {
        return rain;
    }

    public Snow getSnow() {
        return snow;
    }
}
