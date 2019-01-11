package com.software.thedung.dzrecyclerviewlb.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.software.thedung.dzrecyclerviewlb.listeners.InitChildViewListener;
import com.software.thedung.dzrecyclerviewlb.listeners.InsideItemClickListener;

import java.util.ArrayList;

public class InsideAdapter extends RecyclerView.Adapter<InsideAdapter.MyViewHolder> {

    private InitChildViewListener initChildViewListener;
    private int childView;
    private InsideItemClickListener insideItemClickListener;
    private ArrayList listData;
    private Context context;

    public InsideAdapter(InitChildViewListener initChildViewListener, int childView, InsideItemClickListener insideItemClickListener, ArrayList listData, Context context) {
        this.initChildViewListener = initChildViewListener;
        this.childView = childView;
        this.insideItemClickListener = insideItemClickListener;
        this.listData = listData;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(context).inflate(childView, viewGroup, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        initChildViewListener.onChildBindViewHolder(myViewHolder, i);
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }


    class MyViewHolder extends RecyclerView.ViewHolder {
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            initChildViewListener.initChildViewHolder(itemView);
        }
    }
}
