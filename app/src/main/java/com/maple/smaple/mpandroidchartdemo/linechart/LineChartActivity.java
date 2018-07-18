package com.maple.smaple.mpandroidchartdemo.linechart;

import android.graphics.Color;
import android.os.Bundle;

import com.github.mikephil.charting.charts.LineChart;
import com.maple.smaple.mpandroidchartdemo.R;
import com.maple.smaple.mpandroidchartdemo.base.BaseActivity;

import butterknife.BindView;

/**
 * @Author: Gao
 * @Time: 2018/7/18 10:32
 * @Description: 功能描述
 * https://blog.csdn.net/qq_26787115/article/details/53185657
 */
public class LineChartActivity extends BaseActivity {
    @BindView(R.id.lineChart)
    LineChart lineChart;

    @Override
    protected int setLayoutId() {
        return R.layout.activity_line_chart;
    }

    @Override
    protected void initTitle() {

    }

    @Override
    protected void initData(Bundle savedInstanceState) {
        lineChart.getLegend().setEnabled(false);// 不显示图例
        lineChart.getDescription().setEnabled(false);// 不显示描述
        lineChart.setScaleEnabled(false);   // 取消缩放
        lineChart.setNoDataText("暂无数据");// 没有数据的时候默认显示的文字
        lineChart.setNoDataTextColor(Color.GRAY);
        lineChart.setBorderColor(Color.BLUE);
        lineChart.setTouchEnabled(true);
        lineChart.setDragEnabled(true);
        // 如果x轴label文字比较大，可以设置边距
        lineChart.setExtraRightOffset(25f);
        lineChart.setExtraBottomOffset(10f);
        lineChart.setExtraTopOffset(10f);



    }
}
