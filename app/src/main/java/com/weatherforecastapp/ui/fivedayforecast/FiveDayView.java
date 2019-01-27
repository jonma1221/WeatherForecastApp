package com.weatherforecastapp.ui.fivedayforecast;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import com.weatherforecastapp.R;
import com.weatherforecastapp.data.model.ForecastDetail;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FiveDayView extends LinearLayout {
    @BindView(R.id.day1)
    SingleDayView dayView1;
    @BindView(R.id.day2)
    SingleDayView dayView2;
    @BindView(R.id.day3)
    SingleDayView dayView3;
    @BindView(R.id.day4)
    SingleDayView dayView4;
    @BindView(R.id.day5)
    SingleDayView dayView5;

    public FiveDayView(Context context) {
        super(context);
        init();
    }

    public FiveDayView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public FiveDayView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public void init(){
        inflate(getContext(), R.layout.five_day_forecast,this);
        ButterKnife.bind(this);
    }

    public void setNext5days(List<ForecastDetail> list){
        dayView1.updateWeather(list.get(0));
        dayView2.updateWeather(list.get(1));
        dayView3.updateWeather(list.get(2));
        dayView4.updateWeather(list.get(3));
        dayView5.updateWeather(list.get(4));
    }
}
