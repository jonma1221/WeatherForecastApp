package com.weatherforecastapp.data;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ForecastResponse {

    @SerializedName("cod")
    public String cod;

    @SerializedName("message")
    public Double message;

    @SerializedName("cnt")
    public Integer cnt;

    @SerializedName("list")
    public List<ForecastDetail> list = null;

    @SerializedName("city")
    public City city;

    public String getCod() {
        return cod;
    }

    public Double getMessage() {
        return message;
    }

    public Integer getCnt() {
        return cnt;
    }

    public List<ForecastDetail> getList() {
        return list;
    }

    public City getCity() {
        return city;
    }
}
