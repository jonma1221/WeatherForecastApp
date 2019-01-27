package com.weatherforecastapp.ui.fivedayforecast;

import com.weatherforecastapp.data.model.DailyWeather;
import com.weatherforecastapp.data.model.ForecastResponse;
import com.weatherforecastapp.data.source.remote.WeatherDataSourceImpl;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

public class WeatherForecastPresenterTest {
    private final String TEST = "";

    @Mock
    private WeatherForecastContract.View mView;
    @Mock
    private WeatherDataSourceImpl dataSource;
    @Captor
    private ArgumentCaptor<WeatherDataSourceImpl.WeatherForecastCallback<DailyWeather>> mDailyCallbackCaptor;
    @Captor
    private ArgumentCaptor<WeatherDataSourceImpl.WeatherForecastCallback<ForecastResponse>> m5dayCallbackCaptor;

    private WeatherForecastPresenter mPresenter;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        mPresenter = new WeatherForecastPresenter(mView, dataSource);
    }

    @Test
    public void getTodayForecastNameSuccess() {
        mPresenter.getTodayForecastName(TEST);
        verify(dataSource).retrieveCurrentWeatherByCityName(anyString(), mDailyCallbackCaptor.capture());
        DailyWeather data = Mockito.mock(DailyWeather.class);
        mDailyCallbackCaptor.getValue().onWeatherForecastRetrieved(data);
        verify(mView).onTodayForecastRetrieved(any(DailyWeather.class));
    }

    @Test
    public void getTodayForecacstNameFail() {
        mPresenter.getTodayForecastName(TEST);
        verify(dataSource).retrieveCurrentWeatherByCityName(anyString(), mDailyCallbackCaptor.capture());
        mDailyCallbackCaptor.getValue().onError();
        verify(mView, never()).onTodayForecastRetrieved(any(DailyWeather.class));
        verify(mView).onError();
    }

    @Test
    public void get5dayWeatherForecastNameSuccess() {
        mPresenter.get5dayWeatherForecastName(TEST);
        verify(dataSource).retrieve5dayForecastByCityName(anyString(), m5dayCallbackCaptor.capture());
        ForecastResponse data = Mockito.mock(ForecastResponse.class);
        m5dayCallbackCaptor.getValue().onWeatherForecastRetrieved(data);
        verify(mView).on5dayForecastRetrieved(any(ForecastResponse.class));
    }

    @Test
    public void get5dayWeatherForecastNameFail() {
        mPresenter.get5dayWeatherForecastName(TEST);
        verify(dataSource).retrieve5dayForecastByCityName(anyString(), m5dayCallbackCaptor.capture());
        m5dayCallbackCaptor.getValue().onError();
        verify(mView, never()).on5dayForecastRetrieved(any(ForecastResponse.class));
        verify(mView).onError();
    }
}