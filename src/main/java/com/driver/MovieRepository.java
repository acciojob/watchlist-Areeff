package com.driver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MovieRepository {
    HashMap<String,Movie>moviedata=new HashMap<>();
    HashMap<String,Director>directordata=new HashMap<>();
    HashMap<String,String>movieDirectorPair=new HashMap<>();

    public void addMovie(Movie movie) {
       moviedata.put(movie.getName(),movie);
    }

    public void addDirector(Director director) {
        directordata.put(director.getName(), director);
    }

    public List<Movie> getAllMovies() {
         return new ArrayList<>(moviedata.values());
    }

    public List<Director> getlistOfDirectors() {
        return new ArrayList<>(directordata.values());
    }
}
