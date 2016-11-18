package com.abed.assignment;

import com.abed.assignment.Application;
import com.abed.assignment.injection.component.DaggerTestApplicationComponent;
import com.abed.assignment.injection.component.TestApplicationComponent;
import com.abed.assignment.injection.module.TestApplicationModule;

public class MockApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        TestApplicationComponent mApplicationComponent = DaggerTestApplicationComponent.builder()
                .testApplicationModule(new TestApplicationModule(this))
                .build();
        setComponent(mApplicationComponent);
    }


}
