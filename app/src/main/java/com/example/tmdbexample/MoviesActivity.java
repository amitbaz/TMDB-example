package com.example.tmdbexample;

import android.os.Bundle;
import android.view.View;

import com.example.tmdbexample.databinding.ActivityMoviesBinding;
import com.example.tmdbexample.model.Movie;
import com.example.tmdbexample.viewmodel.MoviesViewModel;

import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

public class MoviesActivity extends AppCompatActivity {
  private MoviesViewModel viewModel;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_movies);
    setupBindings(savedInstanceState);
  }

  private void setupBindings(Bundle savedInstanceState){
    ActivityMoviesBinding activityMoviesBinding = DataBindingUtil.setContentView(this, R.layout.activity_movies);
    viewModel = ViewModelProviders.of(this).get(MoviesViewModel.class);
    if (savedInstanceState == null) {
      viewModel.init();
    }
    activityMoviesBinding.setModel(viewModel);
    setupListUpdate();
  }

  private void setupListUpdate(){
    viewModel.loading.set(View.VISIBLE);
    viewModel.fetchList();
    viewModel.getMovies().observe(this, new Observer<List<Movie>>() {
      @Override
      public void onChanged(List<Movie> movies) {
        viewModel.loading.set(View.GONE);
        if (movies.size() == 0) {
          viewModel.showEmpty.set(View.VISIBLE);
        } else {
          viewModel.showEmpty.set(View.GONE);
          viewModel.setMoviesInAdapter(movies);
        }
      }
    });
  }
}
