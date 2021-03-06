package com.yuan.multy_item;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.view.menu.MenuView;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuan 2019/2/13.
 */
public abstract class MultiBaseAdapter<T extends IItemData> extends RecyclerView.Adapter<VH> {

    IItemEvent mItemEvent;

    public MultiBaseAdapter() {
    }

    public MultiBaseAdapter(IItemEvent itemEvent) {
        this.mItemEvent = itemEvent;
    }

    private List<T> mDataList = new ArrayList<>();

    @NonNull
    @Override
    public abstract VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType);


    public void setData(@Nullable List<T> list) {
        if (list != null) {
            mDataList = list;
            notifyDataSetChanged();
        }
    }

    public void addData(@Nullable List<T> list) {
        if (list != null) {
            mDataList.addAll(list);
            notifyDataSetChanged();
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (mDataList != null && mDataList.get(position) != null) {
            return mDataList.get(position).getViewType();
        } else {
            return IItemVew.DEFAULT_TYPE;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull VH viewHolder, int position) {
        T news = mDataList.get(position);
        viewHolder.bindData(position, news, mItemEvent);
    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }


}
