package com.example.flickr_mvvm_architectural_component.data.remote;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import com.example.flickr_mvvm_architectural_component.data.model.LoadingStatus;
import com.example.flickr_mvvm_architectural_component.data.model.Resource;
import com.example.flickr_mvvm_architectural_component.db.Database;
import com.example.flickr_mvvm_architectural_component.db.entity.ImageEntity;
import com.example.flickr_mvvm_architectural_component.utils.AppExecutors;
import com.example.flickr_mvvm_architectural_component.utils.MockAppExecutors;
import com.example.flickr_mvvm_architectural_component.utils.MockFailService;
import com.example.flickr_mvvm_architectural_component.utils.MockSuccessService;
import com.example.flickr_mvvm_architectural_component.utils.TestUtils;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.paging.PagedList;
import androidx.room.Room;
import androidx.test.core.app.ApplicationProvider;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertEquals;

public class SearchImageRepositoryTest {

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    private static Database database;
    private AppExecutors mAppExecutors;
    private WebService mWebservice;

    private Observer<Resource<PagedList<ImageEntity>>> mObserver = pagedListResource -> { };

    @Before
    public void setup() {
        database = Room.inMemoryDatabaseBuilder(ApplicationProvider.getApplicationContext(), Database.class).build();
        List<ImageEntity> imageEntities = TestUtils.getImageEntities();
        database.getImagesDao().insertAll(imageEntities);
        mWebservice = new MockSuccessService(imageEntities);
        mAppExecutors = MockAppExecutors.build();
    }

    @After
    public void clearDB() {
        database.clearAllTables();
    }

    @AfterClass
    public static void closeDB() {
        database.close();
    }

    @Test
    public void testGetInstance() {
        SearchImageRepository repository = SearchImageRepository.getInstance(database, mAppExecutors, mWebservice);

        assertNotNull(repository);
    }


    @Test
    public void testSearchImageResourceStatusSuccess() {
        SearchImageRepository repository = new SearchImageRepository(database, mAppExecutors, mWebservice);
        LiveData<Resource<PagedList<ImageEntity>>> entities = repository.getImages();
        entities.observeForever(mObserver);
        repository.searchImages("title");

        Resource<PagedList<ImageEntity>> resource = entities.getValue();

        assertNotNull(resource);
        assertEquals(LoadingStatus.SUCCESS, resource.getLoadingStatus());
    }

    @Test
    public void testSearchImageResourceStatusLoadingForNextPage() {
        SearchImageRepository repository = new SearchImageRepository(database, mAppExecutors, mWebservice);
        LiveData<Resource<PagedList<ImageEntity>>> entities = repository.getImages();
        entities.observeForever(mObserver);
        repository.searchImages("title");

        repository.getImagesAtPage("title", 2);

        Resource<PagedList<ImageEntity>> resource = entities.getValue();
        assertNotNull(resource);
        assertEquals(LoadingStatus.LOADING, resource.getLoadingStatus());
    }

    @Test
    public void testSearchImageResourceStatusErrorOnFailure() {
        SearchImageRepository repository = new SearchImageRepository(database, mAppExecutors, new MockFailService());
        LiveData<Resource<PagedList<ImageEntity>>> entities = repository.getImages();
        entities.observeForever(mObserver);
        repository.searchImages("title");

        repository.getImagesAtPage("title", 2);

        Resource<PagedList<ImageEntity>> resource = entities.getValue();

        assertNotNull(resource);
        assertEquals(LoadingStatus.ERROR, resource.getLoadingStatus());
        assertEquals("Error!", resource.getErrorMessage());
    }
}
