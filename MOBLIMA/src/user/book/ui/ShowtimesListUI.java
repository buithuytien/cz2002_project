package user.book.ui;

import java.util.ArrayList;

import base.AbstractUI;
import cache.Cache;
import staff.movie.crud.MovieCRUD;
import staff.movie.entity.Movie;
import staff.showtimes.crud.CineplexCRUD;
import staff.showtimes.crud.ShowtimesCRUD;
import staff.showtimes.entity.Cineplex;
import staff.showtimes.entity.Showtimes;

public class ShowtimesListUI extends AbstractUI {

	@Override
	public void start() {
		// TODO Auto-generated method stub
		System.out.println();
		System.out.println("Choose Cineplex:");
		CineplexCRUD<Cineplex> cineplexCRUD = new CineplexCRUD<>(Cineplex.class);
		int noCineplexChoice = cineplexCRUD.printChoices();
		int cineplexChoice = this.getInputChoice(0, noCineplexChoice-1);
		Cineplex cineplex = cineplexCRUD.getCineplex(cineplexChoice);
		
		System.out.println("Enter Showing Date");
		String dateStr = this.getInputDate();
		
		this.run(cineplex.getId(), dateStr);		
	}

	public void run(int cineplexId, String dateStr) {
		ShowtimesCRUD<Showtimes> showtimesCRUD = new ShowtimesCRUD<>(Showtimes.class, cineplexId, dateStr);
		System.out.println("All Showtimes:");
		showtimesCRUD.printShowtimesListByMovie();
		
		ArrayList<Integer> movieIdList = showtimesCRUD.getMovieIdList();
		if (movieIdList.size()==0) {
			System.out.println("No showtimes available! Sorry!");
			this.goBack();
			return;
		}
		System.out.println();
		System.out.println("Choose movie:");
		MovieCRUD<Movie> movieCRUD = new MovieCRUD<>(Movie.class);
		movieCRUD.printMovieListById(movieIdList);
		
		int choice = this.getInputChoice(0, movieIdList.size()-1);
		System.out.println();
		System.out.println("Showtimes for your movie");
		ArrayList<Showtimes> showtimesList = showtimesCRUD.printShowtimesListByMovieId(movieIdList.get(choice));
		if (Cache.isStaff()) {
			this.goBack();
		} else {
			int showtimesChoice = this.getInputChoice(0, showtimesList.size());
			Showtimes chosenShowtimes = showtimesList.get(showtimesChoice);
			this.intent(new BookAndPurchaseUI(chosenShowtimes));
		}
		
	}
}
