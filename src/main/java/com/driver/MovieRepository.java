package com.driver;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
//import java.util.Objects;
@Service
public class MovieRepository {

    Map<String,Movie> db=new HashMap<>();    //movies
    Map<String,Director> db1=new HashMap<>(); //director

    Map<String,String> db3 =new HashMap<>();   // pair (movie , director)

    ArrayList<String> list = new ArrayList<>();  // list of all movies




    public String addMovie(Movie movie){         //1
        String name=movie.getName();
        list.add(name);
        db.put(name,movie);
        return "success";
    }
    public String addDirector(Director director){    //2
        String name=director.getName();

        db1.put(name,director);
        return "success";

    }
    public String addMovieDirectorPair(String movieName, String directorName){    //3
        if(db.containsKey(movieName) && db1.containsKey(directorName)){
           db3.put(movieName,directorName);
            return "success";
        }
         return "invalid";
    }
    public Movie getMovieByName(String name){     //4
        return db.get(name);
    }
    public Director getDirectorByName(String name){  //5
        return db1.get(name);
    }

    public ArrayList<String> getMoviesByDirectorName(String name){       //6
        return helperDir(name);

    }


    public ArrayList<String> helperDir(String dirN){
        ArrayList<String> temp=  new ArrayList<>();
        for (Map.Entry<String,String> mapElement : db3.entrySet()){
            String name= mapElement.getKey();
            String directorName= mapElement.getValue();
            if(dirN.equals(directorName)){
                temp.add(name);
            }
        }
        return temp;

    }

public ArrayList<String> findAllMovies(){           //name of all movie  //7
        return list;
}
 public String deleteDirectorByName(String dirName){                          //8
     for (Map.Entry<String,String> mapElement : db3.entrySet()){
         String directorName= mapElement.getValue();
         String name= mapElement.getKey();
         if(directorName.equals(dirName)){
             db3.remove(name);
         }
         db1.remove(dirName);
     }
     return "success";
 }
 public String deleteAllDirectors(){                                    //9
     db1.clear();
     for (Map.Entry<String,String> mapElement : db3.entrySet()){
        // String directorName= mapElement.getValue();
         String name= mapElement.getKey();
         list.remove(name);
     }
     return "success";


 }


}
