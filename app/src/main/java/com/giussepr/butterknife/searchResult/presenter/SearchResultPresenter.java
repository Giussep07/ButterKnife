package com.giussepr.butterknife.searchResult.presenter;

import com.giussepr.butterknife.searchResult.view.SearchResultView;

public interface SearchResultPresenter {
    void setView(SearchResultView view);

    void loadImages(String query);
}
