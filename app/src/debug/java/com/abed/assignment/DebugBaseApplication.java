package com.abed.assignment;

import com.abed.assignment.injection.component.DaggerDebugApplicationComponent;
import com.abed.assignment.injection.component.DebugApplicationComponent;
import com.abed.assignment.injection.module.ApplicationModule;
import com.facebook.stetho.Stetho;

public class DebugBaseApplication extends BaseApplication {
    @Override
    public void onCreate() {
        super.onCreate();
        Stetho.initializeWithDefaults(this);
        DebugApplicationComponent applicationComponent = DaggerDebugApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
        setComponent(applicationComponent);
    }
}
