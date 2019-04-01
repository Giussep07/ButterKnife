package com.giussepr.butterknife.home.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.giussepr.butterknife.R;
import com.giussepr.butterknife.dataSource.remote.pixabay.Hit;
import com.giussepr.butterknife.utils.CircleTransform;
import com.google.android.material.chip.Chip;

import java.util.Arrays;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.core.widget.ContentLoadingProgressBar;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class HitAdapter extends RecyclerView.Adapter<HitAdapter.HitViewHolder> {

    private List<Hit> hitList;
    private Context context;

    public HitAdapter(List<Hit> hitList, Context context) {
        this.hitList = hitList;
        this.context = context;
    }

    public static class HitViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.imgUser)
        ImageView imgUser;
        @BindView(R.id.textViewUsername)
        TextView textViewUsername;
        @BindView(R.id.textViewUserId)
        TextView textViewUserId;
        @BindView(R.id.image)
        ImageView image;
        @BindView(R.id.progressBarImgUser)
        ContentLoadingProgressBar progressImgUser;
        @BindView(R.id.progressBarImage)
        ContentLoadingProgressBar progressImage;
        @BindView(R.id.linearTags)
        LinearLayoutCompat linearTags;

        public HitViewHolder(@NonNull View itemView) {
            super(itemView);

            ButterKnife.bind(this, itemView);
        }
    }

    @NonNull
    @Override
    public HitViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_image, parent, false);

        return new HitViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HitViewHolder holder, int position) {
        final Hit hit = hitList.get(position);

        if (hit != null) {
            Glide.with(context)
                    .load(hit.getUserImageURL())
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .transform(new CircleTransform(context))
                    .listener(new RequestListener<String, GlideDrawable>() {
                        @Override
                        public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
                            return false;
                        }

                        @Override
                        public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                            holder.progressImgUser.hide();
                            return false;
                        }
                    })
                    .into(holder.imgUser);

            holder.textViewUsername.setText(hit.getUser());

            holder.textViewUserId.setText(String.valueOf(hit.getUserId()));

            Glide.with(context)
                    .load(hit.getWebformatURL())
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .centerCrop()
                    .listener(new RequestListener<String, GlideDrawable>() {
                        @Override
                        public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
                            return false;
                        }

                        @Override
                        public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                            holder.progressImage.hide();
                            return false;
                        }
                    })
                    .into(holder.image);

            if (!hit.getTags().equals("")) {
                List<String> tagList = Arrays.asList(hit.getTags().split(", "));
                holder.linearTags.removeAllViews();

                for (String tag : tagList) {
                    Chip chip = new Chip(context);
                    chip.setText(tag);

                    holder.linearTags.addView(chip);

                    LinearLayoutCompat.LayoutParams layoutParams = (LinearLayoutCompat.LayoutParams) chip.getLayoutParams();

                    layoutParams.setMarginEnd(16);
                    chip.setLayoutParams(layoutParams);
                }
            }
        }
    }

    @Override
    public int getItemCount() {
        return hitList.size();
    }

    public void setHitList(List<Hit> hitList) {
        if (hitList != null && !hitList.isEmpty()) {
            this.hitList = hitList;
            notifyDataSetChanged();
        }
    }
}
