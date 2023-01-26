package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.List;

@Service
public class MovieService {
    @Autowired
    MovieRepository movieRepository;

    public String addMovie(Movie movie){                    //1
       return movieRepository.addMovie(movie);
    }
    public String addDirector(Director director) {
        return movieRepository.addDirector(director);
    }                                                        //2
    public String addMovieDirectorPair(String movieName, String directorName){                 //3
        return movieRepository.addMovieDirectorPair(movieName,directorName);
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
    public String deleteDirectorByName(String dirName){
        return movieRepository.deleteDirectorByName(dirName);                                     //8
    }
    public String deleteAllDirectors(){
        return movieRepository.deleteAllDirectors();                                             //9
    }
}
