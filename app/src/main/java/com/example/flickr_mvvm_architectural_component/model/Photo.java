package com.example.flickr_mvvm_architectural_component.model;


/*
This class is a data model to create a Photo URL.
To get a photo, we need to construct a URLs as mentioned here https://www.flickr.com/services/api/misc.urls.html.
	https://farm{farm-id}.staticflickr.com/{server-id}/{id}_{secret}.jpg
		or
	https://farm{farm-id}.staticflickr.com/{server-id}/{id}_{secret}_[mstzb].jpg
		or
	https://farm{farm-id}.staticflickr.com/{server-id}/{id}_{o-secret}_o.(jpg|gif|png)

 */
public class Photo {
	private String id;
	private String owner;
	private String secret;
	private String server;
	private int farm;
	private String title;
	private int ispublic;
	private int isfriend;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getSecret() {
		return secret;
	}

	public void setSecret(String secret) {
		this.secret = secret;
	}

	public String getServer() {
		return server;
	}

	public void setServer(String server) {
		this.server = server;
	}

	public int getFarm() {
		return farm;
	}

	public void setFarm(int farm) {
		this.farm = farm;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getIspublic() {
		return ispublic;
	}

	public void setIspublic(int ispublic) {
		this.ispublic = ispublic;
	}

	public int getIsfriend() {
		return isfriend;
	}

	public void setIsfriend(int isfriend) {
		this.isfriend = isfriend;
	}

	public int getIsfamily() {
		return isfamily;
	}

	public void setIsfamily(int isfamily) {
		this.isfamily = isfamily;
	}

	private int isfamily;

}
