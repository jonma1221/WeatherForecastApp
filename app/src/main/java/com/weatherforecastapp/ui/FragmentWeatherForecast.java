package com.weatherforecastapp.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.weatherforecastapp.R;

import butterknife.ButterKnife;

public class FragmentWeatherForecast extends Fragment {

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
        return v;
    }
}
