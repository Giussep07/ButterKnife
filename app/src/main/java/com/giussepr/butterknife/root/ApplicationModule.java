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
}
