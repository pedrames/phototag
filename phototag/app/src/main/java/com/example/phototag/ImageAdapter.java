package com.example.phototag;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ImageViewHolder> {

    private List<ImageEntity> images = new ArrayList<>();

    // Other adapter methods...

    public void setImages(List<ImageEntity> images) {
        this.images = images;
        notifyDataSetChanged();
    }

    static class ImageViewHolder extends RecyclerView.ViewHolder {
        ImageView thumbnailImageView;

        ImageViewHolder(View itemView) {
            super(itemView);
            thumbnailImageView = itemView.findViewById(R.id.thumbnailImageView);
        }
    }

    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_image, parent, false);
        return new ImageViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder holder, int position) {
        ImageEntity image = images.get(position);

        // Load and display image thumbnail in the ImageView
        Bitmap thumbnail = BitmapFactory.decodeFile(image.getImagePath());
        holder.thumbnailImageView.setImageBitmap(thumbnail);
    }

    @Override
    public int getItemCount() {
        return images.size();
    }
}
