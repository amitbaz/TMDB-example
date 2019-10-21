package com.example.tmdbexample.model;


import android.util.Log;

import com.example.tmdbexample.R;
import com.example.tmdbexample.net.Api;

import java.util.ArrayList;
import java.util.List;

import androidx.databinding.BaseObservable;
import androidx.lifecycle.MutableLiveData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Movies extends BaseObservable {

  private String status;
  private List<Movie> moviesList = new ArrayList<Movie>();
  private MutableLiveData<List<Movie>> movies = new MutableLiveData<>();


  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public void addMovie(Movie movie){
    moviesList.add(movie);
  }

  public MutableLiveData<List<Movie>> getMovies(){
    return movies;
  }

  public void fetchList(String API_KEY){
    Callback<Movies> callback = new Callback<Movies>() {
      @Override
      public void onResponse(Call<Movies> call, Response<Movies> response) {
        Movies body = response.body();
        Log.d("body content", body.toString());
        movies.setValue(body.moviesList);
      }

      @Override
      public void onFailure(Call<Movies> call, Throwable t) {
        Log.e("Test", t.getMessage(), t);
      }
    };
    Api.getApi().getMovies(API_KEY).enqueue(callback);
  }
}
