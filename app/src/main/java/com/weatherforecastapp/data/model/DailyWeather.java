package com.weatherforecastapp.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DailyWeather {

    @SerializedName("coord")
    public Coord coord;

    @SerializedName("weather")
    public List<Weather> weather = null;

    @SerializedName("base")
    public String base;

    @SerializedName("main")
    public Main main;

    @SerializedName("visibility")
    public Integer visibility;

    @SerializedName("wind")
    public Wind wind;

    @SerializedName("clouds")
    public Clouds clouds;

    @SerializedName("dt")
    public Integer dt;

    @SerializedName("sys")
    public Sys sys;

    @SerializedName("id")
    public Integer id;

    @SerializedName("name")
    public String name;

    @SerializedName("cod")
    public Integer cod;

    public Coord getCoord() {
        return coord;
    }

    public List<Weather> getWeather() {
        return weather;
    }

    public String getBase() {
        return base;
    }

    public Main getMain() {
        return main;
    }

    public Integer getVisibility() {
        return visibility;
    }

    public Wind getWind() {
        return wind;
    }

    public Clouds getClouds() {
        return clouds;
    }

    public Integer getDt() {
        return dt;
    }

    public Sys getSys() {
        return sys;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getCod() {
        return cod;
    }
}
