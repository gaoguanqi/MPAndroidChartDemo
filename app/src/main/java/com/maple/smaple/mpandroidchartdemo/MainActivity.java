package com.maple.smaple.mpandroidchartdemo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.maple.smaple.mpandroidchartdemo.base.BaseActivity;
import com.maple.smaple.mpandroidchartdemo.linechart.LineChartActivity;

import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    @Override
    protected int setLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initData(Bundle savedInstanceState) {

    }

    @Override
    protected void initTitle() {
        setTitleBack();
    }


    @OnClick({R.id.btn_lineChart})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_lineChart:
                startActivity(new Intent(this, LineChartActivity.class));
                break;
             default:
                 break;
        }
    }
}
