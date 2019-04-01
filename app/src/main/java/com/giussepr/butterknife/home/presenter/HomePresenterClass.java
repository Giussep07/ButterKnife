package com.giussepr.butterknife.home.presenter;

import com.giussepr.butterknife.home.model.HomeModel;
import com.giussepr.butterknife.home.view.HomeView;

import javax.inject.Inject;

import androidx.annotation.Nullable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class HomePresenterClass implements HomePresenter {

    @Nullable
    private HomeView view;
    private HomeModel model;

    @Inject
    public HomePresenterClass(HomeModel model) {
        this.model = model;
    }

    @Override
    public void loadImages() {
        CompositeDisposable disposable = new CompositeDisposable();
        disposable.add(model.loadImages()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        pixabay -> {
                            if (pixabay.getHits().size() > 0) {
                                view.showImages(pixabay.getHits(), true);
                            } else {
                                view.showNoImages();
                            }
                        },
                        throwable -> {
                            throwable.printStackTrace();
                            view.showServerError("Error");
                        }));
    }

    @Override
    public void setView(HomeView view) {
        this.view = view;
    }
}
