package ui;

import cache.Cache;
import crud.BookingCRUD;
import crud.MovieCRUD;
import entity.Booking;
import entity.Movie;

/**
 * UserUI inherits AbstractUI
 * @author Ronald
 *
 */
public class UserUI extends AbstractUI {

	/**
	 * constructor
	 */
	public UserUI() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void start() {
		// TODO Auto-generated method stub
		System.out.println();
		System.out.println("Welcome user "+Cache.getUsername());
		System.out.println("0 : Search/List movies");
		System.out.println("1 : Book a movie");
		System.out.println("2 : View booking history");
		System.out.println("3 : List the top 5 movie rankings by ticket sales OR by overall ratings");
		System.out.println("4 : Exit MOBLIMA");

		int choice = this.getInputChoice(0, 6);

		this.run(choice);
	}

	/**
	 * method for user to search/list movie, choose timeslots of the movies in the cinema,
	 * view their booking history or list the top 5 ranks of movies
	 * choice '0' displays the menu in MovieListUI class
	 * choice '1' displays the menu in ShowtimesListUserUI class
	 * choice '2' prints the booking history of the current user
	 * choice '3' displays the menu in ListTopMoviesUI class
	 * choice '4' exits the program
	 * @param choice
	 */
	public void run(int choice) {

		switch(choice) {
		case 0:
			MovieCRUD<Movie> crud = new MovieCRUD<>(Movie.class);
			Cache.setCurrentCRUD(crud);
			this.intent(new MovieListUI());

			break;
		case 1:
			this.intent(new ShowtimesListUI());
			break;
		case 2:
			BookingCRUD<Booking> bookingCRUD = new BookingCRUD<>(Booking.class);
			bookingCRUD.printHistoryBooking(Cache.getUsername());
			System.out.println("End");
			this.start();
			break;
		case 3:
			this.intent(new ListTopMoviesUI());
			break;
		case 4:
			System.exit(1);
		}




	}


}