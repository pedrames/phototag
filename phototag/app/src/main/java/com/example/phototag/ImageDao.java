package com.example.phototag;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ImageDao {
    @Insert
    void insertImage(ImageEntity image);

    @Insert
    void insertTag(TagEntity tag);

    @Query("SELECT * FROM images WHERE id = :imageId")
    LiveData<ImageEntity> getImageById(int imageId);

    @Query("SELECT * FROM tags WHERE tag = :tag")
    LiveData<List<TagEntity>> getImagesByTag(String tag);
    // Other necessary queries
}
