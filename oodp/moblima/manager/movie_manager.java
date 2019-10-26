package manager;
import objects.*;

public class movie_manager{
    private static movie[] movieListing = new movie[10];
    public static void addMovie(movie Movie){
        int i = 0;
        while (i<=9){
            if (movieListing[i] == null){
                movieListing[i] = Movie;
                break;
            }
            i++;
        }
    }
    public static movie[] getMovieListing(){
        return movieListing;
    }

}