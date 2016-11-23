package com.abed.assignment.controller;

/**
 * Created by abed on 11/16/16.
 */


import android.content.Context;

import com.abed.assignment.BuildConfig;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;

import timber.log.Timber;


/**
 * Created by Abed on 29/04/2016.
 */
public class AnalyticsHelper {

    private Tracker mAppTracker;

    public AnalyticsHelper() {
    }

    private synchronized Tracker getTracker(Context context) {
        Timber.d("getTracker() called with: " + "context = [" + context + "]");
        GoogleAnalytics analytics = GoogleAnalytics.getInstance(context);
        analytics.setLocalDispatchPeriod(1);
        analytics.setDryRun(false);
        Tracker newTracker = analytics.newTracker(BuildConfig.GOOGLE_ANALYTICS_TRACKING_ID);

        newTracker.setSampleRate(100);
        newTracker.enableExceptionReporting(true);
        newTracker.setSessionTimeout(3000);
        newTracker.enableAdvertisingIdCollection(true);

        return newTracker;
    }

    public void trackScreen(Context context, String screenName) {
        Timber.d("trackScreen() called with: " + "context = [" + context + "], screenName = [" + screenName + "]");
        if (mAppTracker == null) {
            mAppTracker = getTracker(context);
        }

        mAppTracker.enableAdvertisingIdCollection(true);
        mAppTracker.setScreenName(screenName);
        mAppTracker.send(new HitBuilders.ScreenViewBuilder().build());
    }


    public void trackEvent(Context context, String category, String action, String label) {
        Timber.d("trackEvent() called with: " + "context = [" + context + "], category = [" + category + "], action = [" + action + "], label = [" + label + "]");
        if (mAppTracker == null) {
            mAppTracker = getTracker(context);
        }

        mAppTracker.send(new HitBuilders.EventBuilder()
                .setCategory((category))
                .setAction((action))
                .setLabel((label))
                .build());
    }

    public void trackEventWithValue(Context context, String category, String action, String label, long value) {
        Timber.d("trackEventWithValue() called with: " + "context = [" + context + "], category = [" + category + "], action = [" + action + "], label = [" + label + "], value = [" + value + "]");
        if (mAppTracker == null) {
            mAppTracker = getTracker(context);
        }

        mAppTracker.send(new HitBuilders.EventBuilder()
                .setCategory(category)
                .setAction(action)
                .setLabel(label)
                .setValue(value)
                .build());
    }

    public void trackUser(String userEmail) {
        Timber.d("trackUser() called with: " + "userEmail = [" + userEmail + "]");

    }

}