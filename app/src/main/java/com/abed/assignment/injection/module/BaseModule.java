package com.abed.assignment.injection.module;

import com.abed.assignment.controller.RxBus;
import com.abed.assignment.data.remote.FlickrService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;


/**
 * Provide general dependencies.
 */
@Module
public class BaseModule {

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
}
