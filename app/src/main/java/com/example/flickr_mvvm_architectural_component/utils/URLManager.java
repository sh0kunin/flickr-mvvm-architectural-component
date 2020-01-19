package com.example.flickr_mvvm_architectural_component.utils;



import android.net.Uri;

import com.example.flickr_mvvm_architectural_component.BuildConfig;
import com.example.flickr_mvvm_architectural_component.db.entity.ImageEntity;

public class URLManager {

    public static String getSearchImagesURL(String searchString, int pageNumber) {
        String url = Uri.parse(AppConstants.ENDPOINT_SEARCH).buildUpon()
            .appendQueryParameter(AppConstants.METHOD, AppConstants.METHOD_SEARCH)
            .appendQueryParameter(AppConstants.API_KEY, BuildConfig.API_KEY)
            .appendQueryParameter(AppConstants.FORMAT, AppConstants.JSON)
            .appendQueryParameter(AppConstants.NOJSONCALLBACK, AppConstants.NOJSONCALLBACK_VALUE)
            .appendQueryParameter(AppConstants.TEXT, searchString)
            .appendQueryParameter(AppConstants.PAGE, String.valueOf(pageNumber))
            .build().toString();

        return url;
    }

    public static String getImageUrl(final ImageEntity searchImage) {
        if(searchImage!=null) {
            Uri.Builder builder = new Uri.Builder();
            builder.scheme(AppConstants.HTTPS)
                .authority(AppConstants.FARM + searchImage.getFarm() + AppConstants.METHOD_IMAGE)
                .appendPath(searchImage.getServer())
                .appendPath(searchImage.getFlickrId() + AppConstants.UNDERSCORE + searchImage.getSecret() + AppConstants.JPG);

            return builder.build().toString();
        }

        return "";
    }

}
