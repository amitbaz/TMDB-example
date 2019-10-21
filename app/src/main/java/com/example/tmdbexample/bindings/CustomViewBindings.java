package com.example.tmdbexample.bindings;


import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.tmdbexample.R;

import java.io.InputStream;

import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class CustomViewBindings {
  @BindingAdapter("setAdapter")
  public static void bindRecyclerViewAdapter(RecyclerView recyclerView, RecyclerView.Adapter<?> adapter) {
    recyclerView.setHasFixedSize(true);
    recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
    recyclerView.setAdapter(adapter);
  }

  @BindingAdapter("imageUrl")
  public static void bindRecyclerViewAdapter(ImageView imageView, String imageUrl) {
    if (imageUrl != null) {
      if (imageView.getTag(R.id.image_url) == null || !imageView.getTag(R.id.image_url).equals(imageUrl)) {
        imageView.setImageBitmap(null);
        imageView.setTag(R.id.image_url, imageUrl);
        Glide.with(imageView).load(imageUrl).into(imageView);
      }
    } else {
      imageView.setTag(R.id.image_url, null);
      imageView.setImageBitmap(null);
    }
  }
}
