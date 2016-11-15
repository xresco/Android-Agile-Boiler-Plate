package com.abed.assignment.controller;

import android.content.Context;
import android.content.SharedPreferences;

import com.abed.assignment.injection.ApplicationContext;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class LocalStorageHelper {

    public static final String PREF_FILE_NAME = "android_pref_file";
    public static final String PREF_HISTORY_KEY = "PREF_HISTORY_KEY";

    private final SharedPreferences mPref;

    public LocalStorageHelper(@ApplicationContext Context context) {
        mPref = context.getSharedPreferences(PREF_FILE_NAME, Context.MODE_PRIVATE);
    }

    public void clear() {
        mPref.edit().clear().apply();
    }

    public void addSearchKeyToHistory(String searchKey) {
        ArrayList<String> searchItems = getSearchHistory();
        searchItems.add(0, searchKey);
        String dataStr = new Gson().toJson(searchItems);
        mPref.edit().putString(PREF_HISTORY_KEY, dataStr).apply();

    }

    public ArrayList<String> getSearchHistory() {
        String dataStr = mPref.getString(PREF_HISTORY_KEY, null);
        if (dataStr == null)
            return new ArrayList<>();
        Type type = new TypeToken<ArrayList<String>>() {}.getType();
        ArrayList<String> searchHistory = new Gson().fromJson(dataStr, type);
        return searchHistory;
    }

}
