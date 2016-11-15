package com.abed.assignment.injection.module;

import com.abed.assignment.controller.ApiHelper;
import com.abed.assignment.controller.EventBusHelper;
import com.abed.assignment.controller.TestApiHelper;
import com.abed.assignment.data.local.RxBus;
import com.abed.assignment.data.remote.FlickrService;

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

}
