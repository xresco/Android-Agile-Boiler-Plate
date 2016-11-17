package com.abed.assignment.data.model;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

import java.util.Date;

/**
 * Created by abed on 11/17/16.
 */

@Table(database = AppDatabase.class)
public class SearchItem extends BaseModel { // convenience, but not required to interact with db

    @PrimaryKey(autoincrement = true)
    int id;


    @Column
    public String content;


    @Column
    public Date date;

}