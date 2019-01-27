package com.weatherforecastapp.ui;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import butterknife.ButterKnife;

public abstract class BaseViewHolder<T, L extends BaseAdapter.BaseRecyclerListener> extends RecyclerView.ViewHolder {
    protected Context mContext;
    protected L clickListener;

    public BaseViewHolder(@NonNull View itemView) {
        super(itemView);
        mContext = itemView.getContext();
        ButterKnife.bind(this, itemView);
    }

    public abstract void bind(T item);

    public void setOnClickListener(L clickListener){
        this.clickListener = clickListener;
    }
}
