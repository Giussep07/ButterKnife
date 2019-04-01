package com.giussepr.butterknife.searchResult;

import com.giussepr.butterknife.searchResult.model.SearchResultModel;
import com.giussepr.butterknife.searchResult.model.SearchResultModelClass;
import com.giussepr.butterknife.searchResult.presenter.SearchResultPresenter;
import com.giussepr.butterknife.searchResult.presenter.SearchResultPresenterClass;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class SearchResultModule {

    @Binds
    abstract SearchResultPresenter provideSearchResultPresenter(SearchResultPresenterClass presenterClass);

    @Binds
    abstract SearchResultModel provideSearchResultModel(SearchResultModelClass modelClass);
}
