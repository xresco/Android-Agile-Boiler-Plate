package com.abed.assignment.ui.main;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.abed.assignment.R;
import com.abed.assignment.data.model.Photo;
import com.abed.assignment.databinding.ItemMainActivityBinding;
import com.bumptech.glide.Glide;

import java.util.List;

import javax.inject.Inject;


public class MainAdapter extends RecyclerView.Adapter<MainAdapter.CustomViewHolder> {

    private List<Photo> mItems;
    private ViewHolderClicks mClicksListener;

    @Inject
    public MainAdapter() {
    }

    public void setmClicksListener(ViewHolderClicks mClicksListener) {
        this.mClicksListener = mClicksListener;
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemMainActivityBinding viewDataBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_main_activity, parent, false);
        return new CustomViewHolder(viewDataBinding, mClicksListener);
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {
        if (mItems == null || mItems.size() == 0) {
            return;
        }
        holder.setItem(mItems.get(position));
    }

    @Override
    public int getItemCount() {
        if (mItems == null) {
            return 0;
        }

        return mItems.size();
    }

    public void updateList(List<Photo> items) {
        this.mItems = items;
        notifyDataSetChanged();
    }

    public void addToList(List<Photo> items) {
        this.mItems.addAll(items);
        notifyDataSetChanged();
    }


    public static class CustomViewHolder extends RecyclerView.ViewHolder {

        ItemMainActivityBinding mBinding;

        public CustomViewHolder(ItemMainActivityBinding viewDataBinding, final ViewHolderClicks clicksListener) {
            super(viewDataBinding.getRoot());
            this.mBinding = viewDataBinding;
            viewDataBinding.getRoot().setOnClickListener(v -> clicksListener.onItemClick(v, getAdapterPosition()));

        }

        public void setItem(final Photo photo) {
            String url = "http://farm" + photo.farm + ".static.flickr.com/" + photo.server + "/" + photo.id + "_" + photo.secret + ".jpg";
            Log.d("log::", "setItem: " + photo.farm + " " + photo.server + " " + photo.id + " " + photo.secret);
            Glide.with((mBinding.imgContent).getContext().getApplicationContext())
                    .load(url)
                    .thumbnail(0.1f)
                    .into(mBinding.imgContent);
        }
    }


    public interface ViewHolderClicks {
        void onItemClick(View view, int position);
    }
}
