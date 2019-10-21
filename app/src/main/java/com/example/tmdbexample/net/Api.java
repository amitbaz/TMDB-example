package com.example.tmdbexample.net;

import com.example.tmdbexample.R;
import com.example.tmdbexample.model.MovieImage;
import com.example.tmdbexample.model.Movies;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Streaming;

public class Api {
  private static ApiInterface api;
  private static final String BASE_URL = "https://api.themoviedb.org";
  private static final String MOVIE_BASE_URL = "http://image.tmdb.org/t/p/original/";

  public static String getMovieBaseUrl() {
    return MOVIE_BASE_URL;
  }

  public static ApiInterface getApi(){
    if(api == null){
      HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
      logging.setLevel(HttpLoggingInterceptor.Level.BASIC);
      OkHttpClient client = new OkHttpClient.Builder()
        .addInterceptor(logging)
        .build();
      Gson gson = new GsonBuilder()
        .registerTypeAdapter(
          Movies.class,
          new JsonMoviesDeserializer()
        )
        .create();

      Retrofit retrofit = new Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(client)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build();

      api = retrofit.create(ApiInterface.class);
    }
    return api;
  }

  public interface ApiInterface{
    @GET("/3/discover/movie")
    Call<Movies> getMovies(@Query("api_key") String api_key);

  }
}
