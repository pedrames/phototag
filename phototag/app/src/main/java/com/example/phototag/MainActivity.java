package com.example.phototag;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_IMAGE_CAPTURE = 1;
    private ImageView thumbnailImageView;
    private Bitmap capturedImage;
    private Button tagButton;
    private Button saveButton;
    private Button loadButton;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        thumbnailImageView = findViewById(R.id.thumbnailImageView);
        tagButton = findViewById(R.id.tagButton);
        saveButton = findViewById(R.id.saveButton);
        loadButton = findViewById(R.id.loadButton);

        Button captureButton = findViewById(R.id.captureButton);
        captureButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dispatchTakePictureIntent();
            }
        });

        tagButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tagImage();
            }
        });

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveImage();
            }
        });

        loadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadImages();
            }
        });
    }

    private void dispatchTakePictureIntent() {
        Log.d("MyApp", "dispatchTakePictureIntent: Starting picture intent"); // Log to check if the method is called
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        } else {
            Log.e("MyApp", "dispatchTakePictureIntent: No activity to handle picture intent");
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_IMAGE_CAPTURE) {
            if (resultCode == RESULT_OK) {
                Log.d("MyApp", "onActivityResult: Image captured successfully"); // Log to check if image capture is successful

                Bundle extras = data.getExtras();
                if (extras != null) {
                    capturedImage = (Bitmap) extras.get("data");
                    if (capturedImage != null) {
                        thumbnailImageView.setImageBitmap(capturedImage);
                        Log.d("MyApp", "onActivityResult: Set captured image to thumbnailImageView");
                    } else {
                        Log.e("MyApp", "onActivityResult: Captured image is null");
                    }
                } else {
                    Log.e("MyApp", "onActivityResult: Extras are null");
                }
            } else {
                Log.e("MyApp", "onActivityResult: Image capture failed with resultCode " + resultCode);
            }
        }
    }


    private void tagImage() {
        // Logic for tagging the image
        // Implement your tagging functionality here
    }

    private void saveImage() {
        // Logic for saving the image
        // Implement your saving functionality here
    }

    private void loadImages() {
        // Logic for loading images
        // Implement your loading functionality here
    }
}
