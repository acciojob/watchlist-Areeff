package com.driver;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
//    @PostMapping("/add-movie-director-pair")
//    public ResponseEntity<String >addMovieDirectorPair(@RequestParam String movieName,@RequestParam String directorName){
//        Strring str=movieService.addMovieDirectorPair(movieName,directorName);
//        return new ResponseEntity<>(str,HttpStatus.CREATED);
//    }
    @GetMapping("/get-movie-by-name/{name}")
    public ResponseEntity<Movie> getMovieByName(@PathVariable String movieName){
        try{
            Movie movie=movieService.getMovieByName(movieName);
            return new ResponseEntity<>(movie,HttpStatus.OK);
        }catch (movieNotFoundExcepion ex){
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/get-director-by-name/{name}")
    public  ResponseEntity<Director>getDirectorByName(@PathVariable String name){
        try{
            Director directorname=movieService.getDirectorByName(name);
            return  new ResponseEntity<>(directorname,HttpStatus.OK);
        }catch(DirectorNotFoundException ex){
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }

    }
}
