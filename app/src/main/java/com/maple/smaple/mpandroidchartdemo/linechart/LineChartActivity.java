package com.maple.smaple.mpandroidchartdemo.linechart;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Gravity;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.LimitLine;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.maple.smaple.mpandroidchartdemo.R;
import com.maple.smaple.mpandroidchartdemo.base.BaseActivity;
import com.maple.smaple.mpandroidchartdemo.toast.MyToast;

import java.math.BigDecimal;
import java.util.ArrayList;

import butterknife.BindView;

/**
 * @Author: Gao
 * @Time: 2018/7/18 10:32
 * @Description: 功能描述
 * https://blog.csdn.net/qq_26787115/article/details/53185657
 */
public class LineChartActivity extends BaseActivity {
    @BindView(R.id.lineChart)
    LineChart mChart;
    private LineData data;

    @Override
    protected int setLayoutId() {
        return R.layout.activity_line_chart;
    }

    @Override
    protected void initTitle() {

    }

    @Override
    protected void initData(Bundle savedInstanceState) {
        mChart.setDrawGridBackground(false);
        mChart.getLegend().setEnabled(false);// 不显示图例
        mChart.getDescription().setEnabled(false);// 不显示描述
        mChart.setScaleEnabled(false);   // 取消缩放
        mChart.setNoDataText("暂无数据");// 没有数据的时候默认显示的文字
        mChart.setNoDataTextColor(Color.GRAY);
        mChart.setBorderColor(Color.BLUE);
        mChart.setTouchEnabled(true);  // 使能点击
        // 使能拖动和缩放
        mChart.setDragEnabled(true);
        mChart.setScaleEnabled(true);
        // 如果为false，则x，y两个方向可分别缩放
        mChart.setPinchZoom(true);
        // 如果x轴label文字比较大，可以设置边距
        mChart.setExtraRightOffset(25f);
        mChart.setExtraBottomOffset(10f);
        mChart.setExtraTopOffset(10f);


        LimitLine ll1 = new LimitLine(90f, "基线");
        ll1.setLineWidth(1f);
        ll1.enableDashedLine(5f,5f, 0f);
        ll1.setLabelPosition(LimitLine.LimitLabelPosition.RIGHT_TOP);
        ll1.setTextSize(10f);


        //设置x轴位置
        XAxis xAxis = mChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);

        //去除右边的y轴
        YAxis yAxisRight = mChart.getAxisRight();
        yAxisRight.setEnabled(false);
        YAxis yAxisLeft = mChart.getAxisLeft();
        yAxisLeft.addLimitLine(ll1);
        init();

        //创建Toast
        MyToast  myToast = new MyToast.Builder(this)
                .setMessage("自定义Toast效果！")//设置提示文字
                .setBackgroundColor(0xe9ff4587)//设置背景颜色
                .setGravity(Gravity.CENTER)//设置吐司位置
                .showIcon(true)//是否显示图标
                .build();//创建吐司

        myToast.show();


    }

    private void init() {
        //初始化数据
        String xl[] = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}; //横轴数据
        String yl[] = {"91.2", "90.1", "88", "90", "90.1", "88", "90", "91.6", "92.2", "91"}; //竖轴数据
        data = getData(xl, yl);
        mChart.setData(data);
        mChart.animateX(2000);//动画时间
    }

    private LineData getData(String[] xx, String[] yy) {
        ArrayList<Entry> yVals = new ArrayList<Entry>();
        for (int i = 0; i < yy.length; i++) {
            // 要显示的数据
            yVals.add(new Entry(Float.parseFloat(xx[i]), Float.parseFloat(yy[i])));
        }
        //一条曲线对应一个LineDataSet
        LineDataSet set1 = new LineDataSet(yVals,"LineDataSet");
        set1.setMode(LineDataSet.Mode.LINEAR);//设置曲线
        set1.setCubicIntensity(0.2f);
        set1.setDrawCircles(false);  //设置有圆点
        set1.setLineWidth(2f);    //设置线的宽度
       // set1.setCircleSize(5f);   //设置小圆的大小
        set1.setDrawFilled(true);//设置包括的范围区域填充颜色
        set1.setCircleColor(Color.rgb(244, 117, 117));
        set1.setColor(Color.rgb(244, 117, 117));
        ArrayList<ILineDataSet> dataSets = new ArrayList<ILineDataSet>();
        dataSets.add(set1); // add the datasets

        // create a data object with the datasets
        LineData data = new LineData(dataSets);
        return data;

    }
}
