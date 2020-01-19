package com.example.flickr_mvvm_architectural_component;

import android.app.Application;

import com.example.flickr_mvvm_architectural_component.data.remote.WebService;
import com.example.flickr_mvvm_architectural_component.db.Database;
import com.example.flickr_mvvm_architectural_component.utils.AppExecutors;

public class FlickrSearchImageApplication extends Application {


    private WebService mFlickrApiService;
    private Database mDatabase;
    private AppExecutors mExecutors;

    @Override
    public void onCreate() {
        super.onCreate();
        // Create global dependencies
        mDatabase = provideDatabase();
        mExecutors = provideExecutors();
        mFlickrApiService = provideFlickrWebService();
    }

    private WebService provideFlickrWebService() {
        return new WebService(mExecutors);
    }

    private Database provideDatabase() {
        return Database.getInstance(this);
    }

    private AppExecutors provideExecutors() {
        return new AppExecutors();
    }

    public WebService getFlickrWebService() {
        return new WebService(getExecutors());
    }

    public Database getDatabase() {
        return Database.getInstance(this);
    }

    public AppExecutors getExecutors() {
        return mExecutors;
    }
}
