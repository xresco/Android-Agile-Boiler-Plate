package com.abed.assignment.injection.module;

import com.abed.assignment.controller.ApiHelper;
import com.abed.assignment.controller.EventBusHelper;
import com.abed.assignment.controller.RxBus;
import com.abed.assignment.data.remote.FlickrService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;


/**
 * Provide general dependencies.
 */
@Module
public class TestBaseModule extends BaseModule{


    @Provides
    @Singleton
    FlickrService provideFlickrService() {
        return FlickrService.Creator.newFlickrService();
    }


    @Provides
    @Singleton
    ApiHelper provideApiHelper() {
        return new ApiHelper(provideFlickrService(), provideEventBusHelper());
    }
}
