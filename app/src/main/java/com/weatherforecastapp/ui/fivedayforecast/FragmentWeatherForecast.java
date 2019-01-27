package com.weatherforecastapp.ui.fivedayforecast;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;
import com.weatherforecastapp.R;
import com.weatherforecastapp.data.model.DailyWeather;
import com.weatherforecastapp.data.model.ForecastDetail;
import com.weatherforecastapp.data.model.ForecastResponse;
import com.weatherforecastapp.data.source.remote.WeatherDataSourceImpl;
import com.weatherforecastapp.ui.threehourupdates.ThreeHourUpdatesAdapter;
import com.weatherforecastapp.ui.util.ItemSpaceDecoration;
import com.weatherforecastapp.ui.util.TimeFormatter;
import com.weatherforecastapp.ui.util.WindDirectionFormatter;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.weatherforecastapp.ui.util.Constants.BASE_URL_IMG;
import static com.weatherforecastapp.ui.util.Constants.DEFAULT_CITY;
import static com.weatherforecastapp.ui.util.Constants.IMG_PATH;
import static com.weatherforecastapp.ui.util.Constants.TEMP_UNITS_IMPERIAL;
import static com.weatherforecastapp.ui.util.Constants.WIND_UNITS_IMPERIAL;

public class FragmentWeatherForecast extends Fragment implements WeatherForecastContract.View {
    @BindView(R.id.today_weather_searchView)
    SearchView searchView;
    @BindView(R.id.today_weather_temp)
    TextView todayWeatherTemp;
    @BindView(R.id.today_date_desc)
    TextView todayDate;
    @BindView(R.id.today_weather_temp_desc)
    TextView todayWeatherTempDesc;
    @BindView(R.id.today_weather_wind_speed)
    TextView todayWeatherWindSpeed;
    @BindView(R.id.today_weather_temp_icon)
    ImageView todayWeatherTempIcon;
    @BindView(R.id.five_day_view)
    FiveDayView fiveDayView;
    @BindView(R.id.error)
    TextView error;
    @BindView(R.id.three_hour_forecast_recycler_view)
    RecyclerView recyclerView;

    WeatherForecastPresenter mPresenter;
    ThreeHourUpdatesAdapter hourUpdatesAdapter;

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
        setUpRecyclerView();
        setUpPresenter();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                mPresenter.get5dayWeatherForecastName(s);
                mPresenter.getTodayForecastName(s);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                return false;
            }
        });
        return v;
    }

    private void setUpTodayWeather(DailyWeather forecastDetail) {
        // current temp
        String tempMax = String.format(Locale.getDefault(), "%.0f", forecastDetail.getMain().getTempMax());
        String temp = String.format(Locale.getDefault(), "%.0f", forecastDetail.getMain().temp);
        todayWeatherTemp.setText(temp  + "/" + tempMax + (char) 0x00B0 + TEMP_UNITS_IMPERIAL);

        //date
        String date = TimeFormatter.getTimeInDayMonthYear(forecastDetail.getDt());
        todayDate.setText(date);

        // weather description
        todayWeatherTempDesc.setText(forecastDetail.getWeather().get(0).getDescription());

        // wind speed
        String windDirection = WindDirectionFormatter.getWindDirection(forecastDetail.getWind().getDeg());
        String windSpeed = forecastDetail.getWind().getSpeed() + WIND_UNITS_IMPERIAL;
        todayWeatherWindSpeed.setText(windSpeed + " " + windDirection);

        // icon
        String imgUrl = BASE_URL_IMG + IMG_PATH + forecastDetail.getWeather().get(0).getIcon() + ".png";
        Glide.with(getContext())
                .load(imgUrl)
                .apply(new RequestOptions().fitCenter()
                        .override(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL)
                        .placeholder(R.color.grey_200))
                .into(todayWeatherTempIcon);
    }

    private void setUpRecyclerView() {
        hourUpdatesAdapter = new ThreeHourUpdatesAdapter(new ArrayList<ForecastDetail>());
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        recyclerView.setAdapter(hourUpdatesAdapter);
        ItemSpaceDecoration itemSpaceDecoration = new ItemSpaceDecoration(10);
        recyclerView.addItemDecoration(itemSpaceDecoration);
    }

    public void setUpPresenter(){
        mPresenter = new WeatherForecastPresenter(this, WeatherDataSourceImpl.getInstance());
        mPresenter.get5dayWeatherForecastName(DEFAULT_CITY);
        mPresenter.getTodayForecastName(DEFAULT_CITY);
    }

    @Override
    public void onTodayForecastRetrieved(DailyWeather dailyWeather) {
        error.setVisibility(View.GONE);
        searchView.setQuery(dailyWeather.getName(), false);
        searchView.clearFocus();
        setUpTodayWeather(dailyWeather);
    }

    @Override
    public void on5dayForecastRetrieved(ForecastResponse forecastResponse) {
        error.setVisibility(View.GONE);
        List<ForecastDetail> forecastDetails = forecastResponse.getList();
        if(forecastResponse.getList() != null){
            List<ForecastDetail> nextFiveDays = new ArrayList<>();
            for(int i = 0; i < forecastDetails.size(); i += 8){
                nextFiveDays.add(forecastDetails.get(i));
            }
            fiveDayView.setNext5days(nextFiveDays);
            hourUpdatesAdapter.replace(forecastDetails.subList(1, 8));
        }
    }

    @Override
    public void onError() {
        error.setVisibility(View.VISIBLE);
    }
}
