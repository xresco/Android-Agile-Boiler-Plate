package com.abed.assignment.injection.module;

import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;


/**
 * Provide application-level dependencies.
 */
@Module
public class ReleaseModule {

    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient() {
        return new OkHttpClient();
    }

}
