package com.auro.scholr.home.presentation.view.viewholder;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.auro.scholr.R;
import com.auro.scholr.databinding.FriendsBoardItemLayoutBinding;
import com.auro.scholr.home.data.model.FriendsLeaderBoardModel;
import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;

import android.graphics.Bitmap;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.graphics.drawable.RoundedBitmapDrawable;
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory;
import androidx.recyclerview.widget.RecyclerView;

import com.auro.scholr.R;
import com.auro.scholr.core.application.AuroApp;
import com.auro.scholr.databinding.FriendsBoardItemLayoutBinding;
import com.auro.scholr.home.data.model.FriendsLeaderBoardModel;
import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;

public class LeaderBoardItemViewHolder extends RecyclerView.ViewHolder {
    FriendsBoardItemLayoutBinding layoutBinding;

    public LeaderBoardItemViewHolder(@NonNull FriendsBoardItemLayoutBinding layoutBinding) {
        super(layoutBinding.getRoot());
        this.layoutBinding = layoutBinding;
    }


    public void bindUser(FriendsLeaderBoardModel model, int position) {
        int reminder = position % 2;
        if (reminder == 0) {
            layoutBinding.parentLayout.setBackgroundColor(layoutBinding.parentLayout.getContext().getResources().getColor(R.color.white));
        } else {
            layoutBinding.parentLayout.setBackgroundColor(layoutBinding.parentLayout.getContext().getResources().getColor(R.color.white));
        }
        layoutBinding.nameText.setText(model.getStudentName());

            Glide.with(layoutBinding.profileImage.getContext())
                    .asBitmap()
                    .load((String) model.getImagePath())
                    .listener(new RequestListener<Bitmap>() {
                                  @Override
                                  public boolean onLoadFailed(@Nullable GlideException e, Object o, Target<Bitmap> target, boolean b) {
                                      return true;
                                  }

                                  @Override
                                  public boolean onResourceReady(Bitmap resource, Object o, Target<Bitmap> target, DataSource dataSource, boolean b) {
                                      // add image to the imageView here
                                      RoundedBitmapDrawable circularBitmapDrawable =
                                              RoundedBitmapDrawableFactory.create(AuroApp.getAppContext().getResources(), resource);
                                      circularBitmapDrawable.setCircular(true);

                                      AuroApp.getAppContext().runOnUiThread(new Runnable() {
                                          @Override
                                          public void run() {
                                              // TODO your Code
                                              layoutBinding.profileImage.setImageDrawable(circularBitmapDrawable);
                                          }
                                      });

                                      return true;
                                  }
                              }
                    ).submit();


    }
}
