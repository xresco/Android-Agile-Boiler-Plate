package com.abed.assignment.ui.main;

import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.abed.assignment.R;
import com.abed.assignment.data.model.Photo;
import com.abed.assignment.ui.base.BaseActivity;
import com.abed.assignment.ui.history.HistoryActivity;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import timber.log.Timber;

public class MainActivity extends BaseActivity implements MainMvpView {

    @Inject
    MainPresenter mMainPresenter;

    @Inject
    MainAdapter mainAdapter;

    @BindView(R.id.recylcer_imgs)
    RecyclerView recyclerImgs;

    @BindView(R.id.progress_loading)
    ProgressBar progressLoading;

    @BindView(R.id.fab)
    FloatingActionButton fabButton;

    private boolean mIsLoading = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Timber.d("oncreate ");
        getActivityComponent().inject(this);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mMainPresenter.attachView(this);
        GridLayoutManager layoutManager = new GridLayoutManager(this, 3);
        recyclerImgs.setLayoutManager(layoutManager);
        recyclerImgs.setAdapter(mainAdapter);
        mainAdapter.setmClicksListener((view, position) -> Toast.makeText(view.getContext(), "Item clicked: " + position, Toast.LENGTH_SHORT).show());
        recyclerImgs.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                if (mIsLoading)
                    return;
                int visibleItemCount = layoutManager.getChildCount();
                int totalItemCount = layoutManager.getItemCount();
                int pastVisibleItems = layoutManager.findFirstVisibleItemPosition();
                if (pastVisibleItems + visibleItemCount >= totalItemCount) {
                    //End of list
                    mIsLoading = true;
                    progressLoading.setVisibility(View.VISIBLE);
                    mMainPresenter.loadNextPage();
                }
            }
        });
        fabButton.setOnClickListener(v -> HistoryActivity.startActivity(v.getContext()));
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        mMainPresenter.detachView();
    }

    @Override
    public void showItems(List<Photo> items) {
        mainAdapter.updateList(items);
        progressLoading.setVisibility(View.GONE);
        mIsLoading = false;
    }

    @Override
    public void addToItems(List<Photo> items) {
        mainAdapter.addToList(items);
        progressLoading.setVisibility(View.GONE);
        mIsLoading = false;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_search, menu);
        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchManager searchManager = (SearchManager) MainActivity.this.getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView = null;
        if (searchItem != null) {
            searchView = (SearchView) searchItem.getActionView();
        }
        if (searchView != null) {
            searchView.setSearchableInfo(searchManager.getSearchableInfo(MainActivity.this.getComponentName()));
        }
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                progressLoading.setVisibility(View.VISIBLE);
                mMainPresenter.search(query);
                mIsLoading = true;
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }

}
