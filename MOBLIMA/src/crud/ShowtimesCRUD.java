package crud;

import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import entity.Movie;
import entity.Showtimes;
import util.DateTimeHelper;

/**
 * ShowtimesCRUD extends AbstractCRUD 
 * whereby attributes from AbstractCRUD is replaced by attributes from Showtimes
 * @author Ronald
 *
 * @param <T>
 */
public class ShowtimesCRUD<T extends Showtimes> extends AbstractCRUD<T> {
	/**
	 * constructor
	 * @param clazz
	 * @param cineplexId
	 * @param dateStr
	 */
	public ShowtimesCRUD(Class<T> clazz, int cineplexId, String dateStr) {
		Showtimes.setFileName(cineplexId, dateStr);
		this.dataList = new ArrayList<T>();
		this.dataClazz = clazz;
		this.read();
	}
	
	/**
	 * accessor method to get list of movies that are available for showing 
	 * @param arr
	 * @return list of movie names that are available for showing
	 */
	public ArrayList<Showtimes> getShowtimesAvailable(ArrayList<Showtimes> arr) {
		ArrayList<Showtimes> res = new ArrayList<>();
		if (DateTimeHelper.isToday(Showtimes.getDate())) {
			for (int i=0; i<arr.size(); ++i) {
				if (DateTimeHelper.checkAfterMinutesFromNow(arr.get(i).getStartTime()))
					res.add(arr.get(i));
			}
			return res;
		} else {
			return arr;
		}
	}
	
	/**
	 * accessor method to get the list of movies that are available for showing
	 * and sorted by name
	 * @return list of sorted movie names that are available for showing
	 */
	public ArrayList<Showtimes> getShowtimesListByMovie() {
		ArrayList<Showtimes> res = new ArrayList<>();
		for (int i=0; i<this.getDataLength(); ++i) {
			res.add((Showtimes)this.dataList.get(i));
		}
		Collections.sort(res, new SortByName());
		
		res = this.getShowtimesAvailable(res);
		return res;
	}
	
	/**
	 * method to print the list of movies that are available for showing
	 * and sorted by movieId
	 * @param movieId
	 * @return list of movie names sorted by movieId that are available for showing
	 */
	public ArrayList<Showtimes> printShowtimesListByMovieId(int movieId) {
		ArrayList<Showtimes> arr = this.getShowtimesListByMovie();
		ArrayList<Showtimes> res = new ArrayList<>();
		for (int i=0; i<arr.size(); ++i) {
			if (arr.get(i).getMovieId()==movieId)
				res.add(arr.get(i));
		}
		
		for (int i=0; i<res.size(); ++i) {
			System.out.println(i+" : "+res.get(i).toString());
		}
		return res;
	}
	
	/**
	 * method to print the list of timings that the available movies start at
	 * and sorted by name
	 */
	public void printShowtimesListByMovie() {
		ArrayList<Showtimes> res = this.getShowtimesListByMovie();

		for (int i=0; i<res.size(); ++i) {
			System.out.println(res.get(i).toString());
		}
	}
	
	/**
	 * method to create new array object 
	 * that contains the sorted list available movies by name
	 * @return list of movieId that are available for showing
	 */
	public ArrayList<Integer> getMovieIdList() {
		ArrayList<Integer> movieIdList = new ArrayList<>();
		ArrayList<Showtimes> res = this.getShowtimesListByMovie();
		for (int i=0; i<res.size(); ++i) {
			int movieId = res.get(i).getMovieId();
			if (!movieIdList.contains(movieId))
				movieIdList.add(movieId);
		}
		
		return movieIdList;
	}
	
	/**
	 * method to view the available seats for the particular movie showtime
	 * @param choice
	 */
	public void viewSeat(int choice) {
		ArrayList<Showtimes> res = this.getShowtimesListByMovie();
		Showtimes obj = res.get(choice);
		obj.viewSeat();
	}
}

/**
 * SortByName realises Showtimes
 * Showtimes can be naturally ordered
 * @author Ronald
 *
 */
class SortByName implements Comparator<Showtimes>
{
	/**
	 * method to compare if a or b has a higher movieId
	 * to be sorted
	 */
	public int compare(Showtimes a, Showtimes b) {
		MovieCRUD<Movie> movieCRUD = new MovieCRUD<>(Movie.class);
		Movie movieA = movieCRUD.getMovieById(a.getMovieId());
		Movie movieB = movieCRUD.getMovieById(b.getMovieId());
		return movieA.getTitle().compareTo(movieB.getTitle());
		
	}
}