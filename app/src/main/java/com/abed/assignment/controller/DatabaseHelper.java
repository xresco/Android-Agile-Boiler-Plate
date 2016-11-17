package com.abed.assignment.controller;

import android.app.Application;

import com.abed.assignment.data.model.SearchItem;
import com.raizlabs.android.dbflow.config.FlowConfig;
import com.raizlabs.android.dbflow.config.FlowManager;
import com.raizlabs.android.dbflow.sql.language.SQLite;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Provides helper methods to save and retrieve values from the DB
 */
public class DatabaseHelper {

    public DatabaseHelper(Application application) {
        //Init DbFlow
        FlowManager.init(new FlowConfig.Builder(application).build());
    }

    public void clear() {
        SQLite.delete()
                .from(SearchItem.class).execute();
    }

    public void addSearchKeyToHistory(String searchKey) {
        SearchItem searchItem = new SearchItem();
        searchItem.content = searchKey;
        searchItem.date = new Date();
        searchItem.save();

    }

    public List<String> getSearchHistory() {
        List<SearchItem> items = SQLite.select()
                .from(SearchItem.class).queryList();

        List<String> stringItems = new ArrayList<>();
        for (SearchItem item : items)
            stringItems.add(item.content);
        return stringItems;
    }

}
