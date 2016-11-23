package com.abed.assignment.data.local.eventbus;

import com.abed.assignment.data.model.PhotosPage;



public class BusEvenSearchItemsLoaded {

    private PhotosPage mPhotosPage;
    private int mPageNum;

    public BusEvenSearchItemsLoaded(PhotosPage photosPage, int pageNum) {
        this.mPhotosPage = photosPage;
        this.mPageNum = pageNum;
    }

    public PhotosPage getmPhotosPage() {
        return mPhotosPage;
    }

    public int getmPageNum() {
        return mPageNum;
    }
}
