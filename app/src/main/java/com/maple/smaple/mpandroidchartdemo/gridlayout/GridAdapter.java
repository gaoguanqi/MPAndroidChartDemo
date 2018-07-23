package com.maple.smaple.mpandroidchartdemo.gridlayout;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.maple.smaple.mpandroidchartdemo.R;

import java.util.List;

/**
 * @Author: Gao
 * @Time: 2018/7/20 15:01
 * @Description: 功能描述
 */
public class GridAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private Context mContext;
    private List<GridEntity> mData;

    public GridAdapter(Context context) {
        this.mContext = context;
    }

    public void setData(List<GridEntity> data){
        this.mData = data;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new MyViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_grid,viewGroup,false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        if (viewHolder instanceof MyViewHolder) {
            ((MyViewHolder)viewHolder).setData(mData.get(i));
        }
    }

    @Override
    public int getItemCount() {
        return mData == null ? 0 : mData.size();
    }
}
