package display.staff;
import java.io.IOException;
import display.display;
import objects.movie;
import java.util.*;
import static manager.movie_manager.*;

public class movie_listing extends display{
    Scanner sc = new Scanner(System.in);
    protected void start() {
        displayMenu();
    }
    private void displayMenu() {
        System.out.println("1. Create movie list.");
        System.out.println("2. Back. ");
        int choice = sc.nextInt();
        switch (choice) {
                case 1:
                    add_movie_list();
                    displayMenu();

                case 2:
                    destroy();
                    break;
        }
    }

    private void add_movie_list() {
        System.out.println("Adding movie...");
        System.out.println("Enter movie title:");
        String title = sc.next();
        System.out.println("Enter movie synopsis.");
        String synopsis = sc.next();
        System.out.println("Enter director:");
        String director = sc.next();
        String[] inputcast = new String[10];
        int cast_size = 0;
        String add_choice;
        do{ 
            System.out.println("Entering casts...");
            String input_cast = sc.next();
            inputcast[cast_size] = input_cast;
            cast_size++;
            System.out.println("Still want to add? Y/N");
            add_choice = sc.next();
        }while (add_choice.compareTo("Y") == 0);
        ArrayList<String> cast = new ArrayList<>();
        for (int i =0; i<inputcast.length; i++){
            cast.add(inputcast[i]);
        }
  
        System.out.println("Enter movie status:");
        String movie_status = sc.next();
        movie Movie = new movie();
        Movie.setTitle(title);
        Movie.setDirector(director);
        Movie.setSynopsis(synopsis);
        Movie.setCast(cast);
        Movie.setMovieStatus(movie_status);
        addMovie(Movie);
    }
    
}