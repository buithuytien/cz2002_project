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
    public static void removeMovie(String movie_title){
        int i = 0;
        String movie1;
        while (i<=9){
            movie1 = movieListing[i].getTitle();
            if (movie1.compareTo(movie_title) == 0){
                movieListing[i].setMovieStatus("End of Showing.");
                break;
            }
        }
    }
    public static void addMovieRating(String movie_title, String review, double rating){
            int i = 0;
            String movie1;
            while (i<=9){
                movie1 = movieListing[i].getTitle();
                if (movie1.compareTo(movie_title) == 0){
                    movieListing[i].setReviewAndRating(review,rating);
                    break;
                }
            }
            movieListing[i].setOverallRating();
    }
    public static movie[] getMovieListing(){
        return movieListing;
    }

    public static void updateMovieListing(String movie_title, movie Movie){
            int i = 0;
            String movie1;
            while (i<=9){
                movie1 = movieListing[i].getTitle();
                if (movie1.compareTo(movie_title) == 0){
                    movieListing[i] = Movie;
                    break;
                }
            }
    }

}