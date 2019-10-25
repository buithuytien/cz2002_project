public class MovieList{
    private Movie[] movielist = new Movie[10];
    public MovieList(Movie[] movielist){
        this.movielist = movielist;
    }

    public Movie[] getArray(){
        return movielist;
    }


    public void displayMovieList(){
        System.out.println("Movie List:");
        for (int i = 0; i<movielist.length; i++){
            if (movielist[i] != null){
                System.out.println((i+1) + ". " + movielist[i].getMovieTitle());
            }
        }
    }

}