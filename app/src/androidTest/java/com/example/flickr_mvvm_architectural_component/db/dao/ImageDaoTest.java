package com.example.flickr_mvvm_architectural_component.db.dao;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import android.content.Context;

import com.example.flickr_mvvm_architectural_component.db.Database;
import com.example.flickr_mvvm_architectural_component.db.entity.ImageEntity;

import androidx.annotation.NonNull;
import androidx.paging.DataSource;
import androidx.paging.PositionalDataSource;
import androidx.room.Room;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.TestCase.assertEquals;

/*
    Testing DB
    https://developer.android.com/training/data-storage/room/testing-db
 */
@RunWith(AndroidJUnit4.class)
public class ImageDaoTest {

    private Database database;
    private ImageDao imageDao;

    @Before
    public void initDb() {
        Context context = ApplicationProvider.getApplicationContext();
        database = Room.inMemoryDatabaseBuilder(context, Database.class).build();
        imageDao = database.getImagesDao();
    }

    @After
    public void closeDb() {
        database.close();
    }

    @Test
    public void testEmptyDao() {
        assertNotNull(imageDao);
    }

    @Test
    public void testInsertAll() {
        imageDao.insertAll(getImageEntities());
        assertNotNull(imageDao);
    }

    @Test
    public void testGetImagesImageData() {
        imageDao.insertAll(getImageEntities());

        DataSource.Factory<Integer, ImageEntity> dataSource  = imageDao.getImages("title");

        ((PositionalDataSource<ImageEntity>) dataSource .create()).loadRange(
                new PositionalDataSource.LoadRangeParams(0, 2),
                new PositionalDataSource.LoadRangeCallback<ImageEntity>() {
                    @Override
                    public void onResult(@NonNull List<ImageEntity> data) {
                        assertEquals(2, data.size());
                        assertEquals(1, data.get(0).getId());
                        assertEquals(2, data.get(1).getId());
                        assertEquals("title one", data.get(0).getTitle());
                        assertEquals("title two", data.get(1).getTitle());

                    }
                });
    }

    private List<ImageEntity> getImageEntities() {
        List<ImageEntity> imageEntities = new ArrayList<>();
        ImageEntity imageEntityOne = new ImageEntity("id1", "title one", "server", "secret", "title", 1, 1,
            "url1");
        ImageEntity imageEntityTwo = new ImageEntity("id2", "title two", "server", "secret", "title", 2, 1,
            "url2");
        imageEntities.add(imageEntityOne);
        imageEntities.add(imageEntityTwo);
        return imageEntities;
    }
}
