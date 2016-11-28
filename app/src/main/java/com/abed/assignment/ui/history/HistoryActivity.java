package com.abed.assignment.ui.history;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;

import com.abed.assignment.R;
import com.abed.assignment.databinding.ActivityHistoryBinding;
import com.abed.assignment.ui.base.BaseActivity;

import java.util.List;

import javax.inject.Inject;
public class HistoryActivity extends BaseActivity implements HistoryMvpView {

    @Inject
    HistoryPresenter mHistoryPresenter;
    @Inject
    HistoryAdapter historyAdapter;

    ActivityHistoryBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivityComponent().inject(this);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_history);
        mHistoryPresenter.attachView(this);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        binding.recyclerHistory.setLayoutManager(mLayoutManager);
        binding.recyclerHistory.setAdapter(historyAdapter);
        mHistoryPresenter.loadHistory();
    }

    public static void startActivity(Context context) {
        Intent intent = new Intent(context, HistoryActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mHistoryPresenter.detachView();
    }

    @Override
    public void showItems(List<String> items) {
        historyAdapter.updateList(items);
    }

}
