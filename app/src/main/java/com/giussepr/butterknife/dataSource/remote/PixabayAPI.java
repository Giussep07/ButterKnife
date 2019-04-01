package com.giussepr.butterknife.dataSource.remote;

import com.giussepr.butterknife.dataSource.remote.pixabay.Pixabay;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface PixabayAPI {

    @GET("api/")
    Observable<Pixabay> getImages(@Query("key") String key);

    @GET("api/")
    Observable<Pixabay> getImages(@Query("key") String key, @Query("q") String query);
}
