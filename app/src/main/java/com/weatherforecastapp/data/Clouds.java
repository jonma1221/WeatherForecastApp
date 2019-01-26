package com.weatherforecastapp.data;

import com.google.gson.annotations.SerializedName;

public class Clouds {

    @SerializedName("all")
    public Integer all;

    public Integer getAll() {
        return all;
    }
}
