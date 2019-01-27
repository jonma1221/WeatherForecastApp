package com.weatherforecastapp.ui;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.weatherforecastapp.R;
import com.weatherforecastapp.ui.fivedayforecast.FragmentWeatherForecast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpFragment(FragmentWeatherForecast.newInstance());
    }

    public void setUpFragment(Fragment f){
        FragmentManager fm = getSupportFragmentManager();
        fm.beginTransaction()
                .replace(R.id.fragment_container, f)
                .commit();
    }
}
