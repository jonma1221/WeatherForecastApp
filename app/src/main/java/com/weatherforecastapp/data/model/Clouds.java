package com.weatherforecastapp.data.model;

import com.google.gson.annotations.SerializedName;

public class Clouds {

    @SerializedName("all")
    public Integer all;

    public Integer getAll() {
        return all;
    }
}
