package com.abed.assignment.testing.injection.module;

import com.abed.assignment.controller.AnalyticsHelper;
import com.abed.assignment.controller.ApiHelper;
import com.abed.assignment.controller.EventBusHelper;
import com.abed.assignment.controller.LocalFileHelper;

import com.abed.assignment.data.local.RxBus;
import com.abed.assignment.data.remote.FlickrService;
import com.abed.assignment.testing.controller.TestAnalyticsHelper;
import com.abed.assignment.testing.controller.TestApiHelper;
import com.abed.assignment.testing.controller.TestLocalFileHelper;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;


/**
 * Provide general dependencies.
 */
@Module
public class TestBaseModule {

    @Provides
    @Singleton
    RxBus provideEventBus() {
        return new RxBus();
    }


    @Provides
    @Singleton
    FlickrService provideFlickrService() {
        return FlickrService.Creator.newFlickrService();
    }

    @Provides
    @Singleton
    EventBusHelper provideEventBusHelper(RxBus bus) {
        return new EventBusHelper(bus);
    }

    @Provides
    @Singleton
    ApiHelper provideApiHelper(FlickrService flickrService, EventBusHelper eventBusHelper) {
        return new TestApiHelper(flickrService, eventBusHelper);
    }

    @Provides
    @Singleton
    LocalFileHelper provideLocalFileHelper() {
        return new TestLocalFileHelper();
    }

    @Provides
    @Singleton
    AnalyticsHelper provideAnalyticsHelper() {
        return new TestAnalyticsHelper();
    }

}
