package com.maple.smaple.mpandroidchartdemo.viewapge;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

import com.maple.smaple.mpandroidchartdemo.R;
import com.maple.smaple.mpandroidchartdemo.base.BaseActivity;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;

public class PageActivity extends BaseActivity {

    @BindView(R.id.vp)
    ViewPager vp;
    @BindView(R.id.indicator)
    CircleIndicator indicator;
    private ArrayList<View> mLists;
    //是否在触摸
    public boolean mIsTouch = false;
    private int mCurrentPage;

    @Override
    protected int setLayoutId() {
        return R.layout.activity_page;
    }

    @Override
    protected void initData(Bundle savedInstanceState) {
        mLists = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            View view = new View(this);
            view.setBackgroundColor(0xff000000 | random.nextInt(0x00ffffff));
            mLists.add(view);
        }

        vp.setAdapter(new MyPagerAdapter(mLists));
        indicator.setViewPager(vp);

        Observable.interval(1,TimeUnit.SECONDS)  // 5s的延迟，5s的循环时间
                .subscribeOn(AndroidSchedulers.mainThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(l->{
                    mCurrentPage++;
                    vp.setCurrentItem(mCurrentPage);
                    if(mCurrentPage == mLists.size()-1){
                        mCurrentPage = 0;
                    }
                });
    }
}
