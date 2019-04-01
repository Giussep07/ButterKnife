package com.giussepr.butterknife.searchResult.view;

import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;

import com.giussepr.butterknife.R;
import com.giussepr.butterknife.dataSource.remote.pixabay.Hit;
import com.giussepr.butterknife.home.view.HitAdapter;
import com.giussepr.butterknife.searchResult.presenter.SearchResultPresenter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.android.support.DaggerAppCompatActivity;

public class SearchResultActivity extends DaggerAppCompatActivity implements SearchResultView {

    @Inject
    SearchResultPresenter presenter;

    private HitAdapter hitAdapter;

    @BindView(R.id.recyclerHits)
    RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_result);

        ButterKnife.bind(this);

        handleIntent(getIntent());

        hitAdapter = new HitAdapter(new ArrayList<>(), this);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        //mRecyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        mRecyclerView.setAdapter(hitAdapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.setView(this);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        handleIntent(intent);
    }

    private void handleIntent(Intent intent) {
        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            String query = intent.getStringExtra(SearchManager.QUERY);
            presenter.loadImages(query);
        }
    }

    //region Implementation SearchResultView

    @Override
    public void showImages(List<Hit> hitList) {
        if (hitList != null && !hitList.isEmpty()) {
            hitAdapter.setHitList(hitList);
        }
    }

    @Override
    public void showNoImages() {

    }

    @Override
    public void showServerError(String error) {

    }

    //endregion
}
