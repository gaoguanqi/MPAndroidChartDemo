package com.maple.smaple.mpandroidchartdemo.gridlayout;

import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.jakewharton.rxbinding2.view.RxView;
import com.maple.smaple.mpandroidchartdemo.MainActivity;
import com.maple.smaple.mpandroidchartdemo.R;
import com.maple.smaple.mpandroidchartdemo.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;

public class GridViewActivity extends BaseActivity {

    @BindView(R.id.recycleView)
    RecyclerView recyclerView;
     @BindView(R.id.btn_add)
    Button btnAdd;
    @BindView(R.id.btn_sub)
    Button btnSub;
    private GridAdapter mAdapter;
    private List<GridEntity> list;

    @Override
    protected int setLayoutId() {
        return R.layout.activity_grid_view;
    }


    @Override
    protected void initData(Bundle savedInstanceState) {
        setTitleBack();
        mAdapter = new GridAdapter(this);
        GridLayoutManager layoutManager = new GridLayoutManager(this, 4);
        //LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        //recyclerView.setItemAnimator(new SlideInLeftAnimator());
        //recyclerView.setItemAnimator(new LandingAnimator());

        recyclerView.setAdapter(mAdapter);
        DefaultItemAnimator defaultItemAnimator = new DefaultItemAnimator();
        defaultItemAnimator.setAddDuration(1000);
        defaultItemAnimator.setRemoveDuration(1000);
        recyclerView.setItemAnimator(defaultItemAnimator);


        list = new ArrayList<>();
        GridEntity entity;
        for (int i = 1; i <= 5; i++) {
            entity = new GridEntity(String.valueOf(i), String.valueOf(i));
            list.add(entity);
        }
        mAdapter.setData(list);



        //2s防抖点击
        addDisposable(RxView.clicks(btnAdd)
                .throttleFirst(2, TimeUnit.SECONDS)
                .subscribe(o -> {
                    GridEntity mEntity = new GridEntity(String.valueOf(list.size() + 1), String.valueOf(list.size() + 1));
                    list.add(mEntity);
                    mAdapter.notifyItemChanged(list.size());
                    recyclerView.scrollToPosition(list.size() - 1);
                }));

        addDisposable(RxView.clicks(btnSub)
                .throttleFirst(2, TimeUnit.SECONDS)
                .subscribe(o -> {
                    if (list.isEmpty()) {
                      return;
                    }
                    list.remove(list.size() - 1);
                    mAdapter.notifyItemChanged(list.size());
                    recyclerView.scrollToPosition(list.size() - 1);
                }));
    }
}
