package com.weatherforecastapp.data.model;

import com.google.gson.annotations.SerializedName;

public class Wind {

    @SerializedName("speed")
    public Double speed;

    @SerializedName("deg")
    public Double deg;

    public Double getSpeed() {
        return speed;
    }

    public Double getDeg() {
        return deg;
    }
}
