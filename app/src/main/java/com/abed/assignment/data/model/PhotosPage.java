
package com.abed.assignment.data.model;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.SerializedName;

public class PhotosPage {

    @SerializedName("page")
    public Integer page;

    @SerializedName("pages")
    public Integer pages;

    @SerializedName("perpage")
    public Integer perpage;

    @SerializedName("total")
    public String total;

    @SerializedName("photo")
    public List<Photo> photos = new ArrayList<Photo>();

    public PhotosPage(Integer page, Integer pages, Integer perpage, String total, List<Photo> photos) {
        this.page = page;
        this.pages = pages;
        this.perpage = perpage;
        this.total = total;
        this.photos = photos;
    }

    public PhotosPage() {
    }
}
