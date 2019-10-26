package objects;

import java.util.*;

public class movie{
    private String title;
    private String director;
    private String synopsis;
    private ArrayList<String> cast;
    private String movie_status;
    public movie(){}

    public movie(String title, String director, String synopsis, ArrayList<String> cast, String moviestatus){
        this.title = title;
        this.director = director;
        this.synopsis = synopsis;
        this.cast = cast;
        this.movie_status = moviestatus;
    }
    public void setTitle(String title){
        this.title = title;
    }

    public String getTitle(){return title;}

    public void setDirector(String director){
        this.director = director;
    }

    public String getDirector(){return director;}

    public void setSynopsis(String synopsis){
        this.synopsis = synopsis;
    }

    public String getSynopsis(String synopsis){return synopsis;}

    public void setCast(ArrayList<String> cast){
        this.cast = cast;
    }

    public void setMovieStatus(String moviestatus){
        this.movie_status = moviestatus;
    }
    
}