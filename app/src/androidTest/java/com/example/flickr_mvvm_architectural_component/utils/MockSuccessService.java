package com.example.flickr_mvvm_architectural_component.utils;

import java.util.List;

import com.example.flickr_mvvm_architectural_component.data.remote.WebService;
import com.example.flickr_mvvm_architectural_component.db.entity.ImageEntity;

public class MockSuccessService extends WebService {

	private List<ImageEntity> images;

	public MockSuccessService(List<ImageEntity> flickrImageEntities) {
		super(null);

		images = flickrImageEntities;
	}

	@Override
	public void getImages(String searchString, int pageNumber,
		final SearchImageCallback<List<ImageEntity>> callback) {
		callback.onSuccess(images);
	}
}
