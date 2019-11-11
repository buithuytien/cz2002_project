package staff.movie.crud;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import base.AbstractCRUD;
import staff.movie.entity.Movie;

public class MovieCRUD<T extends Movie> extends AbstractCRUD<T> {
	public MovieCRUD(Class<T> clazz) {
		this.dataList = new ArrayList<T>();
		this.dataClazz = clazz;
		this.read();
	}
	
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
	
	public boolean checkExistenceId(int id) {
		for (int i=0; i<getDataLength(); i++) {
			if (this.dataList.get(i).getId()==id)
				return true;
		}
		
		return false;
	}
	
	public void createMovie(int id, String title, int statusChoice, int typeChoice, int ratingChoice, 
			String synopsis, String director, ArrayList<String> cast, int duration) {
		Movie movie = new Movie(id, title, statusChoice, typeChoice, ratingChoice, synopsis, director, cast, duration);
		
		this.create((T)movie);
	}
	
	public void updateTicketSales(int movieId, int sales) {
		for (int i=0; i<getDataLength(); ++i) {
			if (this.dataList.get(i).getId()==movieId) {
				this.dataList.get(i).updateTicketSales(sales);
			}
		}
		this.save();
	}
	
	public Movie getMovie(int idx) {
		return (Movie)this.dataList.get(idx);
	}
	
	public Movie getMovieById(int movieId) {
		for (int i=0; i<getDataLength(); ++i) {
			if (this.dataList.get(i).getId()==movieId)
				return (Movie)this.dataList.get(i);
		}
		
		return null;
	}
	
	public void printMovieListById(ArrayList<Integer> movieIdList) {
		ArrayList<Movie> movieList = new ArrayList<>();
		Movie movie;
		for (int i=0; i<movieIdList.size(); ++i) {
			movie = this.getMovieById(movieIdList.get(i));
			System.out.println(i+" : "+movie.toString());
		}
	}
	
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
	
	public void printTopRatingMovies() {
		Collections.sort(this.dataList, new SortByRating());
		int top = Math.min(5, getDataLength());
		for (int i=0; i<top; ++i) {
			System.out.println(this.dataList.get(i).toString());
		}
		Collections.sort(this.dataList);
	}
	
	public void printTopSalesMovies() {
		Collections.sort(this.dataList, new SortBySales());
		int top = Math.min(5, getDataLength());
		for (int i=0; i<top; ++i) {
			System.out.println(this.dataList.get(i).toString());
		}
		Collections.sort(this.dataList);
	}
}

class SortByRating implements Comparator<Movie> 
{
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

class SortBySales implements Comparator<Movie>
{
	public int compare(Movie a, Movie b) {
		if (a.getTicketSales()>b.getTicketSales())
			return -1;
		else if (a.getTicketSales()<b.getTicketSales())
			return 1;
		else
			return 0;
	}
}
