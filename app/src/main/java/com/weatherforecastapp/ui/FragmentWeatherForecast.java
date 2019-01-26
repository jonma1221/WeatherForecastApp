package com.weatherforecastapp.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;
import com.weatherforecastapp.R;
import com.weatherforecastapp.data.model.ForecastDetail;
import com.weatherforecastapp.data.model.ForecastResponse;
import com.weatherforecastapp.data.source.remote.WeatherDataSourceImpl;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.weatherforecastapp.network.Constants.BASE_URL;
import static com.weatherforecastapp.network.Constants.BASE_URL_IMG;

public class FragmentWeatherForecast extends Fragment implements WeatherForecastContract.View {
    String imgPath = "img/w/";

    @BindView(R.id.root)
    ConstraintLayout root;
    @BindView(R.id.today_weather_temp)
    TextView todayWeatherTemp;
    @BindView(R.id.today_weather_temp_desc)
    TextView todayWeatherTempDesc;
    @BindView(R.id.today_weather_temp_icon)
    ImageView todayWeatherTempIcon;

    WeatherForecastPresenter mPresenter;

    public static FragmentWeatherForecast newInstance() {
        FragmentWeatherForecast fragment = new FragmentWeatherForecast();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_weather_forecast, container, false);
        ButterKnife.bind(this, v);
        setUpPresenter();
        return v;
    }

    public void setUpPresenter(){
        mPresenter = new WeatherForecastPresenter(this, WeatherDataSourceImpl.getInstance());
    }
    @Override
    public void onForecastRetrieved(ForecastResponse forecastResponse) {
    }
}
