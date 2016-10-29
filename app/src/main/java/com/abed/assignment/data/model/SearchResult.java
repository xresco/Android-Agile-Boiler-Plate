package com.abed.assignment.data.model;

import com.google.gson.annotations.SerializedName;

public class SearchResult {

    @SerializedName("photos")
    public PhotosPage photosPage;

    @SerializedName("stat")
    public String stat;

}
