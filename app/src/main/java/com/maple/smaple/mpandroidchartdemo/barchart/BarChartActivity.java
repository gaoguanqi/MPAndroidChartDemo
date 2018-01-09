package com.maple.smaple.mpandroidchartdemo.barchart;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.maple.smaple.mpandroidchartdemo.R;
import com.maple.smaple.mpandroidchartdemo.base.BaseActivity;

public class BarChartActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int setLayoutId() {
        return R.layout.activity_bar_chart;
    }

    @Override
    protected void initTitle() {
        setTitleBack();
    }
}
