package com.abed.assignment.controller;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class DataManager {

    private final ApiHelper mApiHelper;
    private final SharedPrefHelper mSharedPrefHelper;
    private final EventBusHelper mEventBusHelper;
    private final LocalFileHelper mLocalFileHelper;

    @Inject
    public DataManager(SharedPrefHelper sharedPrefHelper,
                       EventBusHelper eventBusHelper,
                       ApiHelper apiHelper,
                       LocalFileHelper localFileHelper) {
        mSharedPrefHelper = sharedPrefHelper;
        mEventBusHelper = eventBusHelper;
        mApiHelper = apiHelper;
        mLocalFileHelper = localFileHelper;
    }

    public EventBusHelper getEventBusHelper() {
        return mEventBusHelper;
    }

    public ApiHelper getApiHelper() {
        return mApiHelper;
    }

    public SharedPrefHelper getLocalStorageHelper() {
        return mSharedPrefHelper;
    }
}
