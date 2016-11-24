package com.abed.assignment.rule;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;

import com.abed.assignment.BaseApplication;

/**
 * Created by Abed on 11/12/16.
 */

public class DaggerActivityTestRule<T extends Activity> extends ActivityTestRule<T> {

    private final OnBeforeActivityLaunchedListener<T> mListener;

    public DaggerActivityTestRule(Class<T> activityClass,
                                  @NonNull OnBeforeActivityLaunchedListener<T> listener) {
        this(activityClass, false, listener);
    }

    public DaggerActivityTestRule(Class<T> activityClass, boolean initialTouchMode,
                                  @NonNull OnBeforeActivityLaunchedListener<T> listener) {
        this(activityClass, initialTouchMode, true, listener);
    }

    public DaggerActivityTestRule(Class<T> activityClass, boolean initialTouchMode,
                                  boolean launchActivity,
                                  @NonNull OnBeforeActivityLaunchedListener<T> listener) {
        super(activityClass, initialTouchMode, launchActivity);
        mListener = listener;
    }

    @Override
    protected void beforeActivityLaunched() {
        super.beforeActivityLaunched();
        mListener.beforeActivityLaunched((BaseApplication) InstrumentationRegistry.getInstrumentation()
                .getTargetContext().getApplicationContext(), getActivity());
    }

    public interface OnBeforeActivityLaunchedListener<T> {

        void beforeActivityLaunched(@NonNull BaseApplication baseApplication, @NonNull T activity);
    }
}