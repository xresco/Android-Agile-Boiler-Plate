package com.abed.assignment;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.Espresso;
import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.filters.MediumTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;


import com.abed.assignment.injection.component.DaggerTestApplicationComponent;
import com.abed.assignment.injection.component.TestApplicationComponent;
import com.abed.assignment.injection.module.ApplicationModule;
import com.abed.assignment.injection.module.TestApplicationModule;
import com.abed.assignment.ui.Main.MainActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;


import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@MediumTest
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentationTest {
    TestApplicationComponent mApplicationComponent;
//    @Test
//    public void useAppContext() throws Exception {
//        // Context of the app under test.
//        Context appContext = InstrumentationRegistry.getTargetContext();
//        assertEquals("com.abed.assignment", appContext.getPackageName());
//
//    }
//
//    @Test
//    public void testHistoryFunctionality() throws Exception {
//        // Context of the app under test.
//        Context appContext = InstrumentationRegistry.getTargetContext();
//        LocalStorageHelper localStorageHelper = new LocalStorageHelper(appContext);
//        localStorageHelper.clear();
//        for (String item : getHistoryItems())
//            localStorageHelper.addSearchKeyToHistory(item);
//        assertEquals(localStorageHelper.getSearchHistory().size(), getHistoryItems().size());
//    }
//
//    private List<String> getHistoryItems() {
//        List<String> items = new LinkedList<>();
//        items.add("a");
//        items.add("b");
//        items.add("c");
//        items.add("d");
//        items.add("e");
//        items.add("f");
//        items.add("g");
//        return items;
//    }

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule =
            new DaggerActivityTestRule<>(MainActivity.class, new DaggerActivityTestRule.OnBeforeActivityLaunchedListener<MainActivity>() {
                @Override
                public void beforeActivityLaunched(@NonNull Application application, @NonNull MainActivity activity) {
//                    DaggerTestApplicationComponen
//                    TestApplicationComponent mApplicationComponent = DaggerTestApplicationComponent.builder()
//                            .build();
//                    mTestAppComponent = Dagg.create();
//                    ((App) application).setTestComponent(mTestAppComponent);
                }
            });
//    @Rule
//    public ActivityTestRule mActivityRule = new ActivityTestRule<>(
//            MainActivity.class);

    @Test
    public void sayHello() {
        Espresso.onView(ViewMatchers.withId(R.id.fab)).perform(ViewActions.click());

//        Espresso.onView(ViewMatchers.withId(R.id.action_search)).check(ViewAssertions.matches(ViewMatchers.withText("Hello, World!")));
    }
}