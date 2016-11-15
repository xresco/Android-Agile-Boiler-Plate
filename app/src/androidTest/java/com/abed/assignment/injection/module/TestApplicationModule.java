package com.abed.assignment.injection.module;

import android.app.Application;
import android.content.Context;

import com.abed.assignment.controller.LocalStorageHelper;
import com.abed.assignment.controller.TestLocalStorageHelper;
import com.abed.assignment.injection.ApplicationContext;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;


/**
 * Provide application-level dependencies.
 */
@Module
public class TestApplicationModule {

    protected final Application mApplication;

    public TestApplicationModule(Application application) {
        mApplication = application;
    }

    @Provides
    Application provideApplication() {
        return mApplication;
    }

    @Provides
    @ApplicationContext
    Context provideContext() {
        return mApplication;
    }

    @Provides
    @Singleton
    LocalStorageHelper provideLocalStorageHelper() {
        return new TestLocalStorageHelper(mApplication);
    }

}
