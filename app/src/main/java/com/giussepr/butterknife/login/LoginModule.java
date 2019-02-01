package com.giussepr.butterknife.login;

import com.giussepr.butterknife.dataBase.LocalDataSource;
import com.giussepr.butterknife.login.data.UserDao;
import com.giussepr.butterknife.login.model.LoginModel;
import com.giussepr.butterknife.login.model.LoginModelClass;
import com.giussepr.butterknife.login.presenter.LoginPresenter;
import com.giussepr.butterknife.login.presenter.LoginPresenterClass;
import com.giussepr.butterknife.login.repository.LocalDatabaseRepository;
import com.giussepr.butterknife.login.repository.LoginRepository;

import dagger.Module;
import dagger.Provides;

@Module
public class LoginModule {

    @Provides
    public LoginPresenter provideLoginPresenter(LoginModel model){
        return new LoginPresenterClass(model);
    }

    @Provides
    public LoginModel provideLoginModel(LoginRepository repository){
        return new LoginModelClass(repository);
    }

    @Provides
    public LoginRepository provideLoginRepository(LocalDataSource localDataSource) {
        return new LocalDatabaseRepository();
    }
}
