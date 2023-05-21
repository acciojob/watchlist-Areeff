package com.driver;

import java.util.List;

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
}
