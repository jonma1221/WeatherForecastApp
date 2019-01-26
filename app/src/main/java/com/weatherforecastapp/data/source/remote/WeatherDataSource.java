package com.weatherforecastapp.data.source.remote;

import com.weatherforecastapp.data.model.ForecastResponse;

public interface WeatherDataSource {
    interface WeatherForecastCallback<T>{
        void onWeatherForecastRetrieved(T item);
        void onError();
    }

    void retrieve5dayForecastByCityName(String cityName, WeatherForecastCallback<ForecastResponse> callback);
    void retrieve5dayForecastByCityId(String cityId, WeatherForecastCallback<ForecastResponse>  callback);
    void retrieve5dayForecastByCityZip(String cityZip, WeatherForecastCallback<ForecastResponse>  callback);
}
