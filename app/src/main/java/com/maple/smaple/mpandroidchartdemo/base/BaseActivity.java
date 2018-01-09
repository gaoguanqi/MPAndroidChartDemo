package com.maple.smaple.mpandroidchartdemo.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.gyf.barlibrary.ImmersionBar;
import com.maple.smaple.mpandroidchartdemo.R;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by gaogu on 2018/1/8.
 */

public abstract class BaseActivity extends AppCompatActivity {
    private InputMethodManager imm;
    protected ImmersionBar mImmersionBar;
    private Unbinder unbinder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setLayoutId());

        //绑定控件
        unbinder = ButterKnife.bind(this);
        //初始化沉浸式
        if (isImmersionBarEnabled())
            initImmersionBar();

        initTitle();
    }
    protected abstract int setLayoutId();

    protected abstract void initTitle();

    protected  void setTitleBack() {
        LinearLayout ll = findViewById(R.id.ll_title_left);
        TextView title = findViewById(R.id.tv_title);
        title.setText(this.getClass().getSimpleName());
        ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
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
        if (this.imm == null) {
            this.imm = ((InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE));
        }
        if ((localView != null) && (this.imm != null)) {
            this.imm.hideSoftInputFromWindow(localView.getWindowToken(), 2);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
        this.imm = null;
        if (mImmersionBar != null)
            mImmersionBar.destroy();  //在BaseActivity里销毁
    }
}
