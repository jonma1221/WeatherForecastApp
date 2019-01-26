package com.weatherforecastapp.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Snow {

    @SerializedName("3h")
    public Double _3h;

    public Double get_3h() {
        return _3h;
    }
}
