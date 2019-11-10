package staff.showtimes.crud;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import base.AbstractCRUD;
import staff.movie.crud.MovieCRUD;
import staff.movie.entity.Movie;
import staff.showtimes.entity.Showtimes;

public class ShowtimesCRUD<T extends Showtimes> extends AbstractCRUD<T> {
	public ShowtimesCRUD(Class<T> clazz, int cineplexId, String dateStr) {
		Showtimes.setFileName(cineplexId, dateStr);
		this.dataList = new ArrayList<T>();
		this.dataClazz = clazz;
		this.read();
	}
	
	public ArrayList<Showtimes> getShowtimesListByMovie() {
		ArrayList<Showtimes> res = new ArrayList<>();
		for (int i=0; i<this.getDataLength(); ++i) {
			res.add((Showtimes)this.dataList.get(i));
		}
		Collections.sort(res, new SortByName());
		
		return res;
	}
	
	public void printShowtimesListByMovie() {
		ArrayList<Showtimes> res = this.getShowtimesListByMovie();
		for (int i=0; i<this.getDataLength(); ++i) {
			System.out.println(i+" : "+res.get(i).toString());
		}
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