package com.example.flickr_mvvm_architectural_component.viewmodel.search;

import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import android.app.Application;

import com.example.flickr_mvvm_architectural_component.FlickrSearchImageApplication;
import com.example.flickr_mvvm_architectural_component.data.model.Resource;
import com.example.flickr_mvvm_architectural_component.data.remote.SearchImageRepository;
import com.example.flickr_mvvm_architectural_component.db.entity.ImageEntity;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.paging.PagedList;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertTrue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class SearchViewModelTest {

    @Rule
    public InstantTaskExecutorRule instantExecutorRule = new InstantTaskExecutorRule();

    private Application mockApplication;
    private MutableLiveData<Resource<PagedList<ImageEntity>>> imageResources;


    @Mock
    private PagedList<ImageEntity> mockPagedList;

    @Mock
    private SearchImageRepository mockRepository;

    private SearchViewModel viewModel;

    @Before
    public void setup() {

        mockApplication = new FlickrSearchImageApplication();
        mockRepository = mock(SearchImageRepository.class);
        viewModel = new SearchViewModel(mockApplication, mockRepository);
        imageResources = new MutableLiveData<>();

        when(mockRepository.getImages()).thenReturn(imageResources);
    }

    @Test
    public void testViewModelInstancesAreNotNull() {
        assertThat(viewModel.getImages(), CoreMatchers.notNullValue());
        assertThat(viewModel.error(), CoreMatchers.notNullValue());
        assertThat(viewModel.isLoading(), CoreMatchers.notNullValue());
        assertThat(viewModel.isSuccess(), CoreMatchers.notNullValue());

        LiveData<PagedList<ImageEntity>> images = viewModel.getImages();
        assertNotNull(images);
    }

    @Test
    public void testGetImagesIsNull() {
        SearchViewModel viewModel = new SearchViewModel(mockApplication, mockRepository);
        LiveData<PagedList<ImageEntity>> images = viewModel.getImages();
        images.observeForever(image -> { });

        assertNull(images.getValue());
    }

    @Test
    public void testSearchImagesExecutesOnRepository() {
        viewModel.setQuery("title");
        viewModel.searchImages();
        Mockito.verify(mockRepository, times(1)).searchImages("title" );
    }

    @Test
    public void testHasError() {
        SearchViewModel viewModel = new SearchViewModel(mockApplication, mockRepository);
        viewModel.getImages().observeForever(image -> { });
        imageResources.setValue(Resource.error("Something went wrong", null));
        LiveData<Boolean> hasError = viewModel.error();

        assertTrue(hasError.getValue());
    }

    @Test
    public void testIsSuccess() {
        SearchViewModel viewModel = new SearchViewModel(mockApplication, mockRepository);
        viewModel.getImages().observeForever(image -> { });
        imageResources.setValue(Resource.success(mockPagedList));
        LiveData<Boolean> isSuccess = viewModel.isSuccess();

        assertTrue(isSuccess.getValue());
    }

    @Test
    public void testIsLoadingIsFalse() {
        SearchViewModel viewModel = new SearchViewModel(mockApplication, mockRepository);
        LiveData<Boolean> isLoading = viewModel.isLoading();
        isLoading.observeForever(image -> { });

        assertNull(isLoading.getValue());
    }

    @Test
    public void testSetLoading() {
        SearchViewModel viewModel = new SearchViewModel(mockApplication, mockRepository);
        viewModel.getImages().observeForever(image -> { });
        imageResources.setValue(Resource.loading(null));
        LiveData<Boolean> isLoading = viewModel.isLoading();
        isLoading.observeForever(image -> { });

        assertTrue(isLoading.getValue());
    }


}
