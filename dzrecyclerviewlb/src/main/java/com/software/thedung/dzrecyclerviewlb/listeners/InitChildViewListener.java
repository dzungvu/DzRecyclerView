package com.software.thedung.dzrecyclerviewlb.listeners;

import android.support.v7.widget.RecyclerView;
import android.view.View;

public interface InitChildViewListener {
    public void initChildViewHolder(View view);
    public void onChildBindViewHolder(RecyclerView.ViewHolder viewHolder, int position);
}
