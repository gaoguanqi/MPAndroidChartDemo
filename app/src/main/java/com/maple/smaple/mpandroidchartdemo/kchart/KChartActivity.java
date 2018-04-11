package com.maple.smaple.mpandroidchartdemo.kchart;

import android.graphics.Color;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.LineData;
import com.maple.smaple.mpandroidchartdemo.R;
import com.maple.smaple.mpandroidchartdemo.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class KChartActivity extends BaseActivity {

    @BindView(R.id.bar_chart)
    BarChart mBarChart;

    private BarChartManager barChartManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        barChartManager = new BarChartManager(mBarChart);
        //设置x轴的数据
        ArrayList<Float> xValues = new ArrayList<>();
        for (int i = 0; i <= 10; i++) {
            xValues.add((float) i);
        }
        //设置y轴的数据()
        List<List<Float>> yValues = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            List<Float> yValue = new ArrayList<>();
            for (int j = 0; j <= 10; j++) {
                yValue.add((float) (Math.random() * 30));
            }
            yValues.add(yValue);
        }
        //颜色集合
        List<Integer> colours = new ArrayList<>();
        colours.add(Color.GRAY);
        colours.add(Color.GRAY);
        colours.add(Color.GRAY);
        colours.add(Color.GRAY);

        //线的名字集合
        List<String> names = new ArrayList<>();
        names.add("折线一");
        names.add("折线二");
        names.add("折线三");
        names.add("折线四");
        //创建多条折线的图表
        barChartManager.showBarChart(xValues, yValues, names, colours);
        barChartManager.setXAxis(11f, 0f, 11);
    }

    @Override
    protected int setLayoutId() {
        return R.layout.activity_kchart;
    }

    @Override
    protected void initTitle() {
        setTitleBack();
    }
}
