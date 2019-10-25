import java.util.Scanner;
public class MOBLIMA{

    public static void main(String[] args) {
        Movie movie1 = new Movie("movie1", "coming soon", "synopsis1", "director1", new String[]{"cast1","cast2"}, new String[]{"review1","review2"}, new double[]{4.1,4.5});
        Movie movie2 = new Movie("movie2", "preview", "synopsis2", "director2", new String[]{"cast3","cast4"}, new String[]{"review3","review4"}, new double[]{4.3,4.7});
        Movie movie3 = new Movie("movie3", "now showing", "synopsis3", "director3", new String[]{"cast5","cast6"}, new String[]{"review5","review6"}, new double[]{4.5,4.9});
        MovieList movielist = new MovieList(new Movie[]{movie1,movie2,movie3});
        Scanner sc = new Scanner(System.in);
        int choice;
        int moviegoer_choice;
        String username;
        String password;
        String real_username = "username";
        String real_password = "password";
        do {
            System.out.println("============================= MOBLIMA =======================================");
            System.out.println("1. Staff");
            System.out.println("2. Movie goer");
            System.out.println("3. Quit");
            choice = sc.nextInt();
            if (choice == 1) {
                System.out.println("======================== STAFF =============================");
                do{
                    System.out.println("Please login.");
                    System.out.println("Input username");
                    username = sc.next();
                    System.out.println("Input password");
                    password = sc.next();
                    if (username.compareTo(real_username) != 0 || password.compareTo(real_password) != 0){
                        System.out.println("Try again. Wrong input.");
                    }
                    else{
                        System.out.println("Login successful.");
                    }
                }while(username.compareTo(real_username) != 0 || password.compareTo(real_password) != 0);
                System.out.println("1.Create/Update/Remove Movie Listing"); // Already created one, need to remove first to create.
                //Add choices here when you are done.
                int staff_choice = sc.nextInt();
                if (staff_choice == 1){
                    Movie[] temp_list = new Movie[10];
                    Movie[] temp_list2 = movielist.getArray(); 
                    int i = 0;
                    while (temp_list2[i] != null){
                        temp_list[i] = temp_list2[i];
                        i++;
                    }
                }
                    for (int j = 0; j<temp_list.length;j++){
                        temp_list[j].displayMovieDetails();
                    }

            }
            if (choice == 2) {
            
                System.out.println("===================== MOVIE-GOER ==========================");
                System.out.println("1.Search/List movie"); // What is Search????
                System.out.println("2.View movie details");
                //Add the choices here when done.
                moviegoer_choice = sc.nextInt();
                if (moviegoer_choice == 1){
                        movielist.displayMovieList();
                }
                if (moviegoer_choice == 2){
                    movielist.displayMovieList();
                    System.out.println("Input the movie number you want to view.");
                    int view = sc.nextInt();
                    Movie[] temp = movielist.getArray();
                    temp[view-1].displayMovieDetails(); 
                }
           
            }
            System.out.println("\n");
         }while(choice == 1 || choice == 2);
         sc.close();
    }
}