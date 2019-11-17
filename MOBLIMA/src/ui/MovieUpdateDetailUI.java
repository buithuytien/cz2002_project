package ui;

import java.util.ArrayList;

import cache.Cache;
import crud.MovieCRUD;
import entity.Movie;
import enums.MovieRating;
import enums.MovieType;
import enums.ShowingStatus;

/**
 * MovieUpdateDetailUI inherits AbstracctUI
 * @author Ronald
 *
 */
public class MovieUpdateDetailUI extends AbstractUI {
	/**
	 * constructor
	 */
	Movie movie;
	/**
	 * constructor
	 * @param movie
	 */
	public MovieUpdateDetailUI(Movie movie) {
		this.movie = movie;
	}
	@Override
	public void start() {
		// TODO Auto-generated method stub
		System.out.println();
		System.out.println("Current movie details:");
		System.out.println(this.movie.toDetailedString());
		System.out.println();
		System.out.println("0 : Update title");
		System.out.println("1 : Update showing status");
		System.out.println("2 : Update movie type");
		System.out.println("3 : Update movie rating");
		System.out.println("4 : Update synopsis");
		System.out.println("5 : Update director");
		System.out.println("6 : Update cast");
		System.out.println("7 : Update duration");
		System.out.println("8 : Back to previous menu");
		
		int choice = this.getInputChoice(0, 8);
		
		this.run(choice);
	}

	/**
	 * method to update the details/attributes of a particular movie
	 * choice '0' updates the title of the movie
	 * choice '1' updates the status of the movie if it is available in the cinema or not
	 * choice '2' updates the type of movie, based on the enumerations in MovieType class
	 * choice '3' updates the film classification guidelines, based on the enumerations in MovieRating class
	 * choice '4' updates the synopsis of the particular movie
	 * choice '5' updates the name of the director
	 * choice '6' updates the list of casts in the movie
	 * choice '7' updates the duration of the movie
	 * choice '8' returns to the previous menu
	 * @param choice
	 */
	public void run(int choice) {
		if (choice==8) {
			this.goBack();
			return;
		}
		MovieCRUD<Movie> crud = (MovieCRUD)Cache.getCurrentCRUD();
		switch (choice) {
		case 0:
			String title = this.getInputString();
			System.out.println("Enter movie title: ");
			this.movie.setTitle(title);
			break;
		case 1:
			System.out.println("Showing status: ");
			int noStatusChoice = ShowingStatus.printChoices();
			int statusChoice = this.getInputChoice(0, noStatusChoice-1);
			this.movie.setStatus(statusChoice);
			break;
		case 2:
			System.out.println("Movie type: ");
			int noTypeChoice = MovieType.printChoices();
			int typeChoice = this.getInputChoice(0, noTypeChoice-1);
			this.movie.setType(typeChoice);
			break;
		case 3: 
			System.out.println("Movie rating: ");
			int noRatingChoice = MovieRating.printChoices();
			int ratingChoice = this.getInputChoice(0, noRatingChoice-1);
			this.movie.setMovieRating(ratingChoice);
			break;
		case 4:
			System.out.println("Enter synopsis: ");
			String synopsis = this.getInputString();
			this.movie.setSynopsis(synopsis);
			break;
		case 5:
			System.out.println("Enter director: ");
			String director = this.getInputString();
			this.movie.setDirector(director);
			break;
		case 6:
			System.out.println("Enter cast: ");
			ArrayList<String> cast = this.getInputListString();
			this.movie.setCast(cast);
			break;
		case 7:
			System.out.println("Enter duration in minutes: ");
			int duration = this.getInputInteger();
			this.movie.setDuration(duration);
			break;
		}
		System.out.println("Updated successfully!");
		crud.save();
		this.start();
	}
}
