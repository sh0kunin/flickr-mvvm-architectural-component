package com.example.flickr_mvvm_architectural_component.data.remote;

import com.example.flickr_mvvm_architectural_component.data.SearchImageRepositoryInterface;
import com.example.flickr_mvvm_architectural_component.db.entity.ImageEntity;

import androidx.annotation.NonNull;
import androidx.paging.PagedList;

public class SearchBoundaryCallback extends PagedList.BoundaryCallback<ImageEntity> {

    private final String query;
    private final SearchImageRepositoryInterface searchImageRepository;

    public SearchBoundaryCallback(String query, final SearchImageRepositoryInterface repository) {
        this.query = query;
        this.searchImageRepository = repository;
    }

    @Override
    public void onZeroItemsLoaded() {
        super.onZeroItemsLoaded();

        searchImageRepository.getImagesAtPage(query, 1);
    }

    @Override
    public void onItemAtEndLoaded(@NonNull ImageEntity itemAtEnd) {
        super.onItemAtEndLoaded(itemAtEnd);

        searchImageRepository.getImagesAtPage(query, itemAtEnd.getPageNumber() + 1);
    }

}
