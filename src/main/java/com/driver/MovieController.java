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
        String response= movieService.addMovie(movie);
        return new ResponseEntity<>(response, HttpStatus.BAD_GATEWAY);
    }
    @PostMapping("/movies/add-director")                                          //2
    public ResponseEntity addDirector(@RequestBody Director director){
        String response=  movieService.addDirector(director);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
    @PutMapping("/movies/add-movie-director-pair")
    public ResponseEntity addMovieDirectorPair(@RequestParam("movies") String movieName, @RequestParam("Dir") String directorName){
        String response=  movieService.addMovieDirectorPair(movieName,directorName);        //3
       return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
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
        String response = movieService.deleteDirectorByName(dirName);
       return new ResponseEntity<>(response, HttpStatus.NOT_ACCEPTABLE);
    }
    @DeleteMapping("/movies/delete-all-directors")
    public ResponseEntity deleteAllDirectors(){
        String response= movieService.deleteAllDirectors();
        return new ResponseEntity<>(response, HttpStatus.NOT_ACCEPTABLE);
    }

}
