package com.abed.assignment.ui.history;

import com.abed.assignment.controller.DataManager;
import com.abed.assignment.data.local.eventbus.BusEvenSearchItemsLoaded;
import com.abed.assignment.ui.base.BasePresenter;

import javax.inject.Inject;

import rx.Subscription;

public class HistoryPresenter extends BasePresenter<HistoryMvpView> {

    @Inject
    DataManager mDataManager;

    private Subscription mSearchSubscription;

    @Inject
    public HistoryPresenter() {
    }

    @Override
    public void attachView(HistoryMvpView mvpView) {
        super.attachView(mvpView);
        mSearchSubscription = mDataManager.getEventBusHelper().getBus()
                .register(BusEvenSearchItemsLoaded.class,
                        event -> getMvpView().showItems(mDataManager.getDatabaseHelper().getSearchHistory())
                );
    }

    @Override
    public void detachView() {
        super.detachView();
        if (mSearchSubscription != null && !mSearchSubscription.isUnsubscribed())
            mSearchSubscription.unsubscribe();
    }

    public void loadHistory() {
        getMvpView().showItems(mDataManager.getDatabaseHelper().getSearchHistory());
    }


}
