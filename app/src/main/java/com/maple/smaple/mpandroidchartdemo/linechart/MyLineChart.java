package com.maple.smaple.mpandroidchartdemo.linechart;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;

import com.blankj.utilcode.util.ResourceUtils;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.LimitLine;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.maple.smaple.mpandroidchartdemo.utils.LogUtils;

import java.util.List;

/**
 * @Author: Gao
 * @Time: 2018/7/18 11:46
 * @Description: 功能描述
 */
public class MyLineChart extends LineChart {

    public MyLineChart(Context context) {
        super(context);
        init(context);
    }



    public MyLineChart(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public MyLineChart(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context);
    }
    Paint paint;
    private void init(Context context) {
         paint = new Paint();
         paint.setColor(Color.RED);
    }

//    @Override
//    public void setData(LineData data) {
//        List<ILineDataSet> dataSets = data.getDataSets();
//        ILineDataSet dataSet = dataSets.get(0);
//
//        float maxY = dataSet.getYMax();
//
//        //切换显示/隐藏
//        dataSet.setDrawValues(!dataSet.isDrawValuesEnabled());
//        super.setData(data);
//    }





    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
    }
}
