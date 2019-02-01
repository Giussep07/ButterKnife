package com.giussepr.butterknife.login.repository;

import com.giussepr.butterknife.dataBase.LocalDataSource;
import com.giussepr.butterknife.login.data.User;

import javax.inject.Inject;

public class LocalDatabaseRepository implements LoginRepository {

    @Inject
    LocalDataSource localDataSource;

    public LocalDatabaseRepository() {

    }

    @Override
    public User loginUser(String email, String password) {
        return localDataSource.getUserDao().loginUser(email, password);
    }
}
