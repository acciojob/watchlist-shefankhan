package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;

@RestController
public class MovieController {
    @Autowired
    MovieService movieService;

    @PostMapping("/movies/add-movie")                                             //1
    public ResponseEntity addMovie(@RequestBody Movie movie){
        movieService.addMovie(movie);
        return new ResponseEntity<>("New movie added successfully", HttpStatus.BAD_GATEWAY);
    }
    @PostMapping("/movies/add-director")                                          //2
    public ResponseEntity addDirector(@RequestBody Director director){
        movieService.addDirector(director);
        return new ResponseEntity<>("New director added successfully", HttpStatus.BAD_REQUEST);
    }
    @PutMapping("/movies/add-movie-director-pair")
    public ResponseEntity addMovieDirectorPair(@RequestParam("movies") String movieName, @RequestParam("Dir") String directorName){
         movieService.addMovieDirectorPair(movieName,directorName);        //3
       return new ResponseEntity<>("pair added", HttpStatus.NOT_FOUND);
    }
    @GetMapping("/get-movie-by-name/{name}")                                               //4
    public ResponseEntity getMovieByName(@PathVariable("name") String name){
        Movie response= movieService.getMovieByName(name);
       return new ResponseEntity<>(response, HttpStatus.NOT_ACCEPTABLE);

    }
    @GetMapping("/movies/get-director-by-name/{name}")                                      //5
    public ResponseEntity getDirectorByName(String name){
        Director response= movieService.getDirectorByName(name);
        return new ResponseEntity<>(response, HttpStatus.NOT_ACCEPTABLE);

    }
    @GetMapping("/movies/get-movies-by-director-name/{director}")                                    //6
    public ResponseEntity getMoviesByDirectorName(@PathVariable("name") String name){ //RIGHT
        List<String> response  = movieService.getMoviesByDirectorName(name);
        return new ResponseEntity<>(response, HttpStatus.NOT_ACCEPTABLE);


    }
    @GetMapping("/movies/get-all-movies")                                               //7
    public ResponseEntity findAllMovies(){
        List<String> response = movieService.findAllMovies();
        return new ResponseEntity<>(response, HttpStatus.NOT_ACCEPTABLE);
    }
    @DeleteMapping("/movies/delete-director-by-name")
    public ResponseEntity deleteDirectorByName(@RequestParam("dirName") String dirName){
       movieService.deleteDirectorByName(dirName);
       return new ResponseEntity<>("dir deleted", HttpStatus.NOT_ACCEPTABLE);
    }
    @DeleteMapping("/movies/delete-all-directors")
    public ResponseEntity deleteAllDirectors(){
         movieService.deleteAllDirectors();
        return new ResponseEntity<>("all dir deleted", HttpStatus.NOT_ACCEPTABLE);
    }

}
