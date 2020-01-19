package com.example.flickr_mvvm_architectural_component.data.remote;

import java.util.List;

import com.example.flickr_mvvm_architectural_component.data.SearchImageRepositoryInterface;
import com.example.flickr_mvvm_architectural_component.data.model.Resource;
import com.example.flickr_mvvm_architectural_component.db.Database;
import com.example.flickr_mvvm_architectural_component.db.entity.ImageEntity;
import com.example.flickr_mvvm_architectural_component.utils.AppExecutors;

import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.paging.DataSource;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;

public class SearchImageRepository implements SearchImageRepositoryInterface {

	@Nullable
	private static SearchImageRepository sInstance;

	private AppExecutors appExecutors;
	private WebService webService;

	private MediatorLiveData<Resource<PagedList<ImageEntity>>> imagesResource;
	private LiveData<PagedList<ImageEntity>> databaseSource;
	private Database database;

	public SearchImageRepository(final Database database, final AppExecutors appExecutors,
		final WebService webService) {
		this.webService = webService;
		this.database = database;
		this.appExecutors = appExecutors;
		this.imagesResource = new MediatorLiveData<>();
	}

	public static SearchImageRepository getInstance(int pageSize, final Database database,
		AppExecutors appExecutors, WebService webService) {
		if (sInstance == null) {
			synchronized (SearchImageRepository.class) {
				if (sInstance == null) {
					sInstance = new SearchImageRepository(database, appExecutors, webService);
				}
			}
		}
		return sInstance;
	}

	public LiveData<Resource<PagedList<ImageEntity>>> getImages() {
		return imagesResource;
	}

	public void searchImages(String query) {
		if (databaseSource != null) {
			imagesResource.removeSource(databaseSource);
		}

		PagedList.Config pagingConfig = new PagedList.Config.Builder()
			.setPageSize(100)
			.setPrefetchDistance(150)
			.setEnablePlaceholders(true)
			.build();

		DataSource.Factory<Integer, ImageEntity> dataSource = database.getImagesDao()
			.getImages(query);
		databaseSource = new LivePagedListBuilder<>(dataSource, pagingConfig)
			.setBoundaryCallback(new SearchBoundaryCallback(query, this)).build();
		imagesResource.addSource(databaseSource,
			flickrImageEntities -> imagesResource.setValue(Resource.success(flickrImageEntities)));
	}

	public void getImagesAtPage(final String searchString, int pageNumber) {
		imagesResource.removeSource(databaseSource);
		imagesResource
			.addSource(databaseSource, data -> imagesResource.setValue(Resource.loading(data)));

		getImagesCallBack(searchString, pageNumber);
	}

	private void getImagesCallBack(String query, int pageNumber) {
		webService.getImages(query, pageNumber,
			new WebService.SearchImageCallback<List<ImageEntity>>() {
				@Override
				public void onSuccess(List<ImageEntity> response) {
					if (response == null) {
						return;
					}

					imagesResource.removeSource(databaseSource);

					for (ImageEntity entity : response) {
						entity.setSearchTerm(query);
					}

					appExecutors.diskIO().execute(() -> {
						database.getImagesDao().insertAll(response);

						appExecutors.mainThread().execute(() -> {
							imagesResource
								.addSource(databaseSource, newData -> imagesResource.setValue(
									Resource.success(newData)));
						});
					});

				}

				@Override
				public void onFailure(String errorMessage) {
					imagesResource.removeSource(databaseSource);
					imagesResource.addSource(databaseSource, newData -> imagesResource
						.setValue(Resource.error(errorMessage, newData)));
				}
			});
	}
}
