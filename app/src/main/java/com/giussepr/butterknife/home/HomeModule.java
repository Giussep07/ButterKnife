package com.giussepr.butterknife.home;

import com.giussepr.butterknife.home.model.HomeModel;
import com.giussepr.butterknife.home.model.HomeModelClass;
import com.giussepr.butterknife.home.presenter.HomePresenter;
import com.giussepr.butterknife.home.presenter.HomePresenterClass;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class HomeModule {

    @Binds
    abstract HomePresenter provideHomePresenter(HomePresenterClass homePresenterClass);

    @Binds
    abstract HomeModel provideHomeModel(HomeModelClass homeModelClass);
}
