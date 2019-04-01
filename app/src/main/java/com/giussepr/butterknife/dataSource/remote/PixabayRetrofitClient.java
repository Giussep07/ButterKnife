package com.giussepr.butterknife.dataSource.remote;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.giussepr.butterknife.root.Constants.PIXABAY_BASE_URL;

public abstract class PixabayRetrofitClient {

    private PixabayAPI pixabayAPI;

    public PixabayRetrofitClient() {
        initRetrofit();
    }

    private void initRetrofit() {
        Retrofit retrofit = retrofitBuilder();
        pixabayAPI = retrofit.create(PixabayAPI.class);
    }

    private Retrofit retrofitBuilder() {
        return new Retrofit.Builder()
                .baseUrl(PIXABAY_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(getOkHttpClient())
                .build();
    }

    private OkHttpClient getOkHttpClient() {
        OkHttpClient.Builder okHttpClient = new OkHttpClient.Builder();
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        return okHttpClient.build();
    }

    public static Retrofit provideRetrofit(String baseURL) {

        OkHttpClient.Builder client = new OkHttpClient.Builder();

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        client.addInterceptor(interceptor);

        return new Retrofit.Builder()
                .baseUrl(baseURL)
                .client(client.build())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    protected PixabayAPI getPixabayAPI() {
        return pixabayAPI;
    }
}
