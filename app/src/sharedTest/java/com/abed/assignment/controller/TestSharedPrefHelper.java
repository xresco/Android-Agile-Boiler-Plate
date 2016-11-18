package com.abed.assignment.controller;

import android.content.Context;

import com.abed.assignment.injection.ApplicationContext;

import java.util.ArrayList;

import javax.inject.Singleton;

@Singleton
public class TestSharedPrefHelper extends SharedPrefHelper {


    public TestSharedPrefHelper(@ApplicationContext Context context) {
        super(context);
    }

    @Override
    public void addSearchKeyToHistory(String searchKey) {
    }

    @Override
    public void clear() {
    }

    @Override
    public ArrayList<String> getSearchHistory() {
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
