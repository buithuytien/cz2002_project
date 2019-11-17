package ui;

import java.util.ArrayList;

import cache.Cache;
import crud.MovieCRUD;
import entity.Movie;

/**
 * MovieListUI inherits AbstractUI
 * UI for list and searh movies
 * @author Ronald
 *
 */
public class MovieListUI extends AbstractUI {

	@Override
	public void start() {
		// TODO Auto-generated method stub
		System.out.println();
		System.out.println("0 : List all movies");
		System.out.println("1 : Search for movies by name");
		System.out.println("2 : Back to previous menu");
		
		int choice = this.getInputChoice(0, 2);
		
		this.run(choice);
	}
	
	/**
	 * method to list all movies available or to search for movie by its name
	 * choice '0' prints the list of movies available in the cinema
	 * choice '1' searches for the movie by the name input
	 * choice '2' returns to the previous menu
	 * @param choice
	 */
	public void run(int choice) {
		
		MovieCRUD<Movie> crud = (MovieCRUD)Cache.getCurrentCRUD();
		switch (choice) {
		case 0:
			int noChoice = crud.printChoicesWithoutEndShowing();
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
	
	/**
	 * method for user to input movie name to search
	 */
	public void startSearch() {
		System.out.println();
		System.out.println("Enter your search string:");
		String search = this.getInputString();
		
		this.runSearch(search);
	}
	
	/**
	 * method to search for the movie based on the name input by user
	 * @param search
	 */
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
