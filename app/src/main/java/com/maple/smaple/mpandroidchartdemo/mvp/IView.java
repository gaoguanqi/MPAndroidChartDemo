package com.maple.smaple.mpandroidchartdemo.mvp;

import android.support.annotation.NonNull;

/**
 * @Author: Gao
 * @Time: 2018/7/24 14:25
 * @Description: 功能描述
 */
public interface IView {

    /**
     * 显示信息
     * @param message 消息内容, 不能为 {@code null}
     */
    void showMessage(@NonNull String message);


}
