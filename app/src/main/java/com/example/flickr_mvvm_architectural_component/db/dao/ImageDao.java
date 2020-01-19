package com.example.flickr_mvvm_architectural_component.db.dao;

import java.util.List;

import com.example.flickr_mvvm_architectural_component.db.entity.ImageEntity;

import androidx.paging.DataSource;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

@Dao
public interface ImageDao {

	@Query("SELECT * FROM ImageEntity WHERE searchTerm = :query")
	DataSource.Factory<Integer, ImageEntity> getImages(String query);

	@Insert(onConflict = OnConflictStrategy.REPLACE)
	void insertAll(List<ImageEntity> images);

}
