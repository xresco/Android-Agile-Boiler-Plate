package com.abed.assignment.injection.module;

import android.app.Application;
import android.content.Context;

import com.abed.assignment.controller.SharedPrefHelper;
import com.abed.assignment.controller.TestSharedPrefHelper;
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
    SharedPrefHelper provideLocalStorageHelper() {
        return new TestSharedPrefHelper(mApplication);
    }

}
