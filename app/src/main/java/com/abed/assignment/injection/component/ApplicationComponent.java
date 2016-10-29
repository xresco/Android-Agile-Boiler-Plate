package com.abed.assignment.injection.component;

import android.app.Application;
import android.content.Context;

import com.abed.assignment.controller.DataManager;
import com.abed.assignment.controller.LocalStorageHelper;
import com.abed.assignment.controller.RxBus;
import com.abed.assignment.data.remote.FlickrService;
import com.abed.assignment.injection.ApplicationContext;
import com.abed.assignment.injection.module.ApplicationModule;
import com.abed.assignment.injection.module.BaseModule;


import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ApplicationModule.class, BaseModule.class})
public interface ApplicationComponent {


    @ApplicationContext
    Context context();

    Application application();

    DataManager dataManager();

    FlickrService flickrService();

    LocalStorageHelper preferencesHelper();

    RxBus eventBus();

}
