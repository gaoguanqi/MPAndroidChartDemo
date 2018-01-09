package com.maple.smaple.mpandroidchartdemo.linechart;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.maple.smaple.mpandroidchartdemo.R;
import com.maple.smaple.mpandroidchartdemo.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class LineChartActivity extends BaseActivity {

    @BindView(R.id.lineChart)
    LineChart lineChart;

    List<String> xLists;
    List<Entry> values;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Description mDescription = new Description();
        mDescription.setText("线性统计图");
        lineChart.setDescription(mDescription);

    }

    @Override
    protected int setLayoutId() {
        return R.layout.activity_line_chart;
    }

    @Override
    protected void initTitle() {
        setTitleBack();
    }



}
