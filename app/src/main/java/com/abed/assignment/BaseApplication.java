package com.abed.assignment;

import android.app.Application;
import android.content.Context;

import com.abed.assignment.injection.component.ApplicationComponent;
import com.abed.assignment.injection.component.DaggerApplicationComponent;
import com.abed.assignment.injection.module.ApplicationModule;

import timber.log.Timber;


public class BaseApplication extends Application {

    private ApplicationComponent mApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        //Init Timber
        Timber.plant(getComponent().loggingTree());
    }

    public static BaseApplication get(Context context) {
        return (BaseApplication) context.getApplicationContext();
    }

    public ApplicationComponent getComponent() {
        if (mApplicationComponent == null) {
            mApplicationComponent = DaggerApplicationComponent.builder()
                    .applicationModule(new ApplicationModule(this))
                    .build();
        }
        return mApplicationComponent;
    }


    // Needed to replace the component with a test specific one
    public void setComponent(ApplicationComponent applicationComponent) {
        this.mApplicationComponent = applicationComponent;
        Timber.plant(getComponent().loggingTree());
    }
}
