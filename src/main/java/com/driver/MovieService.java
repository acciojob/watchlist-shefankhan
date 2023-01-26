package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.List;

@Service
public class MovieService {
    @Autowired
    MovieRepository movieRepository;

    public void addMovie(Movie movie){                    //1
       movieRepository.addMovie(movie);
    }
    public void addDirector(Director director) {
         movieRepository.addDirector(director);
    }                                                        //2
    public void addMovieDirectorPair(String movieName, String directorName){                 //3
        movieRepository.addMovieDirectorPair(movieName,directorName);
    }
    public Movie getMovieByName(String name){                                                   //4
        return movieRepository.getMovieByName(name);
    }
    public Director getDirectorByName(String name){                                             //5
        return movieRepository.getDirectorByName(name);
    }
    public List<String> getMoviesByDirectorName(String name){                               //6
        return movieRepository.getMoviesByDirectorName(name);
    }
    public List<String> findAllMovies(){
        return movieRepository.findAllMovies();                                                  //7
    }
    public void deleteDirectorByName(String dirName){
        movieRepository.deleteDirectorByName(dirName);                                     //8
    }
    public void deleteAllDirectors(){
        movieRepository.deleteAllDirectors();                                             //9
    }
}
