package com.abed.assignment.ui.main;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.abed.assignment.R;
import com.abed.assignment.data.model.Photo;
import com.bumptech.glide.Glide;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

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
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_main_activity, parent, false);
        return new CustomViewHolder(view, mClicksListener);
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
        @BindView(R.id.img_content)
        ImageView imageContent;

        public CustomViewHolder(View view, final ViewHolderClicks clicksListener) {
            super(view);
            ButterKnife.bind(this, view);
            view.setOnClickListener(v -> clicksListener.onItemClick(v, getAdapterPosition()));
        }


        public void setItem(final Photo photo) {
            String url = "http://farm" + photo.farm + ".static.flickr.com/" + photo.server + "/" + photo.id + "_" + photo.secret + ".jpg";
            Log.d("log::", "setItem: " + photo.farm + " " + photo.server + " " + photo.id + " " + photo.secret);
            Glide.with((imageContent).getContext().getApplicationContext())
                    .load(url)
                    .thumbnail(0.1f)
                    .into(imageContent);
        }
    }


    public interface ViewHolderClicks {
        void onItemClick(View view, int position);
    }
}
