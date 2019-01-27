package com.weatherforecastapp.ui;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.List;

public abstract class BaseAdapter<T, L extends BaseAdapter.BaseRecyclerListener>
        extends RecyclerView.Adapter<BaseViewHolder<T, L>> {
    private List<T> items;

    public BaseAdapter(List<T> items) {
        this.items = items;
    }

    public void replace(List<T> items){
        this.items.clear();
        this.items.addAll(items);
        notifyDataSetChanged();
    }

    public void add(List<T> items){
        this.items.addAll(items);
        int origSize = this.items.size();
        notifyItemRangeInserted(origSize, this.items.size());
    }

    @NonNull
    @Override
    public abstract BaseViewHolder<T, L> onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType);

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder<T, L> tBaseHolder, int i) {
        tBaseHolder.bind(items.get(i));
        tBaseHolder.setOnClickListener(onClickListener);
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public int getItemCount() {
        return items != null ? items.size() : 0;
    }

    private L onClickListener;
    public void setOnClickListener(L onClickListener){
        this.onClickListener = onClickListener;
    }

    public interface OnItemClickListener<T> extends BaseRecyclerListener{
        void onItemClicked(T item);
    }

    public interface BaseRecyclerListener {
    }
}