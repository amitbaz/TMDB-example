package com.example.tmdbexample.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.widget.ContentLoadingProgressBar;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.example.tmdbexample.viewmodel.MoviesViewModel;

public abstract class ActivityMoviesBinding extends ViewDataBinding {
  @NonNull
  public final RecyclerView listOfMovies;

  @NonNull
  public final ContentLoadingProgressBar spinnerLoading;

  @Bindable
  protected MoviesViewModel mModel;

  protected ActivityMoviesBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, RecyclerView listOfMovies, ContentLoadingProgressBar spinnerLoading) {
    super(_bindingComponent, _root, _localFieldCount);
    this.listOfMovies = listOfMovies;
    this.spinnerLoading = spinnerLoading;
  }

  public abstract void setModel(@Nullable MoviesViewModel model);

  @Nullable
  public MoviesViewModel getModel() {
    return mModel;
  }

  @NonNull
  public static ActivityMoviesBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityMoviesBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityMoviesBinding>inflate(inflater, com.example.tmdbexample.R.layout.activity_movies, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityMoviesBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityMoviesBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityMoviesBinding>inflate(inflater, com.example.tmdbexample.R.layout.activity_movies, null, false, component);
  }

  public static ActivityMoviesBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ActivityMoviesBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (ActivityMoviesBinding)bind(component, view, com.example.tmdbexample.R.layout.activity_movies);
  }
}
