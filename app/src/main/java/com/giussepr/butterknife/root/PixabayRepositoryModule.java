package com.giussepr.butterknife.root;

import com.giussepr.butterknife.dataSource.PixabayDataSource;
import com.giussepr.butterknife.dataSource.remote.PixabayClient;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public abstract class PixabayRepositoryModule {

    @Singleton
    @Provides
    static PixabayDataSource providePixabayDataSource() {
        return new PixabayClient();
    }
}
