package com.example.tmdbexample.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.example.tmdbexample.viewmodel.MoviesViewModel;
import java.lang.Integer;

public abstract class ViewMovieBinding extends ViewDataBinding {
  @NonNull
  public final TextView txtName;

  @Bindable
  protected Integer mPosition;

  @Bindable
  protected MoviesViewModel mViewModel;

  protected ViewMovieBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, TextView txtName) {
    super(_bindingComponent, _root, _localFieldCount);
    this.txtName = txtName;
  }

  public abstract void setPosition(@Nullable Integer position);

  @Nullable
  public Integer getPosition() {
    return mPosition;
  }

  public abstract void setViewModel(@Nullable MoviesViewModel viewModel);

  @Nullable
  public MoviesViewModel getViewModel() {
    return mViewModel;
  }

  @NonNull
  public static ViewMovieBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root,
      boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ViewMovieBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root,
      boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ViewMovieBinding>inflate(inflater, com.example.tmdbexample.R.layout.view_movie, root, attachToRoot, component);
  }

  @NonNull
  public static ViewMovieBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ViewMovieBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ViewMovieBinding>inflate(inflater, com.example.tmdbexample.R.layout.view_movie, null, false, component);
  }

  public static ViewMovieBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ViewMovieBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (ViewMovieBinding)bind(component, view, com.example.tmdbexample.R.layout.view_movie);
  }
}
