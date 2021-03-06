package com.example.flickr_mvvm_architectural_component.db.entity;

import java.util.Objects;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "imageEntity")
public class ImageEntity {

	@PrimaryKey(autoGenerate = true)
	private int id;
	private String flickrId;
	private String title;
	private String server;
	private String secret;
	private String searchTerm;
	private int farm;
	private int pageNumber;

	public ImageEntity() {

	}

	public ImageEntity(String flickrId, String title, String server, String secret,
		String searchTerm, int farm, int pageNumber, String imageURL) {
		this.flickrId = flickrId;
		this.title = title;
		this.server = server;
		this.secret = secret;
		this.searchTerm = searchTerm;
		this.farm = farm;
		this.pageNumber = pageNumber;
	}

	public int getId() {
		return id;
	}

	public String getFlickrId() {
		return flickrId;
	}

	public String getTitle() {
		return this.title;
	}

	public int getFarm() {
		return this.farm;
	}

	public String getSecret() {
		return this.secret;
	}

	public String getServer() {
		return this.server;
	}

	public String getSearchTerm() {
		return this.searchTerm;
	}

	public int getPageNumber() {
		return this.pageNumber;
	}

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
		ImageEntity that = (ImageEntity) o;
		return id == that.id &&
			flickrId == that.flickrId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
			+ ((flickrId == null) ? 0 : flickrId.hashCode());
		return result;
	}

}
