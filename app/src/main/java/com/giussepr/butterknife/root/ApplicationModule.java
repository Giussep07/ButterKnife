package com.giussepr.butterknife.root;

import android.app.Application;
import android.arch.persistence.room.Room;
import android.content.Context;

import com.giussepr.butterknife.dataBase.LocalDataSource;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {
    private Application application;

    public ApplicationModule(Application application) {
        this.application = application;
    }

    @Provides
    @Singleton
    public Context provideContext() {
        return application;
    }

    @Singleton
    @Provides
    public LocalDataSource provideRoomDataSource() {
        return Room.databaseBuilder(application, LocalDataSource.class, "butterKnife").build();
    }
}
