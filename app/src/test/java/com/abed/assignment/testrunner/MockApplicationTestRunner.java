package com.abed.assignment.testrunner;

import android.app.Application;

import com.abed.assignment.MockBaseApplication;

import org.junit.runners.model.InitializationError;
import org.robolectric.DefaultTestLifecycle;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.TestLifecycle;
import org.robolectric.annotation.Config;
import org.robolectric.manifest.AndroidManifest;

import java.lang.reflect.Method;

/**
 * Created by abed on 11/17/16.
 */

public class MockApplicationTestRunner extends RobolectricTestRunner {

    public MockApplicationTestRunner(final Class<?> testClass) throws InitializationError {
        super(testClass);
    }


    @Override
    protected Class<? extends TestLifecycle> getTestLifecycleClass() {
        return MyTestLifecycle.class;
    }

    public static class MyTestLifecycle extends DefaultTestLifecycle {
        @Override
        public Application createApplication(Method method, AndroidManifest appManifest, Config config) {
            return new MockBaseApplication();
        }
    }


}