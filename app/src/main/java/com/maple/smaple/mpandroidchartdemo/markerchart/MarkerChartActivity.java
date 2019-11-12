package com.maple.smaple.mpandroidchartdemo.markerchart;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.maple.smaple.mpandroidchartdemo.R;
import com.maple.smaple.mpandroidchartdemo.base.BaseActivity;
import com.maple.smaple.mpandroidchartdemo.markerchart.activity.BarChartActivity;
import com.maple.smaple.mpandroidchartdemo.markerchart.activity.CombinedChartActivity;
import com.maple.smaple.mpandroidchartdemo.markerchart.activity.DynamicLineChartActivity;
import com.maple.smaple.mpandroidchartdemo.markerchart.activity.LineChartActivity;
import com.maple.smaple.mpandroidchartdemo.markerchart.activity.MeterActivity;
import com.maple.smaple.mpandroidchartdemo.markerchart.activity.PieChartActivity;
import com.maple.smaple.mpandroidchartdemo.markerchart.activity.RadarChartActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MarkerChartActivity extends BaseActivity {

    @Override
    protected int setLayoutId() {
        return R.layout.activity_marker_chart;
    }

    @Override
    protected void initData(Bundle savedInstanceState) {

    }


    @OnClick({R.id.view_line_chart, R.id.view_line_chart_date, R.id.view_bar_chart, R.id.view_pie_chart, R.id.view_meter, R.id.view_radar, R.id.view_combined})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.view_line_chart:
                startActivity(new Intent(this, LineChartActivity.class));
                break;
            case R.id.view_line_chart_date:
                startActivity(new Intent(this, DynamicLineChartActivity.class));
                break;
            case R.id.view_bar_chart:
                startActivity(new Intent(this, BarChartActivity.class));
                break;
            case R.id.view_pie_chart:
                startActivity(new Intent(this, PieChartActivity.class));
                break;
            case R.id.view_meter:
                startActivity(new Intent(this, MeterActivity.class));
                break;
            case R.id.view_radar:
                startActivity(new Intent(this, RadarChartActivity.class));
                break;
            case R.id.view_combined:
                startActivity(new Intent(this, CombinedChartActivity.class));
                break;
            default:
                break;
        }
    }
}
