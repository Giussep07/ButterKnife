package com.giussepr.butterknife.home.model;


import com.giussepr.butterknife.dataSource.PixabayDataSource;
import com.giussepr.butterknife.dataSource.remote.pixabay.Pixabay;

import javax.inject.Inject;

import androidx.annotation.Nullable;
import io.reactivex.Observable;

public class HomeModelClass implements HomeModel {

    @Nullable
    PixabayDataSource pixabayDataSource;

    @Inject
    public HomeModelClass(PixabayDataSource pixabayDataSource) {
        this.pixabayDataSource = pixabayDataSource;
    }

    @Override
    public Observable<Pixabay> loadImages() {
        return pixabayDataSource.getImages();
    }
}
