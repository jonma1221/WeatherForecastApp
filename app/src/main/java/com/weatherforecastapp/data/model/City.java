package com.weatherforecastapp.data.model;

import com.google.gson.annotations.SerializedName;

public class City {

    @SerializedName("id")
    public Integer id;

    @SerializedName("name")
    public String name;

    @SerializedName("coord")
    public Coord coord;

    @SerializedName("country")
    public String country;

    @SerializedName("population")
    public Integer population;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Coord getCoord() {
        return coord;
    }

    public String getCountry() {
        return country;
    }

    public Integer getPopulation() {
        return population;
    }
}
