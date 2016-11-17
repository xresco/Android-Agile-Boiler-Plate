package com.abed.assignment.testing.injection.module;

import android.app.Application;
import android.content.Context;

import com.abed.assignment.controller.DatabaseHelper;
import com.abed.assignment.controller.SharedPrefHelper;

import com.abed.assignment.injection.ApplicationContext;
import com.abed.assignment.testing.controller.TestCrashReportingTree;
import com.abed.assignment.testing.controller.TestDatabaseHelper;
import com.abed.assignment.testing.controller.TestSharedPrefHelper;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import timber.log.Timber;


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


    @Provides
    @Singleton
    DatabaseHelper provideDbHelper() {
        return new TestDatabaseHelper(mApplication);
    }

    @Provides
    @Singleton
    Timber.Tree provideLoggingTree() {
        return new TestCrashReportingTree();
    }

}
