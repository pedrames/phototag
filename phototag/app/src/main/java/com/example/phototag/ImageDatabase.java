package com.example.phototag;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {ImageEntity.class, TagEntity.class}, version = 1)
public abstract class ImageDatabase extends RoomDatabase {
    private static ImageDatabase instance;

    public abstract ImageDao imageDao();

    public static synchronized ImageDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                            ImageDatabase.class, "image_database")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }
}
