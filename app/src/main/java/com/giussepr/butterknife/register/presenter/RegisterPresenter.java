package com.giussepr.butterknife.register.presenter;

import com.giussepr.butterknife.register.view.RegisterView;

public interface RegisterPresenter {

    void setView(RegisterView view);

    void backButtonPressed();

    void registerButtonPressed();
}
