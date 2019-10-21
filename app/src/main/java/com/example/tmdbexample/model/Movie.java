package com.example.tmdbexample.model;

import com.example.tmdbexample.net.Api;

import androidx.databinding.BaseObservable;
import retrofit2.Callback;

public class Movie extends BaseObservable {

  private String name;
  private double rating;
  private String releaseDate;
  private String posterImagePath;
  private String description;

  public String getName(){
    return name;
  }

  public void setName(String name){
    this.name = name;
  }

  public double getRating() {
    return rating;
  }

  public void setRating(double rating) {
    this.rating = rating;
  }

  public String getReleaseDate() {
    return releaseDate;
  }

  public void setReleaseDate(String releaseDate) {
    this.releaseDate = releaseDate;
  }

  public String getPosterImagePath() {
    return posterImagePath;
  }

  public void setPosterImagePath(String posterImagePath) {
    this.posterImagePath = posterImagePath;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }
}
