package com.giussepr.butterknife.home.view;

import com.giussepr.butterknife.dataSource.remote.pixabay.Hit;

import java.util.List;

public interface HomeView {
    void showImages(List<Hit> hitList, boolean setAdapter);

    void showNoImages();

    void showServerError(String error);
}
