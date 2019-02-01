package com.giussepr.butterknife.login.presenter;

import com.giussepr.butterknife.login.data.User;
import com.giussepr.butterknife.login.model.LoginModel;
import com.giussepr.butterknife.login.view.LoginView;

import androidx.annotation.Nullable;

public class LoginPresenterClass implements LoginPresenter {

    @Nullable
    private LoginView view;
    private LoginModel model;

    public LoginPresenterClass(LoginModel model) {
        this.model = model;
    }

    @Override
    public void setView(LoginView view) {
        this.view = view;
    }

    @Override
    public void loginButtonClicked() {
        if (view != null) {
            if (view.getEmail().trim().equals("") || view.getPassword().trim().equals("")) {
                view.showInputError();
            } else {
                User user = model.loginUser(view.getEmail(), view.getPassword());

                if (user == null) {
                    view.showUserNotExist();
                } else {
                    view.loginSuccess();
                }
            }
        }
    }

    @Override
    public User getRememberedUser() {
        return null;
    }
}
