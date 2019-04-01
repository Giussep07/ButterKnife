package com.giussepr.butterknife.home.model;


import com.giussepr.butterknife.dataSource.remote.pixabay.Pixabay;

import io.reactivex.Observable;

public interface HomeModel {

    Observable<Pixabay> loadImages();
}
