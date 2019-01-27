package com.weatherforecastapp.data.source.remote;

import android.util.Log;

import com.weatherforecastapp.data.model.ForecastResponse;
import com.weatherforecastapp.network.RetrofitInstance;
import com.weatherforecastapp.network.service.WeatherForecastGETService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.weatherforecastapp.network.Constants.UNITS_IMPERIAL;
import static com.weatherforecastapp.network.Constants.UNITS_METRIC;

public class WeatherDataSourceImpl implements WeatherDataSource {
    private static WeatherDataSourceImpl instance;

    private WeatherForecastGETService client =
            RetrofitInstance.getInstance().create(WeatherForecastGETService.class);

    public static WeatherDataSourceImpl getInstance() {
        if(instance == null){
            instance = new WeatherDataSourceImpl();
        }
        return instance;
    }

    @Override
    public void retrieve5dayForecastByCityName(String cityName, final WeatherForecastCallback<ForecastResponse> callback) {
        Call<ForecastResponse> call = client.get5dayWeatherForecastByName(cityName, UNITS_IMPERIAL);
        call.enqueue(new Callback<ForecastResponse>() {
            @Override
            public void onResponse(Call<ForecastResponse> call, Response<ForecastResponse> response) {
                ForecastResponse forecastResponse = response.body();
                callback.onWeatherForecastRetrieved(forecastResponse);
            }

            @Override
            public void onFailure(Call<ForecastResponse> call, Throwable t) {

            }
        });
    }

    @Override
    public void retrieve5dayForecastByCityId(String cityId, final WeatherForecastCallback<ForecastResponse> callback) {
        Call<ForecastResponse> call = client.get5dayWeatherForecastById(cityId);
        call.enqueue(new Callback<ForecastResponse>() {
            @Override
            public void onResponse(Call<ForecastResponse> call, Response<ForecastResponse> response) {
                ForecastResponse forecastResponse = response.body();
                callback.onWeatherForecastRetrieved(forecastResponse);
            }

            @Override
            public void onFailure(Call<ForecastResponse> call, Throwable t) {

            }
        });
    }

    @Override
    public void retrieve5dayForecastByCityZip(String cityZip, WeatherForecastCallback<ForecastResponse> callback) {

        Call<ForecastResponse> call = client.get5dayWeatherForecastByZip(cityZip);
        call.enqueue(new Callback<ForecastResponse>() {
            @Override
            public void onResponse(Call<ForecastResponse> call, Response<ForecastResponse> response) {
                Log.d("[weather]", "success");
            }

            @Override
            public void onFailure(Call<ForecastResponse> call, Throwable t) {

            }
        });
    }
}
