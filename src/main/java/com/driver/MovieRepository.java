package com.driver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MovieRepository {
    private HashMap<String,Movie>moviedata=new HashMap<>();
   private  HashMap<String,Director>directordata=new HashMap<>();
   private  HashMap<String,List<String>>movieDirectorPair=new HashMap<>();




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
    public Movie findMovie(String movieName){
        return moviedata.get(movieName);
    }
    public Director findDirector(String directorName){
        return directordata.get(directorName);
    }

    public void addMovieDirectorPair(String movieName, String directorName) {
        List<String> addPair=new ArrayList<>();
        if(movieDirectorPair.containsKey(directorName)){
            addPair=movieDirectorPair.get(directorName);
            addPair.add(movieName);
        }
        movieDirectorPair.put(directorName,addPair);
    }

    public List<String> getMoviesbyDirectorName(String director) {
//        List<String> movies=new ArrayList<>();
//        if(movieDirectorPair.containsKey(director)) movies=movieDirectorPair.get(director);
//        return movies;
        return new ArrayList<>(movieDirectorPair.get(director));
    }

    public List<String> getAllMovieNames() {
        return new ArrayList<>(moviedata.keySet());
    }

    public void removeDirector(String direcor) {
        directordata.remove(direcor);
        movieDirectorPair.remove(direcor);
    }

    public void removeMovie(String movieName) {
        moviedata.remove(movieName);
    }

    public List<String> getlistOfDirectorsName() {
        return new ArrayList<>(directordata.keySet());
    }
}
