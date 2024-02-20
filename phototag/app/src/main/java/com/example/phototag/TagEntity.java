package com.example.phototag;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

// Tag entity class
@Entity(tableName = "tags")
public class TagEntity {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private int imageId; // Foreign key to image
    private String tag;

    // Getter and setter for id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Getter and setter for imageId
    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    // Getter and setter for tag
    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    // Other methods or attributes if needed
}
