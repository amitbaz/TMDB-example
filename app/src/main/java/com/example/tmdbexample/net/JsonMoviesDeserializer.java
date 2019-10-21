package com.example.tmdbexample.net;

import android.util.Log;

import com.example.tmdbexample.model.Movie;
import com.example.tmdbexample.model.Movies;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.Map;

public class JsonMoviesDeserializer implements JsonDeserializer<Movies> {
  @Override
  public Movies deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
    Movies movies = new Movies();
    if(json.isJsonObject()){
      for(Map.Entry<String, JsonElement> entry : json.getAsJsonObject().entrySet()){
        if(entry.getKey().equals("results")){
          Log.d("Test", "Object: key: " + entry.getKey() + " = " + entry.getValue());
           JsonArray jsonArray = entry.getValue().getAsJsonArray();
           Iterator<JsonElement> it = jsonArray.iterator();
           while(it.hasNext()){
             JsonElement el = it.next();
             Movie movie = new Movie();
             movie.setName(el.getAsJsonObject().get("title").getAsString());
             movie.setDescription(el.getAsJsonObject().get("overview").getAsString());
             movie.setPosterImagePath(el.getAsJsonObject().get("poster_path").getAsString().substring(1));
             movie.setReleaseDate(el.getAsJsonObject().get("release_date").getAsString());
             movie.setRating(el.getAsJsonObject().get("vote_average").getAsDouble());
             movies.addMovie(movie);
           }
        }
      }
    }
    return movies;
  }
}
