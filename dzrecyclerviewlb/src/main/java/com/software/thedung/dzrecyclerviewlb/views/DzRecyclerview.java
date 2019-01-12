package com.software.thedung.dzrecyclerviewlb.views;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;

import com.software.thedung.dzrecyclerviewlb.R;
import com.software.thedung.dzrecyclerviewlb.adapters.InsideAdapter;
import com.software.thedung.dzrecyclerviewlb.adapters.OutsideAdapter;
import com.software.thedung.dzrecyclerviewlb.listeners.InitChildViewListener;
import com.software.thedung.dzrecyclerviewlb.listeners.InsideItemClickListener;
import com.software.thedung.dzrecyclerviewlb.listeners.OutsideItemClickListener;
import com.software.thedung.dzrecyclerviewlb.models.ParentModel;

import java.util.ArrayList;

public class DzRecyclerview extends RecyclerView implements InitChildViewListener, InsideItemClickListener, OutsideItemClickListener {

    private RecyclerView rcvParent;
    private ArrayList<ParentModel> listData;
    private OutsideAdapter outsideAdapter;
    private InsideAdapter insideAdapter;
    private OutsideItemClickListener outsideItemClickListener;
    private InsideItemClickListener insideItemClickListener;
    private Context context;

    private int childView;
    private InitChildViewListener childViewListener;
    private int childViewType;

    public DzRecyclerview(@NonNull Context context) {
        super(context);
    }

    public DzRecyclerview(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public DzRecyclerview(@NonNull Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public void init(AttributeSet atts, Context context) {

        View view = inflate(context, R.layout.dz_recyclerview, this);
        rcvParent = view.findViewById(R.id.rcv_parent);
        rcvParent.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false));
    }

    public void setUpView(ArrayList<ParentModel> listData, OutsideItemClickListener outsideItemClickListener, InsideItemClickListener insideItemClickListener, Context context) {
        this.listData = listData;
        this.outsideItemClickListener = outsideItemClickListener;
        this.insideItemClickListener = insideItemClickListener;
        this.context = context;
    }

    public void setUpChildView(int childView, InitChildViewListener childViewListener, int childViewType) {
        this.childView = childView;
        this.childViewListener = childViewListener;
        this.childViewType = childViewType;
    }

    private void setUpAdapter() {
        outsideAdapter = new OutsideAdapter(context, listData, this, OutsideAdapter.HORIZONTAL);
        rcvParent.setAdapter(outsideAdapter);
    }

    @Override
    public void initChildViewHolder(View view) {
        childViewListener.initChildViewHolder(view);
    }

    @Override
    public void onChildBindViewHolder(ViewHolder viewHolder, int position) {
        childViewListener.onChildBindViewHolder(viewHolder, position);
    }

    @Override
    public void onItemSelected(View v, int parentPosition, int position) {
        insideItemClickListener.onItemSelected(v, parentPosition, position);
    }

    @Override
    public void onItemSelected(View v, int position) {
        outsideItemClickListener.onItemSelected(v, position);
    }
}
