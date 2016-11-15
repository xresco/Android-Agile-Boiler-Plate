package com.abed.assignment;

import android.content.Context;
import android.util.Log;

import com.abed.assignment.injection.component.DaggerApplicationComponent;
import com.abed.assignment.injection.component.TestApplicationComponent;


public class TestApplication extends android.app.Application {

    TestApplicationComponent mApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("Application", "onCreate: test application classs");
    }

    public static TestApplication get(Context context) {
        return (TestApplication) context.getApplicationContext();
    }

//    public TestApplicationComponent getComponent() {
//        DaggerApplicationComponent
////        if (mApplicationComponent == null) {
////            mApplicationComponent = DaggerApplicationComponent.builder()
////                    .applicationModule(new ApplicationModule(this))
////                    .build();
////        }
//        return mApplicationComponent;
//    }

    // Needed to replace the component with a test specific one
    public void setComponent(TestApplicationComponent applicationComponent) {
        mApplicationComponent = applicationComponent;
    }
}
