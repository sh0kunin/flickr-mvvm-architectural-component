package com.example.flickr_mvvm_architectural_component.view.adapter;

import android.graphics.Bitmap;
import android.os.AsyncTask;

import com.example.flickr_mvvm_architectural_component.databinding.SquareListImageBinding;
import com.example.flickr_mvvm_architectural_component.db.entity.ImageEntity;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

class SearchImageViewHolder extends RecyclerView.ViewHolder {

    private final SquareListImageBinding squareListImageBinding;

    @Nullable
    private AsyncTask<ImageEntity, Void, Bitmap> imageDownloadAsyncTask;

    SearchImageViewHolder(final SquareListImageBinding binding) {
        super(binding.getRoot());

        this.squareListImageBinding = binding;
    }

    SquareListImageBinding getBinding() {
        return squareListImageBinding;
    }

    void downloadImage(final ImageEntity searchImage, final AsyncTask<ImageEntity, Void, Bitmap> asyncTask) {
        this.imageDownloadAsyncTask = asyncTask;

        imageDownloadAsyncTask.execute(searchImage);
    }

    void cancelLoadImage() {
        if (imageDownloadAsyncTask != null) {
            imageDownloadAsyncTask.cancel(true);
        }
    }
}
