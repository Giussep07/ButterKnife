package com.giussepr.butterknife.register;

import com.giussepr.butterknife.register.model.RegisterModel;
import com.giussepr.butterknife.register.model.RegisterModelClass;
import com.giussepr.butterknife.register.presenter.RegisterPresenter;
import com.giussepr.butterknife.register.presenter.RegisterPresenterClass;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class RegisterModule {

    @Binds
    abstract RegisterPresenter provideRegisterPresenter(RegisterPresenterClass presenter);

    @Binds
    abstract RegisterModel provideRegisterModel(RegisterModelClass model);

}
