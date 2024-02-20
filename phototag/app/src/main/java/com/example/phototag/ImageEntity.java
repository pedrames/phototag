package com.example.phototag;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

// Image entity class
@Entity(tableName = "images")
public class ImageEntity {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String imagePath; // Path to the image file

    // Getter and setter for id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Getter and setter for imagePath
    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    // Other attributes if needed
}
