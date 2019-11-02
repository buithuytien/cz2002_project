package objects;

public class showtime{
    private seat[][] seat_arr;
    private String date;
    private int time;
    private int cinema_no;
    private int cineplex_no;
    private movie Movie;
    private final static int row = 9;
    private final static int col = 17;
    public showtime(){
        this.seat_arr = new seat[row][col];
        for (int row = 0; row <= 3; row++) {
            for (int col = 2; col <= 16; col++) {
                if (col == 8) continue;
                seat_arr[row][col] = new seat();
            }
        }

        for (int row = 4; row <= 7; row++) {
            for (int col = 0; col <= 16; col++) {
                if (col == 8) continue;
                seat_arr[row][col] = new seat();
            }
        }

        for (int col = 0; col <= 16; col++) {
            if (col == 8 || col == 9 || col == 10) continue;
            seat_arr[8][col] = new seat();
        }
    }
    
    public void setDate(String date){
        this.date = date;
    }

    public String getDate(){
        return date;
    }

    public void setTime(int time){
        this.time = time;
    }

    public int getTime(){
        return time;
    }

    public void setCineplexNo(int cineplex_no){
        this.cineplex_no = cineplex_no;
    }
    
    public int getCineplexNo(){
        return cineplex_no;
    }

    public void setCinemaNo(int cinema_no){
        this.cinema_no = cinema_no;
    }

    public int getCinemaNo(){
        return cinema_no;
    }

    public void setMovie(movie Movie){
        this.Movie = Movie;
    }

    public movie getMovie(){
        return Movie;
    }

    public seat[][] getSeatArr(){
        return seat_arr;
    }

    public void Book(int row, int col){
        seat_arr[row][col].book();
    }
}