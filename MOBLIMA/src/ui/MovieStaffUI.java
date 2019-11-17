package ui;

import cache.Cache;
import crud.MovieCRUD;
import entity.Movie;

/**
 * MovieStaffUI inherits AbstractUI
 * UI for staff's behaviors
 * @author Ronald
 *
 */
public class MovieStaffUI extends AbstractUI {

	@Override
	public void start() {
		// TODO Auto-generated method stub
		System.out.println();
		System.out.println("0 : List all movies & View movie details");
		System.out.println("1 : Create/Update/Remove movie listing");
		System.out.println("2 : Back to previous menu");
		
		int choice = this.getInputChoice(0, 2);
		
		this.run(choice);
	}
	
	/**
	 * method to list and view movie details or edit movie listing
	 * choice '0' enters the menu in MovieListUI class
	 * choice '1' enters the menu in MovieCRUDUI class
	 * choice '2' returns to the previous menu
	 * @param choice
	 */
	public void run(int choice) {
		if (choice==2) {
			this.goBack();
			return;
		}
		MovieCRUD<Movie> crud = new MovieCRUD<>(Movie.class);
		Cache.setCurrentCRUD(crud);
		
		switch(choice) {
		case 0:
			this.intent(new MovieListUI());
			break;
		case 1:
			this.intent(new MovieCRUDUI());
			break;
		}
	}

}
