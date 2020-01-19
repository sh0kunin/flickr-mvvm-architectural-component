package com.example.flickr_mvvm_architectural_component.data.remote;

import java.io.IOException;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.URL;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;

import com.example.flickr_mvvm_architectural_component.db.entity.ImageEntity;
import com.example.flickr_mvvm_architectural_component.utils.URLManager;

public class SearchImageAsyncTask extends AsyncTask<ImageEntity, Void, Bitmap> {

    private static final String TAG = SearchImageAsyncTask.class.getName();

    private WeakReference<ImageView> mImageViewReference;

    public SearchImageAsyncTask(ImageView imageView) {
        this.mImageViewReference = new WeakReference<>(imageView);
    }

    protected Bitmap doInBackground(ImageEntity... searchImages) {
        String url = URLManager.getImageUrl(searchImages[0]);

        return downloadImage(url);
    }

    protected void onPostExecute(Bitmap result) {
        if (result == null) {
            Log.e(TAG, "Bitmap error!");
            return;
        }

        ImageView imageView = mImageViewReference.get();
        if (imageView != null) {
            imageView.setImageBitmap(result);
        }
    }

    private Bitmap downloadImage(String imageURL) {
        try {
            URL url = new URL(imageURL);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoInput(true);
            connection.connect();

            return BitmapFactory.decodeStream(connection.getInputStream());
        } catch (IOException e) {
            Log.e(TAG, "Could not download image");
            return null;
        }
    }
}

