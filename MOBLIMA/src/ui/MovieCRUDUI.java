package ui;

import java.util.ArrayList;

import cache.Cache;
import crud.MovieCRUD;
import entity.Movie;
import enums.MovieRating;
import enums.MovieType;
import enums.ShowingStatus;

/**
 * MovieCRUDUI inherits AbstractUI
 * UI for create and update movies
 * @author Ronald
 *
 */
public class MovieCRUDUI extends AbstractUI {

	@Override
	public void start() {
		// TODO Auto-generated method stub
		System.out.println();
		System.out.println("0 : Create movie");
		System.out.println("1 : Update movie");
		System.out.println("2 : Back to previous menu");
		
		int choice = this.getInputChoice(0, 2);
		this.run(choice);
	}

	/**
	 * method to create or update movie
	 * choice '0' calls method startCreate() to create movie details
	 * choice '1' calls method startUpdate() to update movie details
	 * choice '2' returns to the previous menu
	 * @param choice
	 */
	public void run(int choice) {
		if (choice==2) {
			this.goBack();
			return;
		}
		
		switch(choice) {
		case 0:
			this.startCreate();
			break;
		case 1:
			this.startUpdate();
			break;
		}
	}
	
	/**
	 * method to get the input details which is the attributes of the movie
	 */
	public void startCreate() {
		MovieCRUD crud = (MovieCRUD)Cache.getCurrentCRUD();
		System.out.println();
		System.out.println("Enter Movie ID: ");
		int id = this.getInputInteger();
		if (crud.checkExistenceId(id)) {
			System.out.println("ID already exists! Please try again!");
			this.startCreate();
			return;
		}
		
		System.out.println("Enter movie title: ");
		String title = this.getInputString();
		
		System.out.println("Showing status: ");
		int noStatusChoice = ShowingStatus.printChoices();
		int statusChoice = this.getInputChoice(0, noStatusChoice-1);
		
		System.out.println("Movie type: ");
		int noTypeChoice = MovieType.printChoices();
		int typeChoice = this.getInputChoice(0, noTypeChoice-1);
		
		System.out.println("Movie rating: ");
		int noRatingChoice = MovieRating.printChoices();
		int ratingChoice = this.getInputChoice(0, noRatingChoice-1);
		
		System.out.println("Enter synopsis: ");
		String synopsis = this.getInputString();
		
		System.out.println("Enter director: ");
		String director = this.getInputString();
		
		System.out.println("Enter cast: ");
		ArrayList<String> cast = this.getInputListString();
		
		System.out.println("Enter duration in minutes: ");
		int duration = this.getInputInteger();
		
		this.runCreate(id, title, statusChoice, typeChoice, ratingChoice, synopsis, director, cast, duration);
	}
	
	/**
	 * method to create new movie object
	 * with the parameters as the attributes of the movie
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
	public void runCreate(int id, String title, int statusChoice, int typeChoice, int ratingChoice, 
			String synopsis, String director, ArrayList<String> cast, int duration) {
		MovieCRUD crud = (MovieCRUD)Cache.getCurrentCRUD();
		crud.createMovie(id, title, statusChoice, typeChoice, ratingChoice, synopsis, director, cast, duration);
		this.start();
	}
	
	/**
	 * method for user to choose an existing movie to update
	 */
	public void startUpdate() {
		MovieCRUD crud = (MovieCRUD)Cache.getCurrentCRUD();
		System.out.println();
		int noMovieChoice = crud.printChoices();
		int movieChoice = this.getInputChoice(0, noMovieChoice-1);
		
		this.runUpdate(movieChoice);
	}
	
	/**
	 * method to update the attributes of movie selected
	 * @param movieChoice
	 */
	public void runUpdate(int movieChoice) {
		MovieCRUD crud = (MovieCRUD)Cache.getCurrentCRUD();
		Movie movie = crud.getMovie(movieChoice);
		
		this.intent(new MovieUpdateDetailUI(movie));
	}
}
