package com.example.flickr_mvvm_architectural_component.db;

import android.content.Context;

import com.example.flickr_mvvm_architectural_component.db.dao.ImageDao;
import com.example.flickr_mvvm_architectural_component.db.entity.ImageEntity;

import androidx.annotation.Nullable;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@androidx.room.Database(entities = { ImageEntity.class }, version = 1, exportSchema = false)
public abstract class Database extends RoomDatabase {

	@Nullable
	private static Database sInstance;
	private static final String DATABASE_NAME = "image-db";

	public abstract ImageDao getImagesDao();

	public static Database getInstance(final Context context) {
		if (sInstance == null) {
			synchronized (Database.class) {
				if (sInstance == null) {
					sInstance = Room.databaseBuilder(context, Database.class, DATABASE_NAME)
						.build();
				}
			}
		}
		return sInstance;
	}

}
