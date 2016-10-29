package com.abed.assignment.ui.history;

import com.abed.assignment.ui.base.MvpView;

import java.util.List;

public interface HistoryMvpView extends MvpView {

    void showItems(List<String> items);

}
