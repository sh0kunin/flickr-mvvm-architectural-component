package com.example.flickrexample.db.dao;

import androidx.annotation.NonNull;
import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.paging.DataSource;
import androidx.paging.PositionalDataSource;
import androidx.room.Room;
import androidx.test.core.app.ApplicationProvider;

import com.example.flickrexample.db.Database;
import com.example.flickrexample.db.entity.SearchImageEntity;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class SearchImageDaoTest {

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    private Database mDatabase;

    private SearchImageDao mSearchImageDao;

    @Before
    public void initDb() {
        mDatabase = Room.inMemoryDatabaseBuilder(ApplicationProvider.getApplicationContext(), Database.class)
                        .allowMainThreadQueries()
                        .build();

        mSearchImageDao = mDatabase.searchImageDao();
    }

    @After
    public void closeDb() {
        mDatabase.close();
    }

    @Test
    public void searchFlickrImages_FlickrImagesInserted_ReturnsEmptyDataSource() {
        DataSource.Factory<Integer, SearchImageEntity> dataSource = mSearchImageDao.searchFlickrImages("Kittens");

        ((PositionalDataSource<SearchImageEntity>) dataSource .create()).loadRange(
                new PositionalDataSource.LoadRangeParams(0, 10),
                new PositionalDataSource.LoadRangeCallback<SearchImageEntity>() {
                    @Override
                    public void onResult(@NonNull List<SearchImageEntity> data) {
                        assertEquals(0, data.size());
                    }
        });
    }

    @Test
    public void searchFlickrImages_WithFlickrImagesInserted_ReturnsEmptyDataSource() {
        List<SearchImageEntity> flickrImageEntities = new ArrayList<>();
        flickrImageEntities.add(new SearchImageEntity("ID", "Kittens Title", "server", "secret", "Kittens", 10, 1));
        mSearchImageDao.insertAll(flickrImageEntities);

        DataSource.Factory<Integer, SearchImageEntity> dataSource  = mSearchImageDao.searchFlickrImages("Kittens");

        ((PositionalDataSource<SearchImageEntity>) dataSource .create()).loadRange(
                new PositionalDataSource.LoadRangeParams(0, 10),
                new PositionalDataSource.LoadRangeCallback<SearchImageEntity>() {
                    @Override
                    public void onResult(@NonNull List<SearchImageEntity> data) {
                        assertEquals(1, data.size());
                        assertEquals(1, data.get(0).getId());
                    }
                });
    }

}
