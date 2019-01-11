package com.software.thedung.dzrecyclerviewlb.models;

import java.util.ArrayList;


/*
With your parent class model, please extend this class to use function
 */
public class ParentModel {
    private String title;
    private ArrayList listChildData;

    public ParentModel() {
    }

    public String getTitle() {
        return title;
    }

    public ArrayList getListChildData() {
        return listChildData;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setListChildData(ArrayList listChildData) {
        this.listChildData = listChildData;
    }
}
