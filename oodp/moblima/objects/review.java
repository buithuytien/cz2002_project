package objects;

import java.util.*;

public class review{
    private final int rating;
    private final movie Movie;
    private final String info;

    public review(int rating, movie Movie, String info){
        this.rating = rating;
        this.Movie = Movie;
        this.info = info;
    }
}