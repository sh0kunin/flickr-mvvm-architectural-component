package com.example.flickr_mvvm_architectural_component;

import android.app.Application;

import com.example.flickr_mvvm_architectural_component.data.remote.SearchImageRepository;
import com.example.flickr_mvvm_architectural_component.data.remote.WebService;
import com.example.flickr_mvvm_architectural_component.db.Database;
import com.example.flickr_mvvm_architectural_component.utils.AppExecutors;
import com.example.flickr_mvvm_architectural_component.viewmodel.ViewModelFactory;

public class FlickrSearchImageApplication extends Application {


    private WebService webService;
    private Database database;
    private AppExecutors appExecutors;
    private ViewModelFactory viewModelFactory;
    private SearchImageRepository imageRepository;
    @Override
    public void onCreate() {
        super.onCreate();
        // Create global dependencies
        database = provideDatabase();
        appExecutors = provideExecutors();
        webService = provideWebService();
        imageRepository = provideImagesRepository();
        viewModelFactory = provideViewModelFactory(imageRepository);
    }

    private WebService provideWebService() {
        return new WebService(appExecutors);
    }

    private Database provideDatabase() {
        return Database.getInstance(this);
    }

    private AppExecutors provideExecutors() {
        return new AppExecutors();
    }

    private ViewModelFactory provideViewModelFactory(SearchImageRepository imagesRepository) {
        return new ViewModelFactory(imagesRepository, this);
    }

    private SearchImageRepository provideImagesRepository() {
        return SearchImageRepository.getInstance(database, appExecutors, webService);
    }


    public WebService getFlickrWebService() {
        return new WebService(getExecutors());
    }

    public Database getDatabase() {
        return Database.getInstance(this);
    }

    public AppExecutors getExecutors() {
        return appExecutors;
    }

    public ViewModelFactory getViewModelFactory() {
        return viewModelFactory;
    }

}
