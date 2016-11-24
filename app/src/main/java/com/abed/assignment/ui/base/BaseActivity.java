package com.abed.assignment.ui.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.abed.assignment.BaseApplication;
import com.abed.assignment.injection.component.ActivityComponent;
import com.abed.assignment.injection.component.DaggerActivityComponent;
import com.abed.assignment.injection.module.ActivityModule;

public class BaseActivity extends AppCompatActivity {

    private ActivityComponent mActivityComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public ActivityComponent getActivityComponent() {
        if (mActivityComponent == null) {
            mActivityComponent = DaggerActivityComponent.builder()
                    .activityModule(new ActivityModule(this))
                    .applicationComponent(BaseApplication.get(this).getComponent())
                    .build();
        }
        return mActivityComponent;
    }
}
