package com.maple.smaple.mpandroidchartdemo.toast;

import android.content.Context;
import android.view.Gravity;
import android.widget.Toast;

/**
 * @Author: Gao
 * @Time: 2018/7/19 15:38
 * @Description: 功能描述
 */
public class ToastUtils {
    private static MyToast myToast;

    public static MyToast init(Context context,String msg) {
        //创建Toast
        return  myToast = new MyToast.Builder(context)
                .setMessage(msg)//设置提示文字
                .setBackgroundColor(0xe9ff4587)//设置背景颜色
                .setGravity(Gravity.CENTER)//设置吐司位置
                .showIcon(true)//是否显示图标
                .build();//创建吐司
    }



    public static void show(){
        myToast.show();
    }
}
