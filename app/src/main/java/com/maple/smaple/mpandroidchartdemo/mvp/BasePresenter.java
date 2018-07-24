package com.maple.smaple.mpandroidchartdemo.mvp;

/**
 * @Author: Gao
 * @Time: 2018/7/24 14:30
 * @Description: 功能描述
 */
public class BasePresenter<M extends IModel, V extends IView> implements IPresenter{
    protected M mModel;
    protected V mView;


}
