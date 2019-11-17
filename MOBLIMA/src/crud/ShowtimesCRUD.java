package crud;

import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import entity.Movie;
import entity.Showtimes;
import util.DateTimeHelper;

public class ShowtimesCRUD<T extends Showtimes> extends AbstractCRUD<T> {
	public ShowtimesCRUD(Class<T> clazz, int cineplexId, String dateStr) {
		Showtimes.setFileName(cineplexId, dateStr);
		this.dataList = new ArrayList<T>();
		this.dataClazz = clazz;
		this.read();
	}
	
	
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
	
	public ArrayList<Showtimes> getShowtimesListByMovie() {
		ArrayList<Showtimes> res = new ArrayList<>();
		for (int i=0; i<this.getDataLength(); ++i) {
			res.add((Showtimes)this.dataList.get(i));
		}
		Collections.sort(res, new SortByName());
		
		res = this.getShowtimesAvailable(res);
		return res;
	}
	
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
	
	public void printShowtimesListByMovie() {
		ArrayList<Showtimes> res = this.getShowtimesListByMovie();

		for (int i=0; i<res.size(); ++i) {
			System.out.println(res.get(i).toString());
		}
	}
	
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
	
	public void viewSeat(int choice) {
		ArrayList<Showtimes> res = this.getShowtimesListByMovie();
		Showtimes obj = res.get(choice);
		obj.viewSeat();
	}
}

class SortByName implements Comparator<Showtimes>
{
	public int compare(Showtimes a, Showtimes b) {
		MovieCRUD<Movie> movieCRUD = new MovieCRUD<>(Movie.class);
		Movie movieA = movieCRUD.getMovieById(a.getMovieId());
		Movie movieB = movieCRUD.getMovieById(b.getMovieId());
		return movieA.getTitle().compareTo(movieB.getTitle());
		
	}
}