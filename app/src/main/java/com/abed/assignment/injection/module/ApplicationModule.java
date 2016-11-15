package com.abed.assignment.injection.module;

import android.app.Application;
import android.content.Context;

import com.abed.assignment.BuildConfig;
import com.abed.assignment.controller.CrashReportingTree;
import com.abed.assignment.controller.SharedPrefHelper;
import com.abed.assignment.injection.ApplicationContext;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import timber.log.Timber;


/**
 * Provide application-level dependencies.
 */
@Module
public class ApplicationModule {
    protected final Application mApplication;

    public ApplicationModule(Application application) {
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
    SharedPrefHelper provideSharedPrefHelper() {
        return new SharedPrefHelper(mApplication);
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
