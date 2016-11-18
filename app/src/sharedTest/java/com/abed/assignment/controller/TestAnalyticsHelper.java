package com.abed.assignment.controller;

/**
 * Created by abed on 11/16/16.
 */


import android.content.Context;

import timber.log.Timber;


/**
 * Created by Abed on 29/04/2016.
 */
public class TestAnalyticsHelper extends AnalyticsHelper {

    public TestAnalyticsHelper() {
        super();
    }


    public void trackScreen(Context context, String screenName) {
        Timber.d("trackScreen() called with: " + "context = [" + context + "], screenName = [" + screenName + "]");
    }


    public void trackEvent(Context context, String category, String action, String label) {
        Timber.d("trackEvent() called with: " + "context = [" + context + "], category = [" + category + "], action = [" + action + "], label = [" + label + "]");
    }

    public void trackEventWithValue(Context context, String category, String action, String label, long value) {
        Timber.d("trackEventWithValue() called with: " + "context = [" + context + "], category = [" + category + "], action = [" + action + "], label = [" + label + "], value = [" + value + "]");

    }

    public void trackUser(String userEmail) {
        Timber.d("trackUser() called with: " + "userEmail = [" + userEmail + "]");
    }

}