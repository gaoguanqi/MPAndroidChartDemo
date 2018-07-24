package com.maple.smaple.mpandroidchartdemo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.maple.smaple.mpandroidchartdemo.base.BaseActivity;
import com.maple.smaple.mpandroidchartdemo.gridlayout.GridViewActivity;
import com.maple.smaple.mpandroidchartdemo.linechart.LineChartActivity;
import com.maple.smaple.mpandroidchartdemo.nbbutton.MyFirstActivity;
import com.maple.smaple.mpandroidchartdemo.progress.ProgressActivity;
import com.maple.smaple.mpandroidchartdemo.savestate.SaveSateActivity;
import com.maple.smaple.mpandroidchartdemo.webview.WebViewActivity;

import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    @Override
    protected int setLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initData(Bundle savedInstanceState) {
        setTitleBack();

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }



    @OnClick({R.id.btn_lineChart,R.id.btn_savestate,R.id.btn_webview,R.id.btn_gridView,R.id.btn_nbbutton})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_lineChart:
                startActivity(new Intent(this, LineChartActivity.class));
                break;
            case R.id.btn_savestate:
                startActivity(new Intent(this, SaveSateActivity.class));
                break;
            case R.id.btn_webview:
                startActivity(new Intent(this, WebViewActivity.class));
                break;
            case R.id.btn_gridView:
                startActivity(new Intent(this, GridViewActivity.class));
                break;
            case R.id.btn_progressView:
                startActivity(new Intent(this, ProgressActivity.class));
                break;
            case R.id.btn_nbbutton:
                startActivity(new Intent(this, MyFirstActivity.class));
                break;
             default:
                 break;
        }
    }
}
