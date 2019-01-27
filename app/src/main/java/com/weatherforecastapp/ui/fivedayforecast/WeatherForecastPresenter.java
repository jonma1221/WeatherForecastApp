package com.weatherforecastapp.ui.fivedayforecast;

import com.weatherforecastapp.data.model.DailyWeather;
import com.weatherforecastapp.data.model.ForecastResponse;
import com.weatherforecastapp.data.source.remote.WeatherDataSource;
import com.weatherforecastapp.data.source.remote.WeatherDataSourceImpl;

public class WeatherForecastPresenter implements WeatherForecastContract.Presenter {
    WeatherForecastContract.View mView;
    WeatherDataSourceImpl weatherDataSource;

    public WeatherForecastPresenter(WeatherForecastContract.View mView, WeatherDataSourceImpl weatherDataSource) {
        this.mView = mView;
        this.weatherDataSource = weatherDataSource;
    }

    public void destroyView(){
        mView = null;
    }

    @Override
    public void getTodayForecastName(String cityName) {
        weatherDataSource.retrieveCurrentWeatherByCityName(cityName, new WeatherDataSource.WeatherForecastCallback<DailyWeather>() {
            @Override
            public void onWeatherForecastRetrieved(DailyWeather item) {
                if(mView != null){
                    mView.onTodayForecastRetrieved(item);
                }
            }

            @Override
            public void onError() {
                if(mView != null){
                    mView.onError();
                }
            }
        });
    }

    @Override
    public void get5dayWeatherForecastName(String name) {
        weatherDataSource.retrieve5dayForecastByCityName(name, new WeatherDataSource.WeatherForecastCallback<ForecastResponse>() {
            @Override
            public void onWeatherForecastRetrieved(ForecastResponse item) {
                if(mView != null){
                    mView.on5dayForecastRetrieved(item);
                }
            }

            @Override
            public void onError() {
                if(mView != null){
                    mView.onError();
                }
            }
        });
    }
}
