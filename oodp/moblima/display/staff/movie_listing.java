package display.staff;
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
        System.out.println("1. Add movie into list.");
        System.out.println("2. Remove movie from list.");
        System.out.println("3. Update movie ");
        System.out.println("4. Back. ");
        int choice = sc.nextInt();
        switch (choice) {
                case 1:
                    add_movie_list();
                    displayMenu();

                case 2:
                    System.out.println("Input movie title you want to delete.");
                    String movie_title;
                    movie_title = sc.next();
                    removeMovie(movie_title);
                    System.out.println("Removed movie successfully.");

                case 3:
                    update_movie_list();
                    displayMenu();

                case 4:
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
        System.out.println("Added movie successfully.");
    }
    
    private void update_movie_list(){
        String movie_title1,new_movie_title1,synopsis1,direct1,movie_status1;
        ArrayList<String> cast = new ArrayList<>();
        System.out.println("Enter movie title you want to update.");
        movie_title1 = sc.next();
        System.out.println("Enter new movie title.");
        new_movie_title1 = sc.next();
        System.out.println("Enter new synopsis.");
        synopsis1 = sc.next();
        System.out.println("Enter new director.");
        direct1 = sc.next();
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
        ArrayList<String> cast1 = new ArrayList<>();
        for (int i =0; i<inputcast.length; i++){
            cast1.add(inputcast[i]);
        }
        System.out.println("Enter new movie status.");
        movie_status1 = sc.next();
        movie Movie1 = new movie();
        Movie1.setTitle(movie_title1);
        Movie1.setDirector(direct1);
        Movie1.setSynopsis(synopsis1);
        Movie1.setCast(cast1);
        Movie1.setMovieStatus(movie_status1);
        updateMovieListing(Movie1);
        System.out.println("Updated movie successfully.");
    }
}