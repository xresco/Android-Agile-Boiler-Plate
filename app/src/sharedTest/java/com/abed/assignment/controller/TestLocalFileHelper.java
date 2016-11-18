package com.abed.assignment.controller;

/**
 * Created by abed on 11/16/16.
 */

import android.content.Context;


public class TestLocalFileHelper extends LocalFileHelper {


    public String getFileContent(Context context, String fileName) {
        return fileName + ": dummy content";
    }
}