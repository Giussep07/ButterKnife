package com.giussepr.butterknife.login.view;

import com.giussepr.butterknife.models.User;

public interface LoginView {
    String getEmail();

    String getPassword();

    void showUserNotExist();

    void showPasswordIncorrect();

    void showEmailError(int error);

    void showPasswordError();

    void loginSuccess(User user);

    void openRegisterActivity();

    void disableUIElements();

    void enableUIElements();

    void showProgress();

    void hideProgress();

    void resetFieldsErrors();
}
