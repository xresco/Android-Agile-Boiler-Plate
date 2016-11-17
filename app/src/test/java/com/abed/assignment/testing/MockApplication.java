package com.abed.assignment.testing;

import android.content.Context;

import com.abed.assignment.testing.injection.component.DaggerTestApplicationComponent;
import com.abed.assignment.testing.injection.component.TestApplicationComponent;

import timber.log.Timber;


public class MockApplication extends android.app.Application {

    TestApplicationComponent mApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        //Init Timber
        Timber.plant(getComponent().loggingTree());
    }

    public static MockApplication get(Context context) {
        return (MockApplication) context.getApplicationContext();
    }

    public TestApplicationComponent getComponent() {
        if (mApplicationComponent == null) {
            mApplicationComponent = DaggerTestApplicationComponent.builder()
                    .build();
        }
        return mApplicationComponent;
    }

    // Needed to replace the component with a test specific one
    public void setComponent(TestApplicationComponent applicationComponent) {
        mApplicationComponent = applicationComponent;
        Timber.plant(getComponent().loggingTree());
    }
}
