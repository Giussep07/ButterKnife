package com.giussepr.butterknife.home.view;

import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;

import com.giussepr.butterknife.R;
import com.giussepr.butterknife.dataSource.remote.pixabay.Hit;
import com.giussepr.butterknife.home.presenter.HomePresenter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.android.support.DaggerAppCompatActivity;

public class HomeActivity extends DaggerAppCompatActivity implements HomeView {

    @Inject
    HomePresenter presenter;
    @BindView(R.id.recyclerHits)
    RecyclerView mRecyclerView;

    private HitAdapter hitAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);

        presenter.loadImages();

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
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the options menu from XML
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_menu, menu);

        // Get the SearchView and set the searchable configuration
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView = (SearchView) menu.findItem(R.id.menu_search).getActionView();
        // Assumes current activity is the searchable activity
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        searchView.setIconifiedByDefault(false); // Do not iconify the widget; expand it by default

        return true;
    }

    //region Implementation HomeView
    @Override
    public void showImages(List<Hit> hitList, boolean setAdapter) {
        if (hitList != null && !hitList.isEmpty()){
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
