package manager;
import objects.*;

public class showtime_manager{
    private static showtime[] showtimeListing = new showtime[10];
    public static void addShowtime(showtime Showtime){
        int i = 0;
        while (i<=9){
            if (showtimeListing[i] == null){
                showtimeListing[i] = Showtime;
                break;
            }
            i++;
        }
    }

    public static void deleteShowtime(String date, int time){  
        for (int i = 0; i<=9; i++){
            if (showtimeListing[i] != null){
                    String x = showtimeListing[i].getDate();
                    int y = showtimeListing[i].getTime();
                    if ((x.compareTo(date) == 0) && (y == time)){
                           showtimeListing[i] = showtimeListing[i+1];
                    }
            }
        }
    }

    public static void listShowtime(String movie_name){
        for (int i =0; i<=9;i++){
            if (showtimeListing[i] != null){
                movie movie1 = showtimeListing[i].getMovie();
                if (movie1.getTitle().compareTo(movie_name) == 0){
                  System.out.println( showtimeListing[i].getDate() + " AT " + showtimeListing[i].getTime());         
                }
            }
        }
    }

    public static showtime[] getShowtimeListing() {
        return showtimeListing;
    }


}