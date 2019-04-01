package com.giussepr.butterknife.searchResult.model;

import com.giussepr.butterknife.dataSource.remote.pixabay.Pixabay;

import io.reactivex.Observable;

public interface SearchResultModel {

    Observable<Pixabay> loadImages(String query);
}
