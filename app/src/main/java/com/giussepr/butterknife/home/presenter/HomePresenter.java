package com.giussepr.butterknife.home.presenter;

import com.giussepr.butterknife.home.view.HomeView;

public interface HomePresenter {

    void setView(HomeView view);

    void loadImages();
}
