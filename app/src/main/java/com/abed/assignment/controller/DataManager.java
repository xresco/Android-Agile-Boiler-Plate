package com.abed.assignment.controller;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class DataManager {

    private final ApiHelper mApiHelper;
    private final LocalStorageHelper mLocalStorageHelper;
    private final EventBusHelper mEventBusHelper;

    @Inject
    public DataManager(LocalStorageHelper localStorageHelper,
                       EventBusHelper eventBusHelper,
                       ApiHelper apiHelper) {
        mLocalStorageHelper = localStorageHelper;
        mEventBusHelper = eventBusHelper;
        mApiHelper = apiHelper;
    }

    public EventBusHelper getEventBusHelper() {
        return mEventBusHelper;
    }

    public ApiHelper getApiHelper() {
        return mApiHelper;
    }

    public LocalStorageHelper getLocalStorageHelper() {
        return mLocalStorageHelper;
    }
}
