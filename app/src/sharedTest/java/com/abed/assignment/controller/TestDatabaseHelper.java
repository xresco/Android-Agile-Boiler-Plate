package com.abed.assignment.controller;

import android.app.Application;

import java.util.ArrayList;
import java.util.List;

/**
 * Provides helper methods to save and retrieve values from the DB
 */
public class TestDatabaseHelper extends DatabaseHelper {

    public TestDatabaseHelper(Application application) {
        super(application);
    }

    @Override
    public void clear() {
    }

    @Override
    public void addSearchKeyToHistory(String searchKey) {
    }

    @Override
    public List<String> getSearchHistory() {
        ArrayList<String> list = new ArrayList<>();
        list.add("a");
        list.add("a");
        list.add("a");
        list.add("b");
        list.add("b");
        list.add("b");
        return list;
    }
}
