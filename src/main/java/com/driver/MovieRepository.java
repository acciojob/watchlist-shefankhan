package com.driver;

import org.springframework.stereotype.Repository;

import java.util.*;

//import java.util.Objects;
@Repository
public class MovieRepository {

    Map<String,Movie> db;    //movies
    Map<String,Director> db1; //director

    Map<String,List<String>> db3;   // pair (director name, movies)

    // ArrayList<String> list = new ArrayList<>();  // list of all movies


    public MovieRepository() {
        this.db = new HashMap<String, Movie>();
        this.db1 = new HashMap<String, Director>();
        this.db3 = new HashMap<String, List<String>>();
    }

    public void addMovie(Movie movie){         //1
        String name=movie.getName();
        // list.add(name);
        db.put(name,movie);

    }
    public void addDirector(Director director){    //2
        String name=director.getName();

        db1.put(name,director);


    }
    public void addMovieDirectorPair(String movieName, String directorName){    //3
        if(db.containsKey(movieName) && db1.containsKey(directorName)){
            List<String> currMovie =new ArrayList<>();

           if(db3.containsKey(directorName)){
               currMovie = db3.get(directorName);
               currMovie.add(movieName);
               db3.put(directorName,currMovie);

           }

        }

    }
    public Movie getMovieByName(String name){     //4
        return db.get(name);
    }
    public Director getDirectorByName(String name){  //5
        return db1.get(name);
    }

    public List<String> getMoviesByDirectorName(String name){       //6
        List<String> movieList = new ArrayList<>();
        if(db3.containsKey(name)){
            movieList = db3.get(name);
        }
        return movieList;

    }


   /* public ArrayList<String> helperDir(String dirN){
        ArrayList<String> temp=  new ArrayList<>();
        for (Map.Entry<String,String> mapElement : db3.entrySet()){
            String name= mapElement.getKey();
            String directorName= mapElement.getValue();
            if(dirN.equals(directorName)){
                temp.add(name);
            }
        }
        return temp;

    }  */

public List<String> findAllMovies(){           //name of all movie  //7
        return new ArrayList<>(db.keySet());                                 //
}
 public void deleteDirectorByName(String director){      //8
     List<String> movies = new ArrayList<String>();
     if(db3.containsKey(director)){
         //1. Find the movie names by director from the pair
         movies = db3.get(director);

         //2. Deleting all the movies from movieDb by using movieName
         for(String movie: movies){
             if(db.containsKey(movie)){
                 db.remove(movie);
             }
         }

         //3. Deleteing the pair
         db.remove(director);
     }

     //4. Delete the director from directorDb.
     if(db1.containsKey(director)){
         db1.remove(director);
     }


    /* for (Map.Entry<String,String> mapElement : db3.entrySet()){
         String directorName= mapElement.getValue();
         String name= mapElement.getKey();
         if(directorName.equals(dirName)){
             db3.remove(name);
         }

     }
     db1.remove(dirName);
     return "success"; */
 }
 public void deleteAllDirectors(){                                    //9

    /* for (Map.Entry<String,String> mapElement : db3.entrySet()){
        // String directorName= mapElement.getValue();
         String name= mapElement.getKey();
         list.remove(name);
     }
     db1.clear();
     return "success"; */
     HashSet<String> moviesSet = new HashSet<String>();

     //Deleting the director's map
     db1 = new HashMap<>();

     //Finding out all the movies by all the directors combined
     for(String director: db3.keySet()){

         //Iterating in the list of movies by a director.
         for(String movie: db3.get(director)){
             moviesSet.add(movie);
         }
     }

     //Deleting the movie from the movieDb.
     for(String movie: moviesSet){
         if(db.containsKey(movie)){
             db.remove(movie);
         }
     }
     //clearing the pair.
     db3 = new HashMap<>();


 }


}
