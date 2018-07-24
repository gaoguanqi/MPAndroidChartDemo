package com.maple.smaple.mpandroidchartdemo.progress;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Toast;

import com.maple.smaple.mpandroidchartdemo.R;
import com.maple.smaple.mpandroidchartdemo.base.BaseActivity;
import com.maple.smaple.mpandroidchartdemo.progress.lib.LoadingButton;
import com.maple.smaple.mpandroidchartdemo.progress.lib.ProcessButton;

public class ProgressActivity extends BaseActivity implements ProcessButton.LoadingListener{
    private static final int MSG_UPDATE = 1;

    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            int progress = normalBtn.getProgress();

            if (progress >= 100) {
                mHandler.removeMessages(MSG_UPDATE);
            } else {
                normalBtn.setProgress(++progress);
            }

            mHandler.sendEmptyMessageDelayed(MSG_UPDATE, 100);
        }
    };


    private LoadingButton normalBtn;
    private LoadingButton completeBtn;
    private LoadingButton errorBtn;
    private LoadingButton processBtn;
    private LoadingButton spotBtn;




    @Override
    protected int setLayoutId() {
        return R.layout.activity_progress;
    }

    @Override
    protected void initData(Bundle savedInstanceState) {
        normalBtn = (LoadingButton) findViewById(R.id.loading_btn_normal);
        normalBtn.setOnLoadingListener(this);
        normalBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mHandler.sendEmptyMessage(MSG_UPDATE);
            }
        });

        completeBtn = (LoadingButton) findViewById(R.id.loading_btn_complete);
        completeBtn.setProgress(100);

        errorBtn = (LoadingButton) findViewById(R.id.loading_btn_error);
        errorBtn.setProgress(-1);

        processBtn = (LoadingButton) findViewById(R.id.loading_btn_process);
        processBtn.setProgress(50);

        spotBtn = (LoadingButton) findViewById(R.id.loading_btn_spot);
        spotBtn.setProgress(50);
    }

    @Override
    public void loadComplete() {
        Toast.makeText(this, "complete", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loadError() {
        Toast.makeText(this, "error", Toast.LENGTH_SHORT).show();
    }
}
