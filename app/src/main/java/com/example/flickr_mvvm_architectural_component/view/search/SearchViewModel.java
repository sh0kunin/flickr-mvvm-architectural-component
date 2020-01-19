package com.example.flickr_mvvm_architectural_component.view.search;

import android.app.Application;

import com.example.flickr_mvvm_architectural_component.data.remote.SearchImageRepository;
import com.example.flickr_mvvm_architectural_component.data.remote.SearchImagesResponse;

import androidx.lifecycle.AndroidViewModel;

public class SearchViewModel extends AndroidViewModel {

    public SearchViewModel(Application application, SearchImageRepository searchImageRepository) {
        super(application);
    }
}
