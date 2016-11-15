package com.abed.assignment.controller;

import com.abed.assignment.data.eventBus.BusEvenSearchItemsLoaded;
import com.abed.assignment.data.model.PhotosPage;


import javax.inject.Singleton;


@Singleton
public class TestApiHelper {

    private final EventBusHelper mEventBusHelper;

    public TestApiHelper( EventBusHelper eventBusHelper) {
        mEventBusHelper = eventBusHelper;
    }

    public void searchInFlickr(String searchKey, int page) {
        mEventBusHelper.postEventSafely(new BusEvenSearchItemsLoaded(new PhotosPage(), page));
    }


}
