package com.maple.smaple.mpandroidchartdemo.base;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.gyf.barlibrary.ImmersionBar;
import com.maple.smaple.mpandroidchartdemo.R;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Created by gaogu on 2018/1/8.
 */

public abstract class BaseActivity extends AppCompatActivity {
    protected CompositeDisposable mCompositeDisposable;
    private InputMethodManager mImm;
    protected ImmersionBar mImmersionBar;
    private Unbinder mUnbinder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(setLayoutId());
        //绑定控件
        mUnbinder = ButterKnife.bind(this);
        mCompositeDisposable = new CompositeDisposable();
        //初始化沉浸式
        if (isImmersionBarEnabled())
            initImmersionBar();
        initData(savedInstanceState);
    }
    protected abstract int setLayoutId();


    protected abstract void initData(Bundle savedInstanceState);


    /**
     * 添加订阅
     */
    public void addDisposable(Disposable mDisposable) {
        if (mCompositeDisposable == null) {
            mCompositeDisposable = new CompositeDisposable();
        }
        mCompositeDisposable.add(mDisposable);
    }

    /**
     * 取消所有订阅
     */
    public void clearDisposable() {
        if (mCompositeDisposable != null) {
            mCompositeDisposable.clear();
        }
    }

    protected  void setTitleBack() {



        ImageView ivLeft = findViewById(R.id.iv_titlebar_left);
        TextView tvLeft = findViewById(R.id.tv_titlebar_left);
        TextView tvTitle = findViewById(R.id.tv_titlebar_title);
        ImageView ivRight = findViewById(R.id.iv_titlebar_right);
        TextView tvRight = findViewById(R.id.tv_titlebar_right);

        tvTitle.setText(this.getClass().getSimpleName());

        ivLeft.setOnClickListener(view -> {
            this.finish();
        });

    }

    protected void initImmersionBar() {
        //在BaseActivity里初始化
        mImmersionBar = ImmersionBar.with(this);
        //设置状态栏字体为黑色，如果当前设备不支持状态栏字体变色，会使当前状态栏加上透明度
        mImmersionBar.fitsSystemWindows(true)  //使用该属性,必须指定状态栏颜色
                .keyboardEnable(true)
                .navigationBarWithKitkatEnable(false)
                .navigationBarEnable(false)
                .statusBarColor(R.color.status_color)
                .statusBarDarkFont(true, 0.2f)
                .init();
    }

    /**
     * 是否可以使用沉浸式
     * Is immersion bar enabled boolean.
     *
     * @return the boolean
     */
    protected boolean isImmersionBarEnabled() {
        return true;
    }
    public void finish() {
        super.finish();
        hideSoftKeyBoard();
    }


    public void hideSoftKeyBoard() {
        View localView = getCurrentFocus();
        if (this.mImm == null) {
            this.mImm = ((InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE));
        }
        if ((localView != null) && (this.mImm != null)) {
            this.mImm.hideSoftInputFromWindow(localView.getWindowToken(), 2);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        clearDisposable();
        mUnbinder.unbind();
        this.mImm = null;
        if (mImmersionBar != null)
            mImmersionBar.destroy();  //在BaseActivity里销毁
    }
}
