package com.example.flickr_mvvm_architectural_component.utils;

import java.util.ArrayList;
import java.util.List;

import com.example.flickr_mvvm_architectural_component.db.entity.ImageEntity;

public class TestUtils {

	public static List<ImageEntity> getImageEntities() {
		List<ImageEntity> imageEntities = new ArrayList<>();
		ImageEntity imageEntityOne = getImageEntity("id1", "title one", 1, "url1");
		ImageEntity imageEntityTwo = getImageEntity("id2", "title two", 2, "url2");
		imageEntities.add(imageEntityOne);
		imageEntities.add(imageEntityTwo);
		return imageEntities;
	}

	private static ImageEntity getImageEntity(String id1, String s, int i, String url1) {
		return new ImageEntity(id1, s, "server", "secret", "title", i, 1,
			url1);
	}

}
