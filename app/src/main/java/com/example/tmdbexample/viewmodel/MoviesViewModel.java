package com.example.tmdbexample.viewmodel;

import android.app.Application;
import android.view.View;

import com.example.tmdbexample.R;
import com.example.tmdbexample.adapter.MoviesAdapter;
import com.example.tmdbexample.model.Movie;
import com.example.tmdbexample.model.Movies;
import com.example.tmdbexample.net.Api;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableArrayMap;
import androidx.databinding.ObservableInt;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

public class MoviesViewModel extends AndroidViewModel {

  private Movies movies;
  private MoviesAdapter adapter;
  public ObservableArrayMap<String, String> images;
  public ObservableInt loading;
  public ObservableInt showEmpty;

  public MoviesViewModel(@NonNull Application application) {
    super(application);
  }

  public void init(){
    movies = new Movies();
    adapter = new MoviesAdapter(R.layout.view_movie, this);
    images = new ObservableArrayMap<>();
    loading = new ObservableInt(View.GONE);
    showEmpty = new ObservableInt(View.GONE);
  }

  public void fetchList(){
    movies.fetchList(getApplication().getResources().getString(R.string.API_KEY));
  }

  public MoviesAdapter getAdapter() {
    return adapter;
  }

  public MutableLiveData<List<Movie>> getMovies() {
    return movies.getMovies();
  }

  public void setMoviesInAdapter(List<Movie> movies) {
    this.adapter.setMovies(movies);
    this.adapter.notifyDataSetChanged();
  }

  public Movie getMovieAt(Integer index) {
    if (movies.getMovies().getValue() != null &&
      index != null &&
      movies.getMovies().getValue().size() > index) {
      return movies.getMovies().getValue().get(index);
    }
    return null;
  }

  public void fetchMovieImageAt(Integer index) {
    Movie movie = getMovieAt(index);
    if (movie != null && !images.containsKey(movie.getName())) {
      images.put(movie.getName(), Api.getMovieBaseUrl().concat(movie.getPosterImagePath()));
    }
  }

}
