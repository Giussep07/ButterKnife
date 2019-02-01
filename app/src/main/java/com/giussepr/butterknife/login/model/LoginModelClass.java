package com.giussepr.butterknife.login.model;

import com.giussepr.butterknife.login.data.User;
import com.giussepr.butterknife.login.repository.LoginRepository;

public class LoginModelClass implements LoginModel {

    private LoginRepository repository;

    public LoginModelClass(LoginRepository repository) {
        this.repository = repository;
    }

    @Override
    public User loginUser(String email, String password) {
        return repository.loginUser(email, password);
    }
}
