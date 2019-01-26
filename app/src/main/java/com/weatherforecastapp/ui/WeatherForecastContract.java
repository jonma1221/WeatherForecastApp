package com.weatherforecastapp.ui;

import com.weatherforecastapp.data.model.ForecastResponse;

public interface WeatherForecastContract {
    interface View{
        void onForecastRetrieved(ForecastResponse forecastResponse);
    }

    interface Presenter{
        void get5dayWeatherForecastId(String id);
        void get5dayWeatherForecastName(String id);
    }
}
