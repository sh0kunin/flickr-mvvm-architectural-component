package com.example.flickr_mvvm_architectural_component.utils;

import java.util.List;

import com.example.flickr_mvvm_architectural_component.data.remote.WebService;
import com.example.flickr_mvvm_architectural_component.db.entity.ImageEntity;

public class MockFailService extends WebService {

	public MockFailService() {
		super(null);
	}

	@Override
	public void getImages(
		String searchString, int pageNumber, final SearchImageCallback<List<ImageEntity>> callback) {
		callback.onFailure("Error!");
	}
}
