package com.example.flickrexample.db;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.flickrexample.db.dao.SearchImageDao;
import com.example.flickrexample.db.entity.SearchImageEntity;

@androidx.room.Database(entities = { SearchImageEntity.class}, version = 2)
public abstract class Database extends RoomDatabase {

    @Nullable
    private static Database sInstance;
    private static final String DATABASE_NAME = "search-images-db";

    public abstract SearchImageDao searchImageDao();

    public static Database getInstance(final Context context) {
        if (sInstance == null) {
            synchronized (Database.class) {
                if (sInstance == null) {
                    sInstance = Room.databaseBuilder(context, Database.class, DATABASE_NAME).build();
                }
            }
        }
        return sInstance;
    }

}
