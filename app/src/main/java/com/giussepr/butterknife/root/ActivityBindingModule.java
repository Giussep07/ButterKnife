package com.giussepr.butterknife.root;

import com.giussepr.butterknife.login.LoginModule;
import com.giussepr.butterknife.login.view.LoginActivity;
import com.giussepr.butterknife.register.RegisterModule;
import com.giussepr.butterknife.register.view.RegisterActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBindingModule {

    @ContributesAndroidInjector(modules = LoginModule.class)
    abstract LoginActivity loginActivity();

    @ContributesAndroidInjector(modules = RegisterModule.class)
    abstract RegisterActivity registerActivity();
}
