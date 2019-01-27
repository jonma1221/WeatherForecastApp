package com.weatherforecastapp.ui.threehourupdates;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.weatherforecastapp.R;
import com.weatherforecastapp.data.model.ForecastDetail;
import com.weatherforecastapp.ui.BaseAdapter;
import com.weatherforecastapp.ui.BaseViewHolder;

import java.util.List;

public class ThreeHourUpdatesAdapter extends BaseAdapter<ForecastDetail, BaseAdapter.BaseRecyclerListener> {

    public ThreeHourUpdatesAdapter(List<ForecastDetail> items) {
        super(items);
    }

    @NonNull
    @Override
    public BaseViewHolder<ForecastDetail, BaseRecyclerListener> onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        Context context = viewGroup.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View v = inflater.inflate(R.layout.three_hour_update_vh, null);
        ThreeHourUpdateViewHolder vh = new ThreeHourUpdateViewHolder(v);
        return vh;
    }
}
