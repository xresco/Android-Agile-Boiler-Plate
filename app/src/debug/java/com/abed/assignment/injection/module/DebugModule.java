package com.abed.assignment.injection.module;

import com.facebook.stetho.okhttp3.StethoInterceptor;

import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;


/**
 * Provide application-level dependencies.
 */
@Module
public class DebugModule {

    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient() {
        return new OkHttpClient.Builder()
                .addNetworkInterceptor(new StethoInterceptor())
                .build();
    }

}
