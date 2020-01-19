package com.example.flickr_mvvm_architectural_component.utils;


import org.junit.Test;
import org.junit.runner.RunWith;

import android.net.Uri;

import com.example.flickr_mvvm_architectural_component.BuildConfig;
import com.example.flickr_mvvm_architectural_component.db.entity.ImageEntity;

import androidx.test.ext.junit.runners.AndroidJUnit4;

import static junit.framework.TestCase.assertEquals;

@RunWith(AndroidJUnit4.class)
public class URLManagerTest {
	@Test
	public void testSearchImageURL() {
		String url = URLManager.getSearchImagesURL("title", 1);

		String expected = "https://api.flickr.com/services/rest/?method=flickr.photos.search&api_key=0c1d44a15c80de023668a6063467aff9&format=json&nojsoncallback=1&text=title&page=1";
		assertEquals(expected, url);
	}

	@Test
	public void testImageURL() {
		ImageEntity imageEntity = new ImageEntity("id", "title", "server", "secret", "title", 1, 1, "title");

		String url = URLManager.getImageUrl(imageEntity);

		String expected = "https://farm1.static.flickr.com/server/id_secret.jpg";
		assertEquals(expected, url);
	}
}
