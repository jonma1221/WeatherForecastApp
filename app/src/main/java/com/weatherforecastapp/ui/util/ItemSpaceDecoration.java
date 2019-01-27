package com.weatherforecastapp.ui.util;

import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class ItemSpaceDecoration extends RecyclerView.ItemDecoration {

    private int space = 10;

    public ItemSpaceDecoration(int value) {
        this.space = value;
    }

    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        int index = parent.getChildAdapterPosition(view);
        if(index == 0){
            outRect.set(0, space, space, space);
        } else if(index == parent.getChildCount()){
            outRect.set(space, space, 0, space);
        } else {
            outRect.set(space, space, space, space);
        }
    }
}
