package staff.movie.ui;

import java.util.ArrayList;

import base.AbstractUI;
import cache.Cache;
import staff.entity.enums.MovieRating;
import staff.entity.enums.MovieType;
import staff.entity.enums.ShowingStatus;
import staff.movie.crud.MovieCRUD;
import staff.movie.entity.Movie;

public class MovieCRUDUI extends AbstractUI {

	@Override
	public void start() {
		// TODO Auto-generated method stub
		System.out.println();
		System.out.println("0 : Create Movie");
		System.out.println("1 : Update Movie");
		System.out.println("2 : Back");
		
		int choice = this.getInputChoice(0, 2);
		this.run(choice);
	}

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
	
	public void startCreate() {
		MovieCRUD crud = (MovieCRUD)Cache.getCurrentCRUD();
		System.out.println();
		System.out.println("Enter Movie ID: ");
		int id = this.getInputInteger();
		if (crud.checkExistenceId(id)) {
			System.out.println("ID already exist! Try Again!");
			this.startCreate();
			return;
		}
		
		System.out.println("Enter Movie Title: ");
		String title = this.getInputString();
		
		System.out.println("Showing Status: ");
		int noStatusChoice = ShowingStatus.printChoices();
		int statusChoice = this.getInputChoice(0, noStatusChoice-1);
		
		System.out.println("Movie Type: ");
		int noTypeChoice = MovieType.printChoices();
		int typeChoice = this.getInputChoice(0, noTypeChoice-1);
		
		System.out.println("Movie Rating: ");
		int noRatingChoice = MovieRating.printChoices();
		int ratingChoice = this.getInputChoice(0, noRatingChoice-1);
		
		System.out.println("Enter synopsis: ");
		String synopsis = this.getInputString();
		
		System.out.println("Enter Director:");
		String director = this.getInputString();
		
		System.out.println("Enter Cast:");
		ArrayList<String> cast = this.getInputListString();
		
		this.runCreate(id, title, statusChoice, typeChoice, ratingChoice, synopsis, director, cast);
	}
	
	public void runCreate(int id, String title, int statusChoice, int typeChoice, int ratingChoice, 
			String synopsis, String director, ArrayList<String> cast) {
		MovieCRUD crud = (MovieCRUD)Cache.getCurrentCRUD();
		crud.createMovie(id, title, statusChoice, typeChoice, ratingChoice, synopsis, director, cast);
		this.start();
	}
	
	public void startUpdate() {
		MovieCRUD crud = (MovieCRUD)Cache.getCurrentCRUD();
		System.out.println();
		int noMovieChoice = crud.printChoices();
		int movieChoice = this.getInputChoice(0, noMovieChoice-1);
		
		this.runUpdate(movieChoice);
	}
	
	public void runUpdate(int movieChoice) {
		MovieCRUD crud = (MovieCRUD)Cache.getCurrentCRUD();
		Movie movie = crud.getMovie(movieChoice);
		
		this.intent(new MovieUpdateDetailUI(movie));
	}
}
