package user.ui;

import base.AbstractUI;
import cache.Cache;
import staff.movie.crud.MovieCRUD;
import staff.movie.entity.Movie;
import staff.movie.ui.MovieListUI;
import user.book.crud.BookingCRUD;
import user.book.entity.Booking;
import user.book.ui.ShowtimesListUI;
import user.movie.ui.ListTopMoviesUI;

public class UserUI extends AbstractUI {

	public UserUI() {
		// TODO Auto-generated constructor stub
	}

	@Override
	
	public void start() {
		// TODO Auto-generated method stub
		System.out.println();
		System.out.println("Welcome user "+Cache.getUsername());
		System.out.println("0: Search/List movie");
		System.out.println("1: Choose Timeslots ");
		System.out.println("2: View booking history");
		System.out.println("3: List the Top 5 ranking by ticket sales OR by overall reviewers' ratings ");
		System.out.println("4: Exit");

		int choice = this.getInputChoice(0, 6);

		this.run(choice);
	}

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