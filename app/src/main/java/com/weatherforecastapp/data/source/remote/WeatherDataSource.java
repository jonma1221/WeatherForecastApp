package com.weatherforecastapp.data.source.remote;

public interface WeatherDataSource {
    interface WeatherForecastCallback<T>{
        void onWeatherForecastRetrieved(T item);
        void onError();
    }

    void retrieve5dayForecastByCityName(String cityName);
    void retrieve5dayForecastByCityId(String cityId);
    void retrieve5dayForecastByCityZip(String cityZip);
}
