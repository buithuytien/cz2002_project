package display.staff;

import display.display;
import objects.showtime;
import objects.movie;

import java.util.*;
import static manager.showtime_manager.*;
import static manager.movie_manager.*;

public class showtime_listing extends display{
    Scanner sc = new Scanner(System.in);
    protected void start() {
        displayMenu();
    }
    private void displayMenu() {
        System.out.println("1. Add showtime.");
        System.out.println("2. Delete showtime");
        System.out.println("3. Update showtime ");
        System.out.println("4. Back. ");
        int choice = sc.nextInt();
        switch (choice) {
                case 1:
                    add_showtime();
                    displayMenu();

                case 2:
                    delete_showtime();
                    displayMenu();

                case 4:
                    destroy();
                    break;
        }
    }

    private void add_showtime(){
        System.out.println("Enter cineplex number(1-3). ");
        int cineplex_no = sc.nextInt();
        System.out.println("Enter cinema number(1-3). ");
        int cinema_no = sc.nextInt();
        System.out.println("Add showtime for Today, Tomorrow or Day After?");
        String showtime_date = sc.next();
        System.out.println("Input time of showtime HHMM.");
        int showtime_time = sc.nextInt();
        System.out.println("Movies in movie list:");
        movie[] movieList = new movie[10];
        movieList = getMovieListing();
        showtime Showtime = new showtime();
        for (int i =0; i<movieList.length; i ++){
            if (movieList[i] != null){
                System.out.println(movieList[i].getTitle());
            }
        }
        System.out.println("Input movie title of the movie you want to add.");
        String movie_title = sc.next();
        for (int j =0; j<movieList.length; j++){
            if (movieList[j].getTitle().compareTo(movie_title) == 0){ 
                 Showtime.setMovie(movieList[j]);
                 break;
            }

        }
        Showtime.setCineplexNo(cineplex_no);
        Showtime.setCinemaNo(cinema_no);
        Showtime.setDate(showtime_date);
        Showtime.setTime(showtime_time);
        addShowtime(Showtime);
        System.out.println("Added showtime successfully.");
    }

    private void delete_showtime(){
        System.out.println("Delete show time Today or Tomorrow?");
        String date = sc.next();
        System.out.println("Input the time of the show. HHMM ");
        int time = sc.nextInt();
        deleteShowtime(date,time);
    }
}