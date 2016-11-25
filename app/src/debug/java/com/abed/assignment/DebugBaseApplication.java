package com.abed.assignment;

import com.abed.assignment.injection.component.DaggerDebugApplicationComponent;
import com.abed.assignment.injection.component.DebugApplicationComponent;
import com.abed.assignment.injection.module.ApplicationModule;
import com.facebook.stetho.Stetho;
import com.squareup.leakcanary.LeakCanary;

public class DebugBaseApplication extends BaseApplication {
    @Override
    public void onCreate() {
        super.onCreate();

        //Install Leak Canary
        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        LeakCanary.install(this);

        //Install Stetho
        Stetho.initializeWithDefaults(this);

        
        DebugApplicationComponent applicationComponent = DaggerDebugApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
        setComponent(applicationComponent);
    }
}
