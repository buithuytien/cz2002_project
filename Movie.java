public class Movie{
    private String movieTitle;
    private String showingStatus;
    private String synopsis;
    private String director;
    private String[] cast = new String[5];
    private String[] review = new String[10];
    private double[] rating = new double[10];
    
    public Movie(String str1, String str2, String str3, String str4, String[] str5, String[] str6, double[] double1){
        this.movieTitle = str1;
        this.showingStatus = str2;
        this.synopsis = str3;
        this.director = str4;
        this.cast = str5;
        this.review = str6;
        this.rating = double1;
    }

    public void setTitle(String movieTitle){
        this.movieTitle = movieTitle;
    }

    public void setStatus(String showingStatus){
        this.showingStatus = showingStatus;
    }

    public void setSynopsis(String synopsis){
        this.synopsis = synopsis;
    }

    public void setDirector(String director){
        this.director = director;
    }

    public void setCast(String[] cast){
        this.cast = cast;
    }

    public double getOverallRating(){
        double sum = 0;
        double avg;
        int count = 0;
        for (int i = 0; i<rating.length; i++){
            if (rating[i] != 0){
                count++;
                sum = sum + rating[i];
            }  
        }
        avg = sum/count;
        return avg;
    }

    public String getMovieTitle(){
        return movieTitle;
    }


    public void displayMovieDetails(){
        System.out.println("Title: " + this.movieTitle);
        System.out.println("Showing Status: " + this.showingStatus);
        System.out.println("Synopsis: " + this.synopsis);
        System.out.println("Director: " + this.director);
        System.out.println("Casts: ");
        for (int i = 0; i< cast.length; i++){
            System.out.println(cast[i]);
        }
        System.out.println("Review and Ratings:");
        for (int i = 0; i<review.length; i++){
            if (review[i] != null)
                 System.out.println(review[i] + " " + rating[i]);
        }
        System.out.println("Overall Rating: " + getOverallRating());
    }
}