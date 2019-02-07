package com.giussepr.butterknife.login.model;

import com.giussepr.butterknife.models.User;

import io.reactivex.Single;

public interface LoginModel {

    Single<User> loginUser(String email);

    Single<User> loginUser(String email, String password);
}
