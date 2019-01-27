package com.weatherforecastapp.ui.fivedayforecast;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;
import com.weatherforecastapp.R;
import com.weatherforecastapp.data.model.ForecastDetail;
import com.weatherforecastapp.ui.util.TimeFormatter;

import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.weatherforecastapp.network.Constants.BASE_URL_IMG;
import static com.weatherforecastapp.network.Constants.IMG_PATH;

public class SingleDayView extends ConstraintLayout {

    @BindView(R.id.single_day_weather_temp_icon)
    ImageView currentDayIcon;
    @BindView(R.id.single_day_weather_temp)
    TextView currentDayTemp;
    @BindView(R.id.single_day_time)
    TextView CurrentDayTime;

    public SingleDayView(Context context) {
        super(context);
        init();
    }

    public SingleDayView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public SingleDayView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public void init(){
        inflate(getContext(), R.layout.single_day_forecast,this);
        ButterKnife.bind(this);
    }

    public void updateWeather(ForecastDetail forecastDetail){
        // temp
        String temp = String.format(Locale.getDefault(), "%.0f", forecastDetail.getMain().getTemp());
        String tempMax = String.format(Locale.getDefault(), "%.0f", forecastDetail.getMain().getTempMax());
//        currentHourTemp.setText(temp  + (char) 0x00B0 + "F / " + tempMax  + (char) 0x00B0 + "F");
        currentDayTemp.setText(temp  + (char) 0x00B0 + "F");

        // time
        String formattedDate = TimeFormatter.getTimeInDays(forecastDetail.getDt());
        CurrentDayTime.setText(formattedDate);

        // icon
        String imgUrl = BASE_URL_IMG + IMG_PATH + forecastDetail.getWeather().get(0).getIcon() + ".png";
        Glide.with(this)
                .load(imgUrl)
                .apply(new RequestOptions().fitCenter()
                        .override(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL)
                        .placeholder(R.color.grey_200))
                .into(currentDayIcon);
    }
}
