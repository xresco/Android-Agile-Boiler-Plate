package com.abed.assignment.ui.main;

import android.app.SearchManager;
import android.content.Context;
import android.content.res.Configuration;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.abed.assignment.R;
import com.abed.assignment.data.model.Photo;
import com.abed.assignment.databinding.ActivityMainBinding;
import com.abed.assignment.ui.base.BaseActivity;
import com.abed.assignment.ui.history.HistoryActivity;

import java.util.List;

import javax.inject.Inject;

public class MainActivity extends BaseActivity implements MainMvpView {

    @Inject
    MainPresenter mMainPresenter;

    @Inject
    MainAdapter mainAdapter;

    ActivityMainBinding binding;
    private boolean mIsLoading = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivityComponent().inject(this);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mMainPresenter.attachView(this);
        GridLayoutManager layoutManager = new GridLayoutManager(this, 3);
        binding.recyclerImgs.setLayoutManager(layoutManager);
        binding.recyclerImgs.setAdapter(mainAdapter);
        mainAdapter.setmClicksListener((view, position) -> Toast.makeText(view.getContext(), "Item clicked: " + position, Toast.LENGTH_SHORT).show());
        binding.recyclerImgs.addOnScrollListener(new RecyclerView.OnScrollListener() {
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
                    binding.progressLoading.setVisibility(View.VISIBLE);
                    mMainPresenter.loadNextPage();
                }
            }
        });
        binding.fab.setOnClickListener(v -> HistoryActivity.startActivity(v.getContext()));

    }


    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mMainPresenter.detachView();
    }

    @Override
    public void showItems(List<Photo> items) {
        mainAdapter.updateList(items);
        binding.progressLoading.setVisibility(View.GONE);
        mIsLoading = false;
    }

    @Override
    public void addToItems(List<Photo> items) {
        mainAdapter.addToList(items);
        binding.progressLoading.setVisibility(View.GONE);
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
                binding.progressLoading.setVisibility(View.VISIBLE);
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
