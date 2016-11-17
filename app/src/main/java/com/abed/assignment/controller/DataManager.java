package com.abed.assignment.controller;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class DataManager {

    private final ApiHelper mApiHelper;
    private final SharedPrefHelper mSharedPrefHelper;
    private final EventBusHelper mEventBusHelper;
    private final LocalFileHelper mLocalFileHelper;
    private final DatabaseHelper mDatabaseHelper;

    @Inject
    public DataManager(SharedPrefHelper sharedPrefHelper,
                       EventBusHelper eventBusHelper,
                       ApiHelper apiHelper,
                       DatabaseHelper databaseHelper,
                       LocalFileHelper localFileHelper) {
        mSharedPrefHelper = sharedPrefHelper;
        mEventBusHelper = eventBusHelper;
        mApiHelper = apiHelper;
        mLocalFileHelper = localFileHelper;
        this.mDatabaseHelper = databaseHelper;
    }

    public EventBusHelper getEventBusHelper() {
        return mEventBusHelper;
    }

    public ApiHelper getApiHelper() {
        return mApiHelper;
    }

    public SharedPrefHelper getSharedPrefHelper() {
        return mSharedPrefHelper;
    }

    public LocalFileHelper getLocalFileHelper() {
        return mLocalFileHelper;
    }

    public DatabaseHelper getDatabaseHelper() {
        return mDatabaseHelper;
    }
}
