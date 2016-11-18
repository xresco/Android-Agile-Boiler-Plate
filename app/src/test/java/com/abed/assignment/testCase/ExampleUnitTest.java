package com.abed.assignment.testCase;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;

import com.abed.assignment.BuildConfig;
import com.abed.assignment.R;
import com.abed.assignment.testRunner.MockApplicationTestRunner;
import com.abed.assignment.ui.Main.MainActivity;
import com.abed.assignment.ui.history.HistoryActivity;

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
    public void clickinfFab_shouldStartHistoryActivity() {
        MainActivity activity = Robolectric.setupActivity(MainActivity.class);
        activity.findViewById(R.id.fab).performClick();
        Assertions.assertThat(Shadows.shadowOf(activity).getNextStartedActivity().getComponent().getClassName()).isEqualTo(HistoryActivity.class.getName());
    }

    @Test
    public void checkSearch() {
        MainActivity activity = Robolectric.setupActivity(MainActivity.class);
        RecyclerView imgRec = (RecyclerView) activity.findViewById(R.id.recylcer_imgs);
        SearchView searchView = (SearchView) activity.findViewById(R.id.action_search);

        Assertions.assertThat(imgRec.getAdapter().getItemCount()).isEqualTo(0);
        searchView.setQuery("test", true);
        Assertions.assertThat(imgRec.getAdapter().getItemCount()).isEqualTo(6);
        imgRec.scrollToPosition(7);
        Assertions.assertThat(imgRec.getAdapter().getItemCount()).isEqualTo(12);
    }

}
