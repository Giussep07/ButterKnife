package com.giussepr.butterknife.dataSource.remote;


import com.giussepr.butterknife.dataSource.PixabayDataSource;
import com.giussepr.butterknife.dataSource.remote.pixabay.Pixabay;

import javax.inject.Singleton;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

@Singleton
public class PixabayClient extends PixabayRetrofitClient implements PixabayDataSource {

    private String KEY = "4792335-cd8af72a09ac90bceb8bb8c63";

    @Override
    public Observable<Pixabay> getImages() {
        return getPixabayAPI().getImages(KEY)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Observable<Pixabay> getImages(String query) {
        return getPixabayAPI().getImages(KEY, query)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
