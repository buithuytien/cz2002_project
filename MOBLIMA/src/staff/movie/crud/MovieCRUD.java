package staff.movie.crud;

import java.util.ArrayList;

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
	
	public Movie getMovie(int idx) {
		return (Movie)this.dataList.get(idx);
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
}
