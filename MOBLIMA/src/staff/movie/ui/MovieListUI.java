package staff.movie.ui;

import java.util.ArrayList;

import base.AbstractUI;
import cache.Cache;
import staff.movie.crud.MovieCRUD;
import staff.movie.entity.Movie;

public class MovieListUI extends AbstractUI {

	@Override
	public void start() {
		// TODO Auto-generated method stub
		System.out.println();
		System.out.println("0 : List all movies");
		System.out.println("1 : Search for movie by name");
		System.out.println("2 : Back");
		
		int choice = this.getInputChoice(0, 2);
		
		this.run(choice);
	}
	
	public void run(int choice) {
		
		MovieCRUD<Movie> crud = (MovieCRUD)Cache.getCurrentCRUD();
		switch (choice) {
		case 0:
			int noChoice = crud.printChoices();
			int movieChoice = getInputChoice(0, noChoice-1);
			Movie movie = crud.getMovie(movieChoice);
			this.intent(new MovieDetailUI(movie));
			break;
		case 1:
			this.startSearch();
			break;
		case 2:
			this.goBack();
			break;
		}
	}
	
	public void startSearch() {
		System.out.println();
		System.out.println("Enter your search string:");
		String search = this.getInputString();
		
		this.runSearch(search);
	}
	
	public void runSearch(String search) {
		MovieCRUD<Movie> crud = (MovieCRUD)Cache.getCurrentCRUD();
		ArrayList<Movie> searchResult = crud.getSearchResult(search);
		if (searchResult.size()==0) {
			System.out.println("No result found!");
			this.start();
		} else {
			int noChoice = searchResult.size();
			for (int i=0; i<noChoice; ++i) {
				System.out.println(i+" : "+searchResult.get(i).toString());
			}
			int choice = this.getInputChoice(0, noChoice-1);
			this.intent(new MovieDetailUI(searchResult.get(choice)));
		}
	}

}
