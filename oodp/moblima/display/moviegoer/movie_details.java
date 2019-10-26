package display.moviegoer;
import display.display;
import java.util.*;
import static manager.movie_manager.*;
import objects.movie;

public class movie_details extends display{
    Scanner sc = new Scanner(System.in);
    protected void start() {
        displayMenu();
    }
    private void displayMenu() {
        System.out.println("1. View movie details");
        System.out.println("2. Back. ");
        int choice = sc.nextInt();
        switch (choice) {
                case 1:
                    view_movie_details();
                case 2:
                    destroy();
        }
    }

    private void view_movie_details(){
        movie[] movieListing = new movie[10];
        movieListing = getMovieListing();
        int i = 0;
        while (i<=9){
            if (movieListing[i] != null){
                System.out.println((i+1) + ". " +movieListing[i].getTitle());
            }
            i++;
        }
        System.out.println("Enter movie number you want to view details.");
        int choice = sc.nextInt();
        System.out.println("Movie title: " + movieListing[choice-1].getTitle());
        System.out.println("Showing status: " + movieListing[choice-1].getMovieStatus());
        System.out.println("Synopsis: " + movieListing[choice-1].getSynopsis());
        System.out.println("Director: " + movieListing[choice-1].getDirector());
        System.out.print("Casts: ");
        ArrayList<String> casts =  movieListing[choice-1].getCast();
        for(String cast: casts){
            if (cast != null)
                System.out.print(cast + " ");
        }
        System.out.println(" ");
        Hashtable<String,Double> review_rating = movieListing[choice-1].getReviewRating();
        if (review_rating.isEmpty()) System.out.println("No reviews yet.");
        else System.out.println("Review and ratings: " + review_rating);
        double overall_rating = movieListing[choice-1].getOverallRating();
        if (overall_rating == 0)
            System.out.println("Overall Rating: NA");
        else
            System.out.println("Overall Rating: " + overall_rating);
        System.out.println("Movie Type: " + movieListing[choice-1].getType());
        System.out.println("Do you want to add review/rating to this movie? Y/N");
        String choice1 = sc.next();
        String review;
        double rating;
        String movie_title;
        if (choice1.compareTo("Y") == 0){
            System.out.println("Enter movie title you want to add your review.");
            movie_title = sc.next();
            System.out.println("Enter your review.");
            review = sc.next();
            System.out.println("Enter your rating. (1-5)");
            rating = sc.nextDouble();
            addMovieRating(movie_title,review,rating);
            System.out.println("Added rating successfully.");
        }
        else System.out.println("Did not add rating.");
    }
}

