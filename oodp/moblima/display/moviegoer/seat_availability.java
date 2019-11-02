package display.moviegoer;

import java.util.*;
import display.display;
import objects.seat;
import objects.showtime;
import static manager.showtime_manager.*;
import objects.movie;
import static manager.movie_manager.*;
public class seat_availability extends display{
    showtime Showtime = new showtime();
    Scanner sc = new Scanner(System.in);
    protected void start() {
        displayMenu();
    }
    private void displayMenu() {
        System.out.println("1. Check availability of seats.");
        System.out.println("2. Back. ");
        int choice = sc.nextInt();
        switch (choice) {
                case 1:
                    movie[] movie_list = new movie[10];
                    movie_list = getMovieListing();
                    for (int i =0; i< movie_list.length; i ++){
                        if (movie_list[i] != null) System.out.println(movie_list[i].getTitle());
                    }
                    System.out.println("Input movie name to display its showtime.");
                    String movie_name = sc.next();
                    listShowtime(movie_name);
                    System.out.println("Movie shown Today, Tomorrow or Day After?");
                    String date = sc.next();
                    System.out.println("Input the time of the movie.");
                    int time = sc.nextInt();
                    showtime[] showtimeList = new showtime[10];
                    showtimeList = getShowtimeListing(); 
                    for (int i =0; i<showtimeList.length;i++){
                        if ((showtimeList[i].getDate().compareTo(date) == 0) && (showtimeList[i].getTime() == time) && (showtimeList[i].getMovie().getTitle().compareTo(movie_name) == 0)){
                             displaySeat(showtimeList[i].getSeatArr());
                             break;
                        }
                        if ((i == 9) && (showtimeList[i].getMovie().getTitle().compareTo(movie_name) != 0)) System.out.println("Movie is not in the movie list.");
                    }                 
                    displayMenu();

                case 2:
                    destroy();
                    break;
        }
    }


    private void displaySeat(seat[][] seats) {
        char ch = 'A';
        System.out.println("                          SCREEN                            ");
        System.out.println("   1  2  3  4  5  6  7  8     9 10 11 12 13 14 15 16");
        for (int row = 0; row <= 8; row++) {
            System.out.print(ch + " "); 
            for (int col = 0; col <= 16; col++) {
                if (seats[row][col] == null) System.out.print("   ");
                else System.out.print(seats[row][col]);
            }
            System.out.print("  " + ch); ch++;
            System.out.println();
        }
        System.out.println();
        System.out.println();
        System.out.println("                        ENTRANCE                            ");
    }

    
}
