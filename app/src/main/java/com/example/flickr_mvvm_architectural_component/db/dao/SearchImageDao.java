package com.example.flickrexample.db.dao;

import androidx.paging.DataSource;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.flickrexample.db.entity.SearchImageEntity;

import java.util.List;

@Dao
public interface SearchImageDao {

    @Query("SELECT * FROM SearchImageEntity WHERE searchTerm = :searchTerm")
    DataSource.Factory<Integer, SearchImageEntity> searchFlickrImages(String searchTerm);

    @Insert()
    void insertAll(List<SearchImageEntity> flickrImages);

}
