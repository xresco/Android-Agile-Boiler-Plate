package com.abed.assignment.controller;

import com.abed.assignment.BuildConfig;
import com.abed.assignment.data.local.eventbus.BusEvenSearchItemsLoaded;
import com.abed.assignment.data.model.SearchResult;
import com.abed.assignment.data.remote.FlickrService;

import rx.Subscriber;
import rx.schedulers.Schedulers;
import timber.log.Timber;


public class ApiHelper {

    protected final FlickrService mFlickrService;
    protected final EventBusHelper mEventBusHelper;

    public ApiHelper(FlickrService flickrService, EventBusHelper eventBusHelper) {
        mEventBusHelper = eventBusHelper;
        mFlickrService = flickrService;
    }

    public void searchInFlickr(String searchKey, int page) {
        mFlickrService.search("flickr.photos.search", BuildConfig.FLICKR_API_KEY, "json", 1, BuildConfig.FLICKR_PAGE_LOADING_SIZE, page, searchKey)
                .observeOn(Schedulers.io())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<SearchResult>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                        Timber.e(e);
                        //According to the API documentation and error code returned a retry might be needed.
                    }

                    @Override
                    public void onNext(SearchResult result) {
                        if (result.stat.toLowerCase().equals("ok"))
                        mEventBusHelper.postEventSafely(new BusEvenSearchItemsLoaded(result.photosPage, page));
                    }
                });
    }


}
