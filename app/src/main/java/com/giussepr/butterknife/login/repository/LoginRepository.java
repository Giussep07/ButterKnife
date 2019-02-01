package com.giussepr.butterknife.login.repository;

import com.giussepr.butterknife.login.data.User;

public interface LoginRepository {

    User loginUser(String email, String password);
}
