package com.abed.assignment.data.eventBus;

import com.abed.assignment.data.model.PhotosPage;



public class BusEvenSearchItemsLoaded {

    private PhotosPage photosPage;
    private int pageNum;

    public BusEvenSearchItemsLoaded(PhotosPage photosPage, int pageNum) {
        this.photosPage = photosPage;
        this.pageNum = pageNum;
    }

    public PhotosPage getPhotosPage() {
        return photosPage;
    }

    public int getPageNum() {
        return pageNum;
    }
}
