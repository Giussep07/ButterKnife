package com.giussepr.butterknife.searchResult.model;

import com.giussepr.butterknife.dataSource.PixabayDataSource;
import com.giussepr.butterknife.dataSource.remote.pixabay.Pixabay;

import javax.inject.Inject;

import androidx.annotation.Nullable;
import io.reactivex.Observable;

public class SearchResultModelClass implements SearchResultModel {

    @Nullable
    PixabayDataSource pixabayDataSource;

    @Inject
    public SearchResultModelClass(@Nullable PixabayDataSource pixabayDataSource) {
        this.pixabayDataSource = pixabayDataSource;
    }

    @Override
    public Observable<Pixabay> loadImages(String query) {
        return pixabayDataSource.getImages(query);
    }
}
