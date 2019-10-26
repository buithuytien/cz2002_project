package objects;

import java.util.*;

public class movie{
    private String title;
    private String director;
    private String synopsis;
    private ArrayList<String> cast;
    private Hashtable<String,Double> review_rating = new Hashtable<String,Double>();
    private String movie_status;
    private String movie_type;
    private double overall_rating;
    public movie(){}

    public movie(String title, String director, String synopsis, ArrayList<String> cast, String moviestatus, double overall_rating, String movie_type){
        this.title = title;
        this.director = director;
        this.synopsis = synopsis;
        this.cast = cast;
        this.movie_status = moviestatus;
        this.overall_rating = overall_rating;
        this.movie_type = movie_type;
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

    public String getSynopsis(){return synopsis;}

    public void setCast(ArrayList<String> cast){
        this.cast = cast;
    }
    
    public ArrayList<String> getCast(){return cast;}

    public void setMovieStatus(String moviestatus){
        this.movie_status = moviestatus;
    }

    public String getMovieStatus(){return movie_status;}

    public void setReviewAndRating(String key, Double value){
        this.review_rating.put(key,value);
    }

    public Hashtable<String,Double> getReviewRating(){return review_rating;}

    public void setOverallRating(){
        if (review_rating.isEmpty()) return;
        else{
            double total_rating = 0;
            ArrayList<Double> all_rating = new ArrayList<>(review_rating.values());
            for (Double rating: all_rating){
                total_rating = total_rating + rating;
            }
            double avg_rating = total_rating/ all_rating.size();
            this.overall_rating = avg_rating;
        }
    }

    public double getOverallRating(){return overall_rating;}

    public void setType(String movie_type){
        this.movie_type = movie_type;
    }

    public String getType(){return movie_type;}
    
}