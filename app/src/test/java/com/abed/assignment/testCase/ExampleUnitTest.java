package com.abed.assignment.testcase;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;

import com.abed.assignment.BuildConfig;
import com.abed.assignment.R;
import com.abed.assignment.testrunner.MockApplicationTestRunner;
import com.abed.assignment.ui.history.HistoryActivity;
import com.abed.assignment.ui.main.MainActivity;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.Shadows;
import org.robolectric.annotation.Config;


@RunWith(MockApplicationTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 22)
public class ExampleUnitTest {

    @Test
    public void clickinfFabShouldStartHistoryActivity() {
        MainActivity activity = Robolectric.setupActivity(MainActivity.class);
        activity.findViewById(R.id.fab).performClick();
        Assertions.assertThat(Shadows.shadowOf(activity).getNextStartedActivity().getComponent().getClassName()).isEqualTo(HistoryActivity.class.getName());
    }

    @Test
    public void checkSearch() {
        MainActivity activity = Robolectric.setupActivity(MainActivity.class);
        RecyclerView imgRec = (RecyclerView) activity.findViewById(R.id.recycler_imgs);
        SearchView searchView = (SearchView) activity.findViewById(R.id.action_search);

        Assertions.assertThat(imgRec.getAdapter().getItemCount()).isEqualTo(0);
        searchView.setQuery("test", true);
        Assertions.assertThat(imgRec.getAdapter().getItemCount()).isEqualTo(6);
    }

}
