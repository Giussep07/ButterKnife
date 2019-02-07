package com.giussepr.butterknife.root;

import android.app.Application;
import android.content.Context;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class ApplicationModule {
//    private Application application;

    @Binds
    abstract Context bindContext(Application application);

//    public ApplicationModule(Application application) {
//        this.application = application;
//    }
//
//    @Provides
//    @Singleton
//    public Context provideContext() {
//        return application;
//    }
//
//    @Singleton
//    @Provides
//    public LocalDataSource provideRoomDataSource() {
//        return Room.databaseBuilder(application, LocalDataSource.class, "butterKnife").build();
//    }
}
