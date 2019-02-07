package com.giussepr.butterknife.login.model;

import com.giussepr.butterknife.models.User;
import com.giussepr.butterknife.source.UserDataSource;

import javax.inject.Inject;

import androidx.annotation.Nullable;
import io.reactivex.Single;

public class LoginModelClass implements LoginModel {

    @Nullable
    private UserDataSource repository;

    @Inject
    public LoginModelClass(UserDataSource repository) {
        this.repository = repository;
    }

    @Override
    public Single<User> loginUser(String email) {
        return repository.loginUser(email);
    }

    @Override
    public Single<User> loginUser(String email, String password) {
        return repository.loginUser(email, password);
    }
}
