package com.maple.smaple.mpandroidchartdemo.gridlayout;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.maple.smaple.mpandroidchartdemo.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @Author: Gao
 * @Time: 2018/7/20 18:37
 * @Description: 功能描述
 */
public class MyViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.iv_image)
    ImageView ivImage;
    @BindView(R.id.tv_name)
    TextView tvName;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }

    public void setData(GridEntity entity) {
       // this.data = data;
        tvName.setText(entity.name);
    }
}
