package com.abed.assignment.testing.testCase;

import android.content.Intent;

import com.abed.assignment.Application;
import com.abed.assignment.BuildConfig;
import com.abed.assignment.R;
import com.abed.assignment.testing.injection.component.DaggerTestApplicationComponent;
import com.abed.assignment.testing.injection.component.TestApplicationComponent;
import com.abed.assignment.testing.injection.module.TestApplicationModule;
import com.abed.assignment.ui.Main.MainActivity;
import com.abed.assignment.ui.history.HistoryActivity;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.Shadows;
import org.robolectric.annotation.Config;


@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 22)
public class ExampleUnitTest {

    @Test
    public void clickingLogin_shouldStartLoginActivity() {


        MainActivity activity = Robolectric.setupActivity(MainActivity.class);
        TestApplicationComponent mApplicationComponent = DaggerTestApplicationComponent.builder()
                .testApplicationModule(new TestApplicationModule(activity.getApplication()))
                .build();
        ((Application) activity.getApplication()).setComponent(mApplicationComponent);
        activity.findViewById(R.id.fab).performClick();

        Intent expectedIntent = new Intent(activity, HistoryActivity.class);
        Assertions.assertThat(Shadows.shadowOf(activity).getNextStartedActivity()).isEqualTo(expectedIntent);
    }

}
