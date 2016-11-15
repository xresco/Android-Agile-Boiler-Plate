package com.abed.assignment.controller;

import com.abed.assignment.data.local.eventBus.BusEvenSearchItemsLoaded;
import com.abed.assignment.data.model.Photo;
import com.abed.assignment.data.model.PhotosPage;
import com.abed.assignment.data.remote.FlickrService;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Singleton;


@Singleton
public class TestApiHelper extends ApiHelper {


    public TestApiHelper(FlickrService flickrService, EventBusHelper eventBusHelper) {
        super(flickrService, eventBusHelper);
    }

    public void searchInFlickr(String searchKey, int page) {
        mEventBusHelper.postEventSafely(new BusEvenSearchItemsLoaded(getPhotosPage(page), page));
    }

    private PhotosPage getPhotosPage(int page) {
        List<Photo> photos = getPhotos();
        int numPages = 10;
        return new PhotosPage(page, numPages, photos.size(), "total", photos);
    }

    private List<Photo> getPhotos() {
        List<Photo> photos = new ArrayList<>();
        photos.add(new Photo("31001422465", "owner", "49e0e8ee61", "5575", 6, " title", 1, 0, 0));
        photos.add(new Photo("30913313731", "owner", "53e156cee5", "5445", 6, " title", 1, 0, 0));
        photos.add(new Photo("30913312881", "owner", "c03aa0f520", "5684", 6, " title", 1, 0, 0));
        photos.add(new Photo("30884893292", "owner", "734ac5f8f3", "5500", 6, " title", 1, 0, 0));
        photos.add(new Photo("30966295296", "owner", "ef4d5f25e5", "5556", 6, " title", 1, 0, 0));
        photos.add(new Photo("22822993598", "owner", "49d5000343", "5545", 6, " title", 1, 0, 0));
        return photos;
    }


}
