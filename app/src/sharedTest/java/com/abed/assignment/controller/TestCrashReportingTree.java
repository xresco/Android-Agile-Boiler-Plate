package com.abed.assignment.controller;

/**
 * Created by abed on 11/15/16.
 */

import timber.log.Timber;

/**
 * A tree which logs important information for crash reporting.
 */
public class TestCrashReportingTree extends Timber.Tree {
    @Override
    protected void log(int priority, String tag, String message, Throwable t) {

    }
}