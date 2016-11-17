package com.abed.assignment.ui.history;

import com.abed.assignment.controller.DataManager;
import com.abed.assignment.data.local.eventBus.BusEvenSearchItemsLoaded;
import com.abed.assignment.ui.base.BasePresenter;

import javax.inject.Inject;

import rx.Subscription;

public class HistoryPresenter extends BasePresenter<HistoryMvpView> {
    private String TAG = getClass().getName();

    @Inject
    DataManager dataManager;

    private Subscription searchSubscription;

    @Inject
    public HistoryPresenter() {
    }

    @Override
    public void attachView(HistoryMvpView mvpView) {
        super.attachView(mvpView);
        searchSubscription = dataManager.getEventBusHelper().getBus()
                .register(BusEvenSearchItemsLoaded.class,
                        event -> getMvpView().showItems(dataManager.getDatabaseHelper().getSearchHistory())
                );
    }

    @Override
    public void detachView() {
        super.detachView();
        if (searchSubscription != null && !searchSubscription.isUnsubscribed())
            searchSubscription.unsubscribe();
    }

    public void loadHistory() {
        getMvpView().showItems(dataManager.getDatabaseHelper().getSearchHistory());
    }


}
