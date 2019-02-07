package com.giussepr.butterknife.login;

import com.giussepr.butterknife.login.model.LoginModel;
import com.giussepr.butterknife.login.model.LoginModelClass;
import com.giussepr.butterknife.login.presenter.LoginPresenter;
import com.giussepr.butterknife.login.presenter.LoginPresenterClass;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class LoginModule {

    @Binds
    abstract LoginPresenter provideLoginPresenter(LoginPresenterClass presenter);

    @Binds
    abstract LoginModel provideLoginModel(LoginModelClass model);
}
