package com.weatherforecastapp.ui.fivedayforecast;

import com.weatherforecastapp.data.model.DailyWeather;
import com.weatherforecastapp.data.model.ForecastResponse;

public interface WeatherForecastContract {
    interface View{
        void onTodayForecastRetrieved(DailyWeather dailyWeather);
        void on5dayForecastRetrieved(ForecastResponse forecastResponse);
    }

    interface Presenter{
        void getTodayForecastName(String cityName);
        void get5dayWeatherForecastName(String cityName);
    }
}
