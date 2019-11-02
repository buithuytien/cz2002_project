package display.moviegoer;

import java.util.*;
import display.display;
import objects.movie;
import objects.seat;
import objects.showtime;
import static manager.showtime_manager.*;
import static manager.movie_manager.*;

public class booking extends display{
    showtime Showtime = new showtime();
    Scanner sc = new Scanner(System.in);
    protected void start() {
        displayMenu();
    }
    private void displayMenu() {
        System.out.println("1. Book movie tickets. ");
        System.out.println("2. Back. ");
        int choice = sc.nextInt();
        switch (choice) {
                case 1:
                    displayBookSeatMenu();                
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

    private void displayBookSeatMenu(){
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
            if ((showtimeList[i].getDate().compareTo(date) == 0) && (showtimeList[i].getTime() == time)){
                 displaySeat(showtimeList[i].getSeatArr());
                 System.out.println("Input row number.");
                 int row = sc.nextInt();
                 System.out.println("Input col number.");
                 int col = sc.nextInt();
                 showtimeList[i].Book(row,col);
                 System.out.println("Booking successful!");
                 break;
            }
        }
    }
}
