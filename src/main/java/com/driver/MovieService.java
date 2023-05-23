package com.driver;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class MovieService {
    MovieRepository movieRepository=new MovieRepository();
    public String addMovie(Movie movie) {
        movieRepository.addMovie(movie);
        return "Movie added sucessfully "+movie.getName();
    }

    public String addDirector(Director director) {
        movieRepository.addDirector(director);
        return "Director added Sucessfully "+director.getName();
    }

    public Movie getMovieByName(String movieName) {
        List<Movie> moviesList=movieRepository.getAllMovies();
        for( Movie MovieName :moviesList){
            if(MovieName.getName().equals(movieName)){
                return MovieName;
            }
        }
        throw new movieNotFoundExcepion();
    }

    public Director getDirectorByName(String directorName) {
        List<Director> list=movieRepository.getlistOfDirectors();
        for(Director DirectorName:list){
            if(DirectorName.getName().equals(directorName)){
                return DirectorName;
            }
        }
        throw new DirectorNotFoundException();
    }


    public String addMovieDirectorPair(String movieName, String directorName) {
        Optional<Movie> movie=movieRepository.getMovie(movieName);
        Optional<Director> director=movieRepository.getDirector(directorName);
        if(movie.isEmpty()){
            throw new movieNotFoundExcepion();
        }
        if(director.isEmpty()){
            throw new DirectorNotFoundException();
        }
        movieRepository.addMovieDirectorPair(movieName,directorName);
        return "Added Pair successfully";
    }

    public List<String> getMoviesByDirectorName(String director) {
        List<String> movieslist=movieRepository.getMoviesbyDirectorName(director);
        return movieslist;
    }

    public List<String> getAllMovies() {
        List<String>allMovies=movieRepository.getAllMovieNames();
        return allMovies;
    }

    public String deletedirector(String direcor) {
        List<String> movieslist=movieRepository.getMoviesbyDirectorName(direcor);
        movieRepository.removeDirector(direcor);
        for(String movieName:movieslist){
            movieRepository.removeMovie(movieName);
        }
        return "director data deleted";
    }

    public String deleteAlldirector() {
        List<String> directorsList=movieRepository.getlistOfDirectorsName();
        for(String directorName:directorsList){
            deletedirector(directorName);
        }
        return "data deleted successfully";
    }
}
