package crud;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import entity.Movie;

/**
 * MovieCRUD extends AbstractCRUD 
 * whereby attributes from AbstractCRUD is replaced by attributes from Movie
 * @author Ronald
 *
 * @param <T>
 */
public class MovieCRUD<T extends Movie> extends AbstractCRUD<T> {
	/**
	 * constructor 
	 * @param clazz
	 */
	public MovieCRUD(Class<T> clazz) {
		this.dataList = new ArrayList<T>();
		this.dataClazz = clazz;
		this.read();
	}
	
	/**
	 * method to print the list of movies that is not END_SHOWING 
	 * @return number of movies that are not END_SHOWING
	 */
	public int printChoicesWithoutEndShowing() {
		int i=0;
		int N = this.getDataLength();
		while (i<N) {
			if (this.dataList.get(i).isEndShowing())
				break;
			System.out.println(i+" : "+this.dataList.get(i).toString());
			i++;
		}
		
		return i;
	}
	
	/**
	 * method to print list of movies that is not COMING_SOON
	 * @return number of movies that are not COMING_SOON
	 */
	public int printChoicesForShowtimes() {
		int i=0;
		int N = this.getDataLength();
		while(i<N) {
			if (this.dataList.get(i).isComingSoon())
				break;
			System.out.println(i+" : "+this.dataList.get(i).toString());
			++i;
		}
		
		return i;
	}
	
	/**
	 * method to check if the movie exists based on its id
	 * @param id
	 * @return True of False
	 */
	public boolean checkExistenceId(int id) {
		for (int i=0; i<getDataLength(); i++) {
			if (this.dataList.get(i).getId()==id)
				return true;
		}
		
		return false;
	}
	
	/**
	 * method to create movie object with the parameters as its attributes
	 * @param id
	 * @param title
	 * @param statusChoice
	 * @param typeChoice
	 * @param ratingChoice
	 * @param synopsis
	 * @param director
	 * @param cast
	 * @param duration
	 */
	public void createMovie(int id, String title, int statusChoice, int typeChoice, int ratingChoice, 
			String synopsis, String director, ArrayList<String> cast, int duration) {
		Movie movie = new Movie(id, title, statusChoice, typeChoice, ratingChoice, synopsis, director, cast, duration);
		
		this.create((T)movie);
	}
	
	/**
	 * method to update the tickets sold for each movie
	 * @param movieId
	 * @param sales
	 */
	public void updateTicketSales(int movieId, int sales) {
		for (int i=0; i<getDataLength(); ++i) {
			if (this.dataList.get(i).getId()==movieId) {
				this.dataList.get(i).updateTicketSales(sales);
			}
		}
		this.save();
	}
	
	/**
	 * accessor method to get movie name
	 * @param idx
	 * @return chosen movie object and its attributes
	 */
	public Movie getMovie(int idx) {
		return (Movie)this.dataList.get(idx);
	}
	
	/**
	 * accessor method to get movie name by id
	 * @param movieId
	 * @return chosen movie object and its attributes
	 */
	public Movie getMovieById(int movieId) {
		for (int i=0; i<getDataLength(); ++i) {
			if (this.dataList.get(i).getId()==movieId)
				return (Movie)this.dataList.get(i);
		}
		
		return null;
	}
	
	/**
	 * method to print out the list of movies by their id
	 * @param movieIdList
	 */
	public void printMovieListById(ArrayList<Integer> movieIdList) {
		ArrayList<Movie> movieList = new ArrayList<>();
		Movie movie;
		for (int i=0; i<movieIdList.size(); ++i) {
			movie = this.getMovieById(movieIdList.get(i));
			System.out.println(i+" : "+movie.toString());
		}
	}
	
	/**
	 * accessor method to get the search result of the movie based on its availability in the cinema
	 * @param search
	 * @return array of movies depending on search request
	 */
	public ArrayList<Movie> getSearchResult(String search) {
		ArrayList<Movie> res = new ArrayList<>();
		for (int i=0; i<getDataLength(); ++i) {
			boolean check = false;
			check = this.dataList.get(i).getTitle().toLowerCase().contains(search.toLowerCase());
			boolean checkEndShowing = this.dataList.get(i).isEndShowing();
			if (check&&!checkEndShowing)
				res.add((Movie)this.dataList.get(i));
		}
		
		return res;
	}
	
	/**
	 * method to print the movies with the 5 highest ratings
	 */
	public void printTopRatingMovies() {
		Collections.sort(this.dataList, new SortByRating());
		int top = Math.min(5, getDataLength());
		for (int i=0; i<top; ++i) {
			System.out.println(this.dataList.get(i).toString());
		}
		Collections.sort(this.dataList);
	}
	
	/**
	 * method to print the movies with the 5 highest tickets sold
	 */
	public void printTopSalesMovies() {
		Collections.sort(this.dataList, new SortBySales());
		int top = Math.min(5, getDataLength());
		for (int i=0; i<top; ++i) {
			System.out.println(this.dataList.get(i).toString());
		}
		Collections.sort(this.dataList);
	}
}

/**
 * SortByRating realises Movie
 * Movie can be naturally ordered
 * @author Ronald
 *
 */
class SortByRating implements Comparator<Movie> 
{
	/**
	 * method to compare the ratings of 2 movies
	 */
	public int compare(Movie a, Movie b) {
		double aRating = a.computeRating();
		double bRating = b.computeRating();
		if (aRating>bRating)
			return -1;
		else if (aRating<bRating)
			return 1;
		else
			return 0;
	}
}

/**
 * SortBySales realises Movie
 * Movie can be naturally ordered
 * @author Ronald
 *
 */
class SortBySales implements Comparator<Movie>
{
	/**
	 * method to compare the tickets sold between 2 movies
	 */
	public int compare(Movie a, Movie b) {
		if (a.getTicketSales()>b.getTicketSales())
			return -1;
		else if (a.getTicketSales()<b.getTicketSales())
			return 1;
		else
			return 0;
	}
}
