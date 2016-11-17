package com.abed.assignment.data.model;

import com.raizlabs.android.dbflow.annotation.Database;

/**
 * Created by abed on 11/17/16.
 */

@Database(name = AppDatabase.NAME, version = AppDatabase.VERSION)
public class AppDatabase {

    public static final String NAME = "AppDatabase";

    public static final int VERSION = 1;
}
