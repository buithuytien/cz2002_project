package display.moviegoer;
import display.display;
import java.util.*;
import static manager.movie_manager.*;
import objects.movie;

public class movie_listing extends display{
    Scanner sc = new Scanner(System.in);
    protected void start() {
        displayMenu();
    }
    private void displayMenu() {
        System.out.println("1. Search movie.");
        System.out.println("2. List movies. ");
        System.out.println("3. Back. ");
        int choice = sc.nextInt();
        switch (choice) {
                case 2:
                    display_movie_list();
                case 3:
                    destroy();
        }
    }

    private void display_movie_list() {
        movie[] movieListing = new movie[10];
        movieListing = getMovieListing();
        int i = 0;
        while (i<=9){
            if (movieListing[i] != null){
                System.out.println(movieListing[i].getTitle());
            }
            i++;
        }
    }
    
}