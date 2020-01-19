package com.example.flickrexample.data.remote;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;

import com.example.flickrexample.db.entity.ImageEntity;
import com.example.flickrexample.utils.URLManager;

import java.io.IOException;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * This AsyncTask is responsible for downloading an image from a URL and displaying it in a ImageView.
 *
 * Normally I would use a library like Glide or Picasso to achieve this as it handles a lot of the
 * corner cases as well as providing caching, etc.
 */
public class SearchImageAsyncTask extends AsyncTask<ImageEntity, Void, Bitmap> {

    private static final String TAG = SearchImageAsyncTask.class.getName();

    // Need to be careful about causing a memory leak - hold a weak reference which can be destroyed
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

