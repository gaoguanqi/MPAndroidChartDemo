package com.maple.smaple.mpandroidchartdemo.webview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.maple.smaple.mpandroidchartdemo.R;
import com.maple.smaple.mpandroidchartdemo.base.BaseActivity;

import butterknife.BindView;

public class WebViewActivity extends BaseActivity {

    @BindView(R.id.webview)
    WebView webView;

    //WebView 加载这个url 打不开 ,起其他手机就可以，什么原因呢
    String url = "http://dbsiren.xiaoxinyong.com/open/cards/call_stat?card_id=1&user_id=4";

    @Override
    protected int setLayoutId() {
        return R.layout.activity_web_view;
    }

    @Override
    protected void initTitle() {
    }

    @Override
    protected void initData(Bundle savedInstanceState) {
//        WebSettings settings = webView.getSettings();
//        settings.setJavaScriptCanOpenWindowsAutomatically(true);//设置js可以直接打开窗口，如window.open()，默认为false
//        settings.setJavaScriptEnabled(true);//是否允许执行js，默认为false。设置true时，会提醒可能造成XSS漏洞
//        settings.setSupportZoom(true);//是否可以缩放，默认true
//        settings.setBuiltInZoomControls(true);//是否显示缩放按钮，默认false
//        settings.setUseWideViewPort(true);//设置此属性，可任意比例缩放。大视图模式
//        settings.setLoadWithOverviewMode(true);//和setUseWideViewPort(true)一起解决网页自适应问题
//        settings.setAppCacheEnabled(true);//是否使用缓存
//        settings.setDomStorageEnabled(true);//DOM Storage


        WebSettings webSetting = webView.getSettings();
        webSetting.setJavaScriptEnabled(true); //是否允许执行js，默认为false。设置true时，会提醒可能造成XSS漏洞
        webSetting.setJavaScriptCanOpenWindowsAutomatically(true);//设置js可以直接打开窗口，如window.open()，默认为false
        webSetting.setAllowFileAccess(true);
        webSetting.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
        webSetting.setSupportZoom(true);//是否可以缩放，默认true
        webSetting.setUseWideViewPort(true);//设置此属性，可任意比例缩放。大视图模式
        webSetting.setDisplayZoomControls(false);
        webSetting.setBuiltInZoomControls(true);//是否显示缩放按钮，默认false
        webSetting.setSupportMultipleWindows(true);
        webSetting.setAppCacheEnabled(true);//是否使用缓存
        webSetting.setDomStorageEnabled(true);//DOM Storage
        webSetting.setAppCacheMaxSize(Long.MAX_VALUE);
        webSetting.setPluginState(WebSettings.PluginState.ON_DEMAND);
        webSetting.setCacheMode(WebSettings.LOAD_NO_CACHE);
        webSetting.setLoadWithOverviewMode(true);
        webSetting.setGeolocationEnabled(true);
        String userAgent = webSetting.getUserAgentString();
        webSetting.setUserAgentString(userAgent);
        webSetting.setAppCacheEnabled(true);
        webSetting.setDatabaseEnabled(true);
        webSetting.setMediaPlaybackRequiresUserGesture(false);
//        if (NetWorkUtil.isConnected(getContext())) {
//            // 根据cache-control决定是否从网络上取数据
//            webSetting.setCacheMode(WebSettings.LOAD_DEFAULT);
//        } else {
//            // 没网，离线加载，优先加载缓存(即使已经过期)
//            webSetting.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
//        }

        webView.loadUrl(url);

        //该方法解决的问题是打开浏览器不调用系统浏览器，直接用webview打开
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });



    }
}
