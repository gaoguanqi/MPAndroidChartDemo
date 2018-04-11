package com.maple.smaple.mpandroidchartdemo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.maple.smaple.mpandroidchartdemo.barchart.BarChartActivity;
import com.maple.smaple.mpandroidchartdemo.base.BaseActivity;
import com.maple.smaple.mpandroidchartdemo.bubblechart.BubbleChartActivity;
import com.maple.smaple.mpandroidchartdemo.candlestickchart.CandleStickChartActivity;
import com.maple.smaple.mpandroidchartdemo.combinedchart.CombinedChartActivity;
import com.maple.smaple.mpandroidchartdemo.kchart.KChartActivity;
import com.maple.smaple.mpandroidchartdemo.linechart.LineChartActivity;
import com.maple.smaple.mpandroidchartdemo.login.LoginActivity;
import com.maple.smaple.mpandroidchartdemo.piechart.PieChartActivity;
import com.maple.smaple.mpandroidchartdemo.radarchart.RadarChartActivity;
import com.maple.smaple.mpandroidchartdemo.scatterchart.ScatterChartActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    protected int setLayoutId() {
        return R.layout.activity_main;
    }


    @Override
    protected void initTitle() {
        setTitleBack();
    }

    /**
     * 设置不同的图表
         1. 折线图 LineChart
         2. 条形图 BarChart
         3. 条形折线图 Combined-Chart
         4. 圆饼图 PieChart
         5. 雷达图 ScatterChart
         6. K线图 CandleStickChart
         7. 泡泡图 BubbleChart
         8. 网状图 RadarChart
     * @param view
     */
    @OnClick({R.id.btn_lineChart,
            R.id.btn_barChart,
            R.id.btn_combinedChart,
            R.id.btn_pieChart,
            R.id.btn_scatterChart,
            R.id.btn_candleStickChart,
            R.id.btn_bubbleChart,
            R.id.btn_radarChart,
            R.id.btn_login,
            R.id.btn_kChart})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_lineChart:
                startActivity(new Intent(this, LineChartActivity.class));
                break;
            case R.id.btn_barChart:
                startActivity(new Intent(this, BarChartActivity.class));
                break;
            case R.id.btn_combinedChart:
                startActivity(new Intent(this, CombinedChartActivity.class));
                break;
            case R.id.btn_pieChart:
                startActivity(new Intent(this, PieChartActivity.class));
                break;
            case R.id.btn_scatterChart:
                startActivity(new Intent(this, ScatterChartActivity.class));
                break;
            case R.id.btn_candleStickChart:
                startActivity(new Intent(this, CandleStickChartActivity.class));
                break;
            case R.id.btn_bubbleChart:
                startActivity(new Intent(this, BubbleChartActivity.class));
                break;
            case R.id.btn_login:
                startActivity(new Intent(this, LoginActivity.class));
                break;
            case R.id.btn_kChart:
                startActivity(new Intent(this, KChartActivity.class));
                break;
             default:
                 break;
        }
    }
}
