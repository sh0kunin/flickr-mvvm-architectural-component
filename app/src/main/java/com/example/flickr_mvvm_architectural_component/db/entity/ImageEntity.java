package com.example.flickr_mvvm_architectural_component.db.entity;

import java.util.Objects;

import com.example.flickrexample.data.model.SearchImage;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "searchImageEntity")
public class SearchImageEntity implements SearchImage {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String flickrId;
    private String title;
    private String server;
    private String secret;
    private String searchTerm;
    private int farm;
    private int pageNumber;
    private String imageURL;

    public SearchImageEntity() {
    }

    @Ignore
    public SearchImageEntity(String flickrId, String title, String server, String secret, String searchTerm, int farm, int pageNumber) {
        this.flickrId = flickrId;
        this.title = title;
        this.server = server;
        this.secret = secret;
        this.searchTerm = searchTerm;
        this.farm = farm;
        this.pageNumber = pageNumber;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getFlickrId() {
        return flickrId;
    }

    @Override
    public String getTitle() {
        return this.title;
    }

    @Override
    public int getFarm() {
        return this.farm;
    }

    @Override
    public String getSecret() {
        return this.secret;
    }

    @Override
    public String getServer() {
        return this.server;
    }

    @Override
    public String getSearchTerm() {
        return this.searchTerm;
    }

    @Override
    public int getPageNumber() {
        return this.pageNumber;
    }

    @Override
    public String getImageURL() {
        return null;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFlickrId(String flickrId) {
        this.flickrId = flickrId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setFarm(int farm) {
        this.farm = farm;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public void setSearchTerm(String searchTerm) {
        this.searchTerm = searchTerm;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SearchImageEntity that = (SearchImageEntity) o;
        return id == that.id &&
                Objects.equals(flickrId, that.flickrId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, flickrId);
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }
}
