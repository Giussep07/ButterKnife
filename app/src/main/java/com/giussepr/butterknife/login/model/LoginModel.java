package com.giussepr.butterknife.login.model;

import com.giussepr.butterknife.login.data.User;

public interface LoginModel {

    User loginUser(String email, String password);
}
