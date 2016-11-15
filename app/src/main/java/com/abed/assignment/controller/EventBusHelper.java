package com.abed.assignment.controller;

import android.os.Handler;
import android.os.Looper;

import com.abed.assignment.data.local.RxBus;

import javax.inject.Inject;

/**
 * Provides helper methods to post event to an the event bus
 */
public class EventBusHelper {

    private final RxBus mBus;

    @Inject
    public EventBusHelper(RxBus bus) {
        mBus = bus;
    }

    public RxBus getBus() {
        return mBus;
    }

    /**
     * Helper method to post an event from a different thread to the main one.
     */
    public void postEventSafely(final Object event) {
        new Handler(Looper.getMainLooper()).post(() -> mBus.post(event));
    }
}
