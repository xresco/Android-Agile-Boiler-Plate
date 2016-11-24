package com.abed.assignment.injection.module;

import android.app.Application;

import com.abed.assignment.BuildConfig;
import com.abed.assignment.controller.AnalyticsHelper;
import com.abed.assignment.controller.ApiHelper;
import com.abed.assignment.controller.CrashReportingTree;
import com.abed.assignment.controller.DatabaseHelper;
import com.abed.assignment.controller.EventBusHelper;
import com.abed.assignment.controller.LocalFileHelper;
import com.abed.assignment.controller.SharedPrefHelper;
import com.abed.assignment.data.local.RxBus;
import com.abed.assignment.data.remote.FlickrService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import timber.log.Timber;


/**
 * Provide general dependencies.
 */
@Singleton
@Module
public class BaseModule {

    @Provides
    @Singleton
    RxBus provideEventBus() {
        return new RxBus();
    }

    @Provides
    @Singleton
    FlickrService provideFlickrService(OkHttpClient okHttpClient) {
        return FlickrService.Creator.newFlickrService(okHttpClient);
    }

    @Provides
    @Singleton
    EventBusHelper provideEventBusHelper(RxBus bus) {
        return new EventBusHelper(bus);
    }

    @Provides
    @Singleton
    ApiHelper provideApiHelper(FlickrService flickrService, EventBusHelper eventBusHelper) {
        return new ApiHelper(flickrService, eventBusHelper);
    }

    @Provides
    @Singleton
    LocalFileHelper provideLocalStorageHelper() {
        return new LocalFileHelper();
    }

    @Provides
    @Singleton
    AnalyticsHelper provideAnalyticsHelper() {
        return new AnalyticsHelper();
    }


    @Provides
    @Singleton
    SharedPrefHelper provideSharedPrefHelper(Application application) {
        return new SharedPrefHelper(application);
    }

    @Provides
    @Singleton
    DatabaseHelper provideDbHelper(Application application) {
        return new DatabaseHelper(application);
    }


    @Provides
    @Singleton
    Timber.Tree provideLoggingTree() {
        if (BuildConfig.DEBUG) {
            return new Timber.DebugTree();
        } else {
            return new CrashReportingTree();
        }
    }


}
