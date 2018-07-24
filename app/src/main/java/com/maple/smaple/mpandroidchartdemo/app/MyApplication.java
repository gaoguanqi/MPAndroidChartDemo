package com.maple.smaple.mpandroidchartdemo.app;

import android.app.Application;

/**
 * @Author: Gao
 * @Time: 2018/7/24 10:57
 * @Description: 功能描述
 */
public class MyApplication extends Application {
    private static MyApplication app;
    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
    }

    public static MyApplication getInstance() {
        return app;
    }

}
