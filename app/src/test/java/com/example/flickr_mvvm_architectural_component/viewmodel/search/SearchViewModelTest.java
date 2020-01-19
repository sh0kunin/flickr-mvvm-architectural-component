package com.example.flickr_mvvm_architectural_component.viewmodel.search;

import android.app.Application;

import com.example.flickr_mvvm_architectural_component.data.SearchImageRepositoryInterface;
import com.example.flickr_mvvm_architectural_component.data.remote.SearchImageRepository;
import com.example.flickr_mvvm_architectural_component.db.entity.ImageEntity;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.paging.PagedList;

import static com.example.flickr_mvvm_architectural_component.data.model.LoadingStatus.LOADING;
import static com.example.flickr_mvvm_architectural_component.data.model.LoadingStatus.SUCCESS;


public class SearchViewModel extends AndroidViewModel {

    private final SearchImageRepositoryInterface searchImageRepository;
    private final MediatorLiveData<PagedList<ImageEntity>> imagesListLiveData;
    private final MutableLiveData<Boolean> successLiveData;
    private final MutableLiveData<Boolean> loadingLiveData;
    private final MutableLiveData<Boolean> errorLiveData;
    private final MutableLiveData<String> queryLiveData;

    public SearchViewModel(Application application, SearchImageRepository repository) {
        super(application);

        this.searchImageRepository = repository;
        errorLiveData = new MutableLiveData<>();
        queryLiveData = new MutableLiveData<>();
        loadingLiveData = new MutableLiveData<>();
        successLiveData = new MutableLiveData<>();
        loadingLiveData.setValue(null);

        imagesListLiveData = new MediatorLiveData<>();
        imagesListLiveData.addSource(searchImageRepository.getImages(), (resource) -> {
            imagesListLiveData.setValue(resource.getData());
            errorLiveData.setValue(resource.getErrorMessage() != null);
            loadingLiveData.setValue((resource.getLoadingStatus() == LOADING));
            successLiveData.setValue((resource.getLoadingStatus() == SUCCESS));
        });
    }

    public LiveData<PagedList<ImageEntity>> getImages() {
        return imagesListLiveData;
    }

    public LiveData<Boolean> isSuccess() {
        return successLiveData;
    }

    public LiveData<Boolean> hasError() {
        return errorLiveData;
    }

    public LiveData<Boolean> isLoading() {
        return loadingLiveData;
    }

    public void setQuery(String query) {
        queryLiveData.setValue(query);
    }

    public void searchImages() {
        searchImageRepository.searchImages(queryLiveData.getValue());
    }

}
