package com.giussepr.butterknife.dataSource;


import com.giussepr.butterknife.dataSource.remote.pixabay.Pixabay;

import io.reactivex.Observable;

public interface PixabayDataSource {

    Observable<Pixabay> getImages();

    Observable<Pixabay> getImages(String query);
}
