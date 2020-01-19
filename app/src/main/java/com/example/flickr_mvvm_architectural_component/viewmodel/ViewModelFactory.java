package com.example.flickr_mvvm_architectural_component.viewmodel;

import android.app.Application;

import com.example.flickr_mvvm_architectural_component.data.remote.SearchImageRepository;
import com.example.flickr_mvvm_architectural_component.view.search.SearchViewModel;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class ViewModelFactory implements ViewModelProvider.Factory {
    private SearchImageRepository imageRepository;
    private Application application;

    public ViewModelFactory(SearchImageRepository imagesRepository, Application application) {
        this.imageRepository = imagesRepository;
        this.application = application;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(SearchViewModel.class)) {
            return (T) new SearchViewModel(application, imageRepository);
        }
        return null;
    }
}