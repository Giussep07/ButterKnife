package com.giussepr.butterknife.searchResult.view;

import com.giussepr.butterknife.dataSource.remote.pixabay.Hit;

import java.util.List;

public interface SearchResultView {
    void showImages(List<Hit> hitList);

    void showNoImages();

    void showServerError(String error);
}
