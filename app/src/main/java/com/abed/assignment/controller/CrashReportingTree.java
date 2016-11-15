package com.abed.assignment.controller;

/**
 * Created by abed on 11/15/16.
 */

import android.util.Log;

import timber.log.Timber;

/** A tree which logs important information for crash reporting. */
public class CrashReportingTree extends Timber.Tree {
    @Override protected void log(int priority, String tag, String message, Throwable t) {
        if (priority == Log.VERBOSE || priority == Log.DEBUG) {
            return;
        }
//
//        FakeCrashLibrary.log(priority, tag, message);
//
//        if (t != null) {
//            if (priority == Log.ERROR) {
//                FakeCrashLibrary.logError(t);
//            } else if (priority == Log.WARN) {
//                FakeCrashLibrary.logWarning(t);
//            }
//        }
    }
}