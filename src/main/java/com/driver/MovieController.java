package com.driver;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {
    MovieService movieService=new MovieService();
    @PostMapping("/add-movie")
    public ResponseEntity<String> addMovie(@RequestBody Movie movie){
       String str= movieService.addMovie(movie);
       return new ResponseEntity<>(str, HttpStatus.CREATED);
    }
    @PostMapping("/add-director")
    public ResponseEntity<String> addDirector(@RequestBody Director director){
        String str=movieService.addDirector(director);
        return new ResponseEntity<>(str,HttpStatus.CREATED);
    }
    @PostMapping("/add-movie-director-pair")
    public ResponseEntity<String >addMovieDirectorPair(@RequestParam String movieName,@RequestParam String directorName){
        String str=movieService.addMovieDirectorPair(movieName,directorName);
        return new ResponseEntity<>(str,HttpStatus.CREATED);
    }
    @GetMapping("/get-movie-by-name/{name}")
    public ResponseEntity<Movie> getMovieByName(@PathVariable String name){
        try{
            Movie movie=movieService.getMovieByName(name);
            return new ResponseEntity<>(movie,HttpStatus.OK);
        }catch (movieNotFoundExcepion ex){
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/get-director-by-name/{name}")
    public  ResponseEntity<Director>getDirectorByName(@PathVariable String name){
        try{
            Director directorname =movieService.getDirectorByName(name);
            return  new ResponseEntity<>(directorname,HttpStatus.OK);
        }catch(DirectorNotFoundException ex){
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/get-movies-by-director-name/{director}")
    public ResponseEntity<List<String>> getMoviesByDirectorName(@PathVariable String director){
            List<String> moviesList=movieService.getMoviesByDirectorName(director);
            return new ResponseEntity<>(moviesList,HttpStatus.OK);
    }
    @GetMapping("/get-all-movies")
    public ResponseEntity<List<String>>findAllMovies(){
        List<String>Allmovies=movieService.getAllMovies();
        return new ResponseEntity<>(Allmovies,HttpStatus.OK);
    }
    @DeleteMapping("/delete-director-by-name")
    public ResponseEntity<String>deleteDirectorByName(@RequestParam String director){
        String str=movieService.deletedirector(director);
        return new ResponseEntity<>(str,HttpStatus.OK);
    }
    @DeleteMapping("/delete-all-directors")
    public ResponseEntity<String>deleteAllDirectors(){
        String str=movieService.deleteAlldirector();
        return new ResponseEntity<>(str,HttpStatus.OK);
    }
}
