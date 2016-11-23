package com.abed.assignment.ui.main;

import com.abed.assignment.data.model.Photo;
import com.abed.assignment.ui.base.MvpView;

import java.util.List;

public interface MainMvpView extends MvpView {

    void showItems(List<Photo> items);

    void addToItems(List<Photo> items);

}
