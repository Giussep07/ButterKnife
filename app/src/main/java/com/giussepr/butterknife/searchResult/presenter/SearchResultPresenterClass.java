package com.giussepr.butterknife.searchResult.presenter;

import com.giussepr.butterknife.searchResult.model.SearchResultModel;
import com.giussepr.butterknife.searchResult.view.SearchResultView;

import javax.inject.Inject;

import androidx.annotation.Nullable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class SearchResultPresenterClass implements SearchResultPresenter {

    @Nullable
    private SearchResultView view;
    private SearchResultModel model;

    @Inject
    public SearchResultPresenterClass(SearchResultModel model) {
        this.model = model;
    }

    @Override
    public void setView(SearchResultView view) {
        this.view = view;
    }

    @Override
    public void loadImages(String query) {
        CompositeDisposable disposable = new CompositeDisposable();
        disposable.add(model.loadImages(query)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        pixabay -> {
                            if (pixabay.getHits().size() > 0) {
                                view.showImages(pixabay.getHits());
                            } else {
                                view.showNoImages();
                            }
                        },
                        throwable -> {
                            throwable.printStackTrace();
                            view.showServerError("Error");
                        }));
    }
}
