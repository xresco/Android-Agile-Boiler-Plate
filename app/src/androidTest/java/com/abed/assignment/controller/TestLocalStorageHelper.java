package com.abed.assignment.controller;

import android.content.Context;
import android.content.SharedPreferences;

import com.abed.assignment.injection.ApplicationContext;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class TestLocalStorageHelper extends LocalStorageHelper {


    public TestLocalStorageHelper(@ApplicationContext Context context) {
        super(context);
    }

    public ArrayList<String> getSearchHistory() {
        ArrayList<String> list = new ArrayList<>();
        list.add("a");
        list.add("a");
        list.add("a");
        list.add("b");
        return list;
    }

}
