package display;

import java.util.*;

import display.staff.movie_listing;
import display.staff.showtime_listing;

public class display_staff extends display {
    Scanner sc = new Scanner(System.in);
    private boolean login_status;

    public display_staff(){
        login_status = false;
    }

    protected void start(){
        while (!login_status) login();
        display_staff_menu();
    }

    private void login() {

        System.out.println("Please login");
        System.out.println("input username");
        String username = sc.next();
        System.out.println("input password");
        String password = sc.next();
        if (username.compareTo("user") == 0 && password.compareTo("pass")== 0){
            login_status = true;
            System.out.println("Login successful!");
        }
        else {
            System.out.println("Invalid input");
            destroy();
        }
    }
    
    private void display_staff_menu() {
        System.out.println("====Staff====");
        System.out.println("1.Create/Update/Remove movie listing.");
        System.out.println("2. Create/Update/Remove cinema showtimes and the movie to be shown.");
        System.out.println("3. Configure System settings.");
        System.out.println("4. Logout.");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                intent(this, new movie_listing());
                break;

            case 2:
                intent(this, new showtime_listing());
    
            case 4:
                login_status = false;
                System.out.println("Logged out");
                destroy();
                break;
        }


    }

}