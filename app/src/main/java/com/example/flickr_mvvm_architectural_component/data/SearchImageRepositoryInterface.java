package com.example.flickr_mvvm_architectural_component.data;

import com.example.flickr_mvvm_architectural_component.data.model.Resource;
import com.example.flickr_mvvm_architectural_component.db.entity.ImageEntity;

import androidx.lifecycle.LiveData;
import androidx.paging.PagedList;

public interface SearchImageRepositoryInterface {

    void searchImages(String searchString);
    LiveData<Resource<PagedList<ImageEntity>>> getImages();
    void getImagesAtPage(final String searchString, int pageNumber);

}
