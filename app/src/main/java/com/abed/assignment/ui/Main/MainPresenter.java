package com.abed.assignment.ui.Main;

import android.util.Log;

import com.abed.assignment.controller.DataManager;
import com.abed.assignment.data.local.eventBus.BusEvenSearchItemsLoaded;
import com.abed.assignment.ui.base.BasePresenter;

import javax.inject.Inject;

import rx.Subscription;

public class MainPresenter extends BasePresenter<MainMvpView> {
    private String TAG = getClass().getName();

    @Inject
    DataManager dataManager;

    private Subscription searchSubscription;
    private String searchKey;
    private int page;

    @Inject
    public MainPresenter() {
    }

    @Override
    public void attachView(MainMvpView mvpView) {
        super.attachView(mvpView);
        searchSubscription = dataManager.getEventBusHelper().getBus()
                .register(BusEvenSearchItemsLoaded.class,
                        event -> {
                            if (event.getPageNum() == 1)
                                getMvpView().showItems(event.getPhotosPage().photos);
                            else
                                getMvpView().addToItems(event.getPhotosPage().photos);
                        }

                );
    }

    @Override
    public void detachView() {
        super.detachView();
        if (searchSubscription != null && !searchSubscription.isUnsubscribed())
            searchSubscription.unsubscribe();
    }

    public void search(String searchKey) {
        this.searchKey = searchKey;
        this.page = 1;
        dataManager.getApiHelper().searchInFlickr(searchKey, 1);
        dataManager.getLocalStorageHelper().addSearchKeyToHistory(searchKey);
    }

    public void loadNextPage() {
        dataManager.getApiHelper().searchInFlickr(searchKey, page++);
    }


}
