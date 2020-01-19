package com.example.flickr_mvvm_architectural_component.utils;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.example.flickr_mvvm_architectural_component.db.entity.ImageEntity;

@RunWith(AndroidJUnit4.class)

public class URLManagerTest {

    @Test
    public void testSearchImageURL() {
        assertEqual("", URLManager.getSearchImagesURL("title", 1));
    }

}
