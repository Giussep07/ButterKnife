package com.giussepr.butterknife.root;

import com.giussepr.butterknife.home.HomeModule;
import com.giussepr.butterknife.home.view.HomeActivity;
import com.giussepr.butterknife.login.LoginModule;
import com.giussepr.butterknife.login.view.LoginActivity;
import com.giussepr.butterknife.register.RegisterModule;
import com.giussepr.butterknife.register.view.RegisterActivity;
import com.giussepr.butterknife.searchResult.SearchResultModule;
import com.giussepr.butterknife.searchResult.presenter.SearchResultPresenterClass;
import com.giussepr.butterknife.searchResult.view.SearchResultActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBindingModule {

    @ContributesAndroidInjector(modules = LoginModule.class)
    abstract LoginActivity loginActivity();

    @ContributesAndroidInjector(modules = RegisterModule.class)
    abstract RegisterActivity registerActivity();

    @ContributesAndroidInjector(modules = HomeModule.class)
    abstract HomeActivity homeActivity();

    @ContributesAndroidInjector(modules = SearchResultModule.class)
    abstract SearchResultActivity searchResultActivity();
}
