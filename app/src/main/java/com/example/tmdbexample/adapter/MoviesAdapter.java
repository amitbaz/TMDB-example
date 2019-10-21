package com.example.tmdbexample.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.tmdbexample.BR;
import com.example.tmdbexample.model.Movie;
import com.example.tmdbexample.viewmodel.MoviesViewModel;

import java.util.List;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.GenericViewHolder> {

  private int layoutId;
  private List<Movie> movies;
  private MoviesViewModel viewModel;

  public MoviesAdapter(@LayoutRes int layoutId, MoviesViewModel viewModel){
    this.layoutId = layoutId;
    this.viewModel = viewModel;
  }

  private int getLayoutIdForPosition(int position) {
    return layoutId;
  }

  @NonNull
  @Override
  public GenericViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
    ViewDataBinding binding = DataBindingUtil.inflate(layoutInflater, viewType, parent, false);

    return new GenericViewHolder(binding);
  }

  @Override
  public void onBindViewHolder(@NonNull GenericViewHolder holder, int position) {
    holder.bind(viewModel, position);
  }

  public void setMovies(List<Movie> movies) {
    this.movies = movies;
  }

  @Override
  public int getItemCount() {
    return movies == null ? 0 : movies.size();
  }

  @Override
  public int getItemViewType(int position) {
    return getLayoutIdForPosition(position);
  }

  class GenericViewHolder extends RecyclerView.ViewHolder{
    final ViewDataBinding binding;

    public GenericViewHolder(ViewDataBinding binding) {
      super(binding.getRoot());
      this.binding = binding;
    }

    void bind(MoviesViewModel viewModel, Integer position) {
      viewModel.fetchMovieImageAt(position);
      binding.setVariable(BR.viewModel, viewModel);
      binding.setVariable(BR.position, position);
      binding.executePendingBindings();
    }

  }
}
