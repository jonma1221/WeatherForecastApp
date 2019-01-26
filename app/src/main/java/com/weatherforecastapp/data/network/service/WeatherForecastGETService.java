package com.weatherforecastapp.data.network.service;

import com.weatherforecastapp.data.model.ForecastResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherForecastGETService {

    @GET("forecast")
    Call<ForecastResponse> get5dayWeatherForecastById(@Query("id") String id);

    @GET("forecast")
    Call<ForecastResponse> get5dayWeatherForecastByName(@Query("q") String cityName);
}
