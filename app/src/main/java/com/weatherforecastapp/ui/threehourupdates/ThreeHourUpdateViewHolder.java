package com.weatherforecastapp.ui.threehourupdates;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;
import com.weatherforecastapp.R;
import com.weatherforecastapp.data.model.ForecastDetail;
import com.weatherforecastapp.ui.BaseAdapter;
import com.weatherforecastapp.ui.BaseViewHolder;
import com.weatherforecastapp.ui.util.TimeFormatter;

import java.util.Locale;

import butterknife.BindView;

import static com.weatherforecastapp.ui.util.Constants.BASE_URL_IMG;
import static com.weatherforecastapp.ui.util.Constants.IMG_PATH;
import static com.weatherforecastapp.ui.util.Constants.TEMP_UNITS_IMPERIAL;

public class ThreeHourUpdateViewHolder extends BaseViewHolder<ForecastDetail, BaseAdapter.BaseRecyclerListener> {

    @BindView(R.id.current_hour_weather_temp_icon)
    ImageView currentHourIcon;
    @BindView(R.id.current_hour_weather_temp)
    TextView currentHourTemp;
    @BindView(R.id.current_hour_time)
    TextView CurrentHourTime;

    public ThreeHourUpdateViewHolder(@NonNull View itemView) {
        super(itemView);
    }

    @Override
    public void bind(ForecastDetail item) {
        // temp
        String temp = String.format(Locale.getDefault(), "%.0f", item.getMain().getTemp());
        currentHourTemp.setText(temp  + (char) 0x00B0 + TEMP_UNITS_IMPERIAL);

        // time
        String formattedDate = TimeFormatter.getTimeinHours(item.getDt());
        CurrentHourTime.setText(formattedDate);

        // icon
        String imgUrl = BASE_URL_IMG + IMG_PATH + item.getWeather().get(0).getIcon() + ".png";
        Glide.with(mContext)
                .load(imgUrl)
                .apply(new RequestOptions().fitCenter()
                        .override(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL)
                        .placeholder(R.color.grey_200))
                .into(currentHourIcon);
    }
}
