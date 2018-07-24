package com.maple.smaple.mpandroidchartdemo.nbbutton;

import android.animation.Animator;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.widget.RelativeLayout;

import com.maple.smaple.mpandroidchartdemo.R;
import com.maple.smaple.mpandroidchartdemo.base.BaseActivity;

public class MyFirstActivity extends BaseActivity {
    private NbButton button;
    private RelativeLayout rlContent;
    private Handler handler;
    private Animator animator;


    @Override
    protected int setLayoutId() {
        return R.layout.activity_my_first;
    }

    @Override
    protected void initData(Bundle savedInstanceState) {
        button=findViewById(R.id.button_test);
        rlContent=findViewById(R.id.rl_content);

        rlContent.getBackground().setAlpha(0);
        handler=new Handler();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button.startAnim();

                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        //跳转
                        gotoNew();
                    }
                },3000);

            }
        });
    }

    private void gotoNew() {
        button.gotoNew();

        final Intent intent=new Intent(this,MyScondActivity.class);

        int xc=(button.getLeft()+button.getRight())/2;
        int yc=(button.getTop()+button.getBottom())/2;
        animator= ViewAnimationUtils.createCircularReveal(rlContent,xc,yc,0,1111);


        animator.setDuration(300);
        animator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        startActivity(intent);
                        overridePendingTransition(R.anim.anim_in,R.anim.anim_out);

                    }
                },200);
            }

            @Override
            public void onAnimationEnd(Animator animation) {

            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
        animator.start();
        rlContent.getBackground().setAlpha(255);
    }

    @Override
    protected void onStop() {
        super.onStop();
        animator.cancel();
        rlContent.getBackground().setAlpha(0);
        button.regainBackground();
    }
}
