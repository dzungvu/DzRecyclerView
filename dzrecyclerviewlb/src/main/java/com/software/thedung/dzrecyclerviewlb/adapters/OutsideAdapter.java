package com.software.thedung.dzrecyclerviewlb.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.software.thedung.dzrecyclerviewlb.R;
import com.software.thedung.dzrecyclerviewlb.listeners.InitChildViewListener;
import com.software.thedung.dzrecyclerviewlb.listeners.OutsideItemClickListener;
import com.software.thedung.dzrecyclerviewlb.models.ParentModel;

import java.util.ArrayList;

public class OutsideAdapter extends RecyclerView.Adapter<OutsideAdapter.MyViewHolder> {
    public static final int VERTICAL = 0;
    public static final int HORIZONTAL = 1;

    // For parent view
    private Context context;
    private ArrayList<ParentModel> listData;
    private OutsideItemClickListener outsideItemClickListener;
    private int childLayoutType;

    public OutsideAdapter(Context context, ArrayList<ParentModel> listData, OutsideItemClickListener outsideItemClickListener, int childLayoutType) {
        this.context = context;
        this.listData = listData;
        this.outsideItemClickListener = outsideItemClickListener;
        this.childLayoutType = childLayoutType;
    }

    public void setChildLayoutType(int listLayoutType) {
        this.childLayoutType = listLayoutType;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.my_list_item, viewGroup, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        myViewHolder.tvTitle.setText(listData.get(i).getTitle());
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView tvTitle;
        private RecyclerView recyclerView;
        private RecyclerView.Adapter adapter;
        private ArrayList childList;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tv_title);
            recyclerView = itemView.findViewById(R.id.rcv_list_item);
            childList = listData.get(getAdapterPosition()).getListChildData();

            try {
                LinearLayoutManager layoutManager;
                if (childLayoutType == VERTICAL) {
                    layoutManager = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
                } else {
                    layoutManager = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
                }

                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setAdapter(adapter);

            } catch (NullPointerException ex) {
                ex.printStackTrace();
            }
        }
    }
}
