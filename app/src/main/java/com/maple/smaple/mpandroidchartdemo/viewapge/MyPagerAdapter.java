package com.maple.smaple.mpandroidchartdemo.viewapge;

import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * @Author: Gao
 * @Time: 2018/7/24 19:08
 * @Description: 功能描述
 */
public class MyPagerAdapter extends PagerAdapter{
    private ArrayList<View> mLists;

    public MyPagerAdapter(ArrayList<View> lists) {
        this.mLists = lists;
    }

    @Override
    public int getCount() {
        return mLists == null ? 0 :mLists.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == o;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        container.addView(mLists.get(position));
        return mLists.get(position);
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView(mLists.get(position));
    }
}
