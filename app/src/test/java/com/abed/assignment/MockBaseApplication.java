package com.abed.assignment;

import com.abed.assignment.injection.component.DaggerTestApplicationComponent;
import com.abed.assignment.injection.component.TestApplicationComponent;
import com.abed.assignment.injection.module.ApplicationModule;


public class MockBaseApplication extends BaseApplication {
    @Override
    public void onCreate() {
        super.onCreate();
        TestApplicationComponent applicationComponent = DaggerTestApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
        setComponent(applicationComponent);
    }


}
