package display;

import java.util.*;

import display.moviegoer.movie_listing;

public class display_mg extends display {
        Scanner sc = new Scanner(System.in);
        protected void start() {
            System.out.println("==== MG ====");
            System.out.println("1. Search/List Movies.");
            System.out.println("2. View movie details.");
            System.out.println("3. Check seat availability and selection of seats.");
            System.out.println("4. Book and purchase ticket.");
            System.out.println("5. View booking history.");
            System.out.println("6. List the Top 5 ranking by ticket sales OR by overall viewer ratings.");
            System.out.println("7. Return back to previous page");
    
            int choice = sc.nextInt();
            
            switch (choice) {
                case 1:
                    intent(this, new movie_listing());
                    
                case 7:
                    destroy();
                    break;
            }
        }


}