package com.abed.assignment;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.filters.MediumTest;
import android.support.test.runner.AndroidJUnit4;

import com.abed.assignment.controller.LocalStorageHelper;

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
    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();
        assertEquals("com.abed.assignment", appContext.getPackageName());
    }

    @Test
    public void testHistoryFunctionality() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();
        LocalStorageHelper localStorageHelper = new LocalStorageHelper(appContext);
        localStorageHelper.clear();
        for (String item : getHistoryItems())
            localStorageHelper.addSearchKeyToHistory(item);
        assertEquals(localStorageHelper.getSearchHistory().size(), getHistoryItems().size());
    }

    private List<String> getHistoryItems() {
        List<String> items = new LinkedList<>();
        items.add("a");
        items.add("b");
        items.add("c");
        items.add("d");
        items.add("e");
        items.add("f");
        items.add("g");
        return items;
    }
}