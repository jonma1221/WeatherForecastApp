package com.weatherforecastapp.data;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Rain {

    @SerializedName("3h")
    @Expose
    public Double _3h;

    public Double get_3h() {
        return _3h;
    }
}
