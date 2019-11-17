package ui;

import crud.MovieCRUD;
import entity.Movie;

/**
 * ListTopMoviesUI inherits AbstractUI
 * @author Ronald
 *
 */
public class ListTopMoviesUI extends AbstractUI {

	@Override
	public void start() {
		// TODO Auto-generated method stub
		System.out.println();
		System.out.println("0 : List top 5 movies by overall rating");
		System.out.println("1 : List top 5 movies by ticket sales");
		System.out.println("2 : Back to previous menu");
		
		int choice = this.getInputChoice(0, 2);
		this.run(choice);
	}
	
	/**
	 * method to allow user to display top 5 movies either by overall ratings or number of tickets sold
	 * choice '0' prints the top 5 movies by overall ratings
	 * choice '1' prints the top 5 movies by number of tickets sold
	 * choice '2' returns to the previous menu
	 * @param choice
	 */
	public void run(int choice) {
		if (choice==2) {
			this.goBack();
			return;
		}
		MovieCRUD<Movie> crud = new MovieCRUD<>(Movie.class);
		switch (choice) {
		case 0: 
			crud.printTopRatingMovies();
			this.start();
			break;
		case 1:
			crud.printTopSalesMovies();
			this.start();
			break;
		}
	}

}
