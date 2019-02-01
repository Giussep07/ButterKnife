package com.giussepr.butterknife.login.view;

public interface LoginView {
    String getEmail();

    String getPassword();

    void showUserNotExist();

    void showInputError();

    void loginSuccess();
}
