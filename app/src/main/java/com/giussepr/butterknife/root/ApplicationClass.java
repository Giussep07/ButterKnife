package com.giussepr.butterknife.root;

import android.app.Application;

import com.facebook.stetho.Stetho;
import com.giussepr.butterknife.login.LoginModule;
import com.giussepr.butterknife.register.RegisterModule;

import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;


public class ApplicationClass extends DaggerApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        Stetho.initializeWithDefaults(this);
    }

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return DaggerApplicationComponent.builder().application(this).build();
    }
}
