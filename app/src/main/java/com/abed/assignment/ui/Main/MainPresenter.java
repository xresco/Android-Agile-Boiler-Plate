package com.abed.assignment.ui.main;

import com.abed.assignment.controller.DataManager;
import com.abed.assignment.data.local.eventbus.BusEvenSearchItemsLoaded;
import com.abed.assignment.ui.base.BasePresenter;

import javax.inject.Inject;

import rx.Subscription;

public class MainPresenter extends BasePresenter<MainMvpView> {

    @Inject
    DataManager mDataManager;

    private Subscription mSearchSubscription;
    private String mSearchKey;
    private int mPage;

    @Inject
    public MainPresenter() {
    }

    @Override
    public void attachView(MainMvpView mvpView) {
        super.attachView(mvpView);
        mSearchSubscription = mDataManager.getEventBusHelper().getBus()
                .register(BusEvenSearchItemsLoaded.class,
                        event -> {
                            if (event.getmPageNum() == 1)
                                getMvpView().showItems(event.getmPhotosPage().photos);
                            else
                                getMvpView().addToItems(event.getmPhotosPage().photos);
                        }

                );
    }

    @Override
    public void detachView() {
        super.detachView();
        if (mSearchSubscription != null && !mSearchSubscription.isUnsubscribed())
            mSearchSubscription.unsubscribe();
    }

    public void search(String searchKey) {
        this.mSearchKey = searchKey;
        this.mPage = 1;
        mDataManager.getApiHelper().searchInFlickr(searchKey, 1);
        mDataManager.getDatabaseHelper().addSearchKeyToHistory(searchKey);
    }

    public void loadNextPage() {
        mDataManager.getApiHelper().searchInFlickr(mSearchKey, mPage++);
    }
}
