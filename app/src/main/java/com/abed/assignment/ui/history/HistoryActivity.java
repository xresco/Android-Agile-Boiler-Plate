package com.abed.assignment.ui.history;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.abed.assignment.R;
import com.abed.assignment.ui.base.BaseActivity;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HistoryActivity extends BaseActivity implements HistoryMvpView {

    @Inject
    HistoryPresenter mHistoryPresenter;
    @Inject
    HistoryAdapter historyAdapter;

    @BindView(R.id.recylcer_history)
    RecyclerView recylcerHistory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivityComponent().inject(this);
        setContentView(R.layout.activity_history);
        ButterKnife.bind(this);
        mHistoryPresenter.attachView(this);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        recylcerHistory.setLayoutManager(mLayoutManager);
        recylcerHistory.setAdapter(historyAdapter);
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
