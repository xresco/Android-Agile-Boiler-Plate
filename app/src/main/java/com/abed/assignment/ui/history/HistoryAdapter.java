package com.abed.assignment.ui.history;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.abed.assignment.R;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.CustomViewHolder> {

    private List<String> items;

    @Inject
    public HistoryAdapter() {
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_history_activity, parent, false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {
        if (items == null || items.size() == 0) {
            return;
        }
        holder.setItem(items.get(position));
    }

    @Override
    public int getItemCount() {
        if (items == null) {
            return 0;
        }

        return items.size();
    }

    public void updateList(List<String> items) {

        this.items = items;
        notifyDataSetChanged();
    }


    public static class CustomViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.txt_content)
        TextView content;


        public CustomViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
        public void setItem(final String item) {
            content.setText(item);
        }
    }


}
