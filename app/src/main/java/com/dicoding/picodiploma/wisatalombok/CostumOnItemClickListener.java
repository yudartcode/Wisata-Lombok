package com.dicoding.picodiploma.wisatalombok;

import android.view.View;

public class CostumOnItemClickListener implements View.OnClickListener {
    private int position;
    private OnItemClickCallBack onItemClickCallBack;

    CostumOnItemClickListener(int position, OnItemClickCallBack onItemClickCallBack) {
        this.position = position;
        this.onItemClickCallBack = onItemClickCallBack;
    }

    public interface OnItemClickCallBack {
        void onItemClicked(View view, int position);
    }

    @Override
    public void onClick(View v) {
        onItemClickCallBack.onItemClicked(v, position);
    }
}
