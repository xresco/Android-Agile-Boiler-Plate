package com.abed.assignment.controller;

/**
 * Created by abed on 11/16/16.
 */

import android.content.Context;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import timber.log.Timber;


public class LocalFileHelper {


    public LocalFileHelper() {
    }


    /**
     * @param context
     * @param fileName
     * @param fileEncoding The encoding of the file being read example:UTF8
     * @return the content of the file
     */
    public String getFileContent(Context context, String fileName, String fileEncoding) {
        // Reading json file from assets folder
        StringBuffer sb = new StringBuffer();
        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(context.getAssets().open(fileName), fileEncoding));
            String temp;
            while ((temp = br.readLine()) != null)
                sb.append(temp);
        } catch (IOException e) {
            Timber.e(e);
        } finally {
            try {
                br.close(); // stop reading
            } catch (IOException e) {
                Timber.e(e);
            }
        }
        return sb.toString();
    }
}