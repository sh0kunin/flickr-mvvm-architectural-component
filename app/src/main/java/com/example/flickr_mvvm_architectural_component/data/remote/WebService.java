package com.example.flickr_mvvm_architectural_component.data.remote;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

import com.example.flickr_mvvm_architectural_component.db.entity.ImageEntity;
import com.example.flickr_mvvm_architectural_component.utils.AppConstants;
import com.example.flickr_mvvm_architectural_component.utils.AppExecutors;
import com.example.flickr_mvvm_architectural_component.utils.URLManager;

public class WebService {

	private final AppExecutors mAppExecutors;

	public WebService(AppExecutors appExecutors) {
		mAppExecutors = appExecutors;
	}

	public void getImages(String searchString, int pageNumber,
		final SearchImageCallaback<List<ImageEntity>> callback) {
		execute(URLManager.getSearchImagesURL(searchString, pageNumber),
			getImagesCallback(callback));
	}

	private SearchImageCallaback<JSONObject> getImagesCallback(
		final SearchImageCallaback<List<ImageEntity>> callback) {
		return new SearchImageCallaback<JSONObject>() {
			@Override
			public void onSuccess(final JSONObject response) {
				SearchImagesResponse searchImagesResponse = new SearchImagesResponse();
				try {
					callback.onSuccess(searchImagesResponse.getSearchResultsResponse(response));
				}
				catch (JSONException e) {
					callback.onFailure("Something went wrong, cant get search images response.");
				}
			}

			@Override
			public void onFailure(String errorMessage) {
				callback.onFailure(errorMessage);
			}
		};
	}

	private void execute(String requestPath, final SearchImageCallaback<JSONObject> callback) {
		mAppExecutors.networkIO().execute(() -> {
			try {
				JSONObject response = getJsonSearchResponse(requestPath);
				mAppExecutors.mainThread().execute(() -> {
					callback.onSuccess(response);
				});
			}
			catch (JSONException | IOException e) {
				handleError(callback);
			}
		});
	}

	private JSONObject getJsonSearchResponse(String requestPath) throws IOException, JSONException {
		URL url = new URL(requestPath);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setConnectTimeout(AppConstants.REQUEST_TIMEOUT);
		connection.connect();

		BufferedReader reader = new BufferedReader(
			new InputStreamReader(connection.getInputStream()));

		StringBuilder sb = new StringBuilder();
		String line;
		while ((line = reader.readLine()) != null) {
			sb.append(line).append("\n");
		}

		return new JSONObject(sb.toString());
	}

	private void handleError(final SearchImageCallaback callback) {
		mAppExecutors.mainThread().execute(() -> {
			callback.onFailure("Something went wrong, cant handle request");
		});
	}

	public interface SearchImageCallaback<T> {
		void onSuccess(T response);

		void onFailure(String errorMessage);
	}

}
