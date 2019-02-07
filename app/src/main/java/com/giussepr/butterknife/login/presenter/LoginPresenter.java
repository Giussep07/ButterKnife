package com.giussepr.butterknife.login.presenter;

import com.giussepr.butterknife.models.User;
import com.giussepr.butterknife.login.view.LoginView;

public interface LoginPresenter {

    void setView(LoginView view);

    void loginButtonClicked();

    User getRememberedUser();

    void registerButtonClicked();

}
