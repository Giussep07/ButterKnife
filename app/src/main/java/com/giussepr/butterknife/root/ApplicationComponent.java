package com.giussepr.butterknife.root;

import com.giussepr.butterknife.dataBase.LocalDataSource;
import com.giussepr.butterknife.login.LoginModule;
import com.giussepr.butterknife.login.view.LoginActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ApplicationModule.class, LoginModule.class})
public interface ApplicationComponent {

    void inject(LoginActivity loginActivity);

    LocalDataSource roomDataSource();
}
