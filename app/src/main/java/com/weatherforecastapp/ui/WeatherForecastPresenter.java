package com.weatherforecastapp.ui;

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

    @Override
    public void get5dayWeatherForecastId(String id) {
    }

    @Override
    public void get5dayWeatherForecastName(String name) {
        weatherDataSource.retrieve5dayForecastByCityName(name, new WeatherDataSource.WeatherForecastCallback<ForecastResponse>() {
            @Override
            public void onWeatherForecastRetrieved(ForecastResponse item) {
                if(mView != null){
                    mView.onForecastRetrieved(item);
                }
            }

            @Override
            public void onError() {

            }
        });
    }
}
