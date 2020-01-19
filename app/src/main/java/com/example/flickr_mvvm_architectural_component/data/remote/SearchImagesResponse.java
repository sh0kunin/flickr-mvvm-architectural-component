package com.example.flickr_mvvm_architectural_component.data.remote;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.example.flickr_mvvm_architectural_component.db.entity.ImageEntity;
import com.example.flickr_mvvm_architectural_component.utils.URLManager;

public class SearchImagesResponse {

	public List<ImageEntity> getSearchResultsResponse(final JSONObject jsonSearchResultsResponse) throws JSONException {
		ArrayList<ImageEntity> getImages = new ArrayList<>();

		JSONObject photos = jsonSearchResultsResponse.getJSONObject("photos");
		JSONArray photo = photos.getJSONArray("photo");
		int pageNumber = photos.getInt("page");

		for (int i = 0; i < photo.length(); i++) {
			ImageEntity entity = new ImageEntity();
			JSONObject jsonObject = photo.getJSONObject(i);
			entity.setFlickrId(jsonObject.getString("id"));
			entity.setTitle(jsonObject.getString("title"));
			entity.setFarm(jsonObject.getInt("farm"));
			entity.setServer(jsonObject.getString("server"));
			entity.setSecret(jsonObject.getString("secret"));
			entity.setPageNumber(pageNumber);
			entity.setImageURL(URLManager.getImageUrl(entity));
		}

		return getImages;
	}
}
