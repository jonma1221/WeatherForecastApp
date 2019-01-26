package com.weatherforecastapp.data.model;

import com.google.gson.annotations.SerializedName;

public class Main {

    @SerializedName("temp")
    public Double temp;

    @SerializedName("temp_min")
    public Double tempMin;

    @SerializedName("temp_max")
    public Double tempMax;

    @SerializedName("pressure")
    public Double pressure;

    @SerializedName("sea_level")
    public Double seaLevel;

    @SerializedName("grnd_level")
    public Double grndLevel;

    @SerializedName("humidity")
    public Integer humidity;

    @SerializedName("temp_kf")
    public Integer tempKf;

    public Double getTemp() {
        return temp;
    }

    public Double getTempMin() {
        return tempMin;
    }

    public Double getTempMax() {
        return tempMax;
    }

    public Double getPressure() {
        return pressure;
    }

    public Double getSeaLevel() {
        return seaLevel;
    }

    public Double getGrndLevel() {
        return grndLevel;
    }

    public Integer getHumidity() {
        return humidity;
    }

    public Integer getTempKf() {
        return tempKf;
    }
}
