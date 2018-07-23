package com.maple.smaple.mpandroidchartdemo.savestate;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.EditText;

import com.maple.smaple.mpandroidchartdemo.R;
import com.maple.smaple.mpandroidchartdemo.base.BaseActivity;

import butterknife.BindView;

public class SaveSateActivity extends BaseActivity {

    @BindView(R.id.et_input)
    EditText etInput;

    @Override
    protected int setLayoutId() {
        return R.layout.activity_save_sate;
    }

    @Override
    protected void initTitle() {

    }

    @Override
    protected void initData(Bundle savedInstanceState) {
        if(savedInstanceState != null){
            String abc = savedInstanceState.getString("key");
            etInput.setText(abc);
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        String str = etInput.getText().toString().trim();
        if(!TextUtils.isEmpty(str)){
            outState.putString("key", str);
        }

        super.onSaveInstanceState(outState);
    }
}
