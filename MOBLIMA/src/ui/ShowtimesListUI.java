package ui;

import java.util.ArrayList;

import cache.Cache;
import crud.CineplexCRUD;
import crud.MovieCRUD;
import crud.ShowtimesCRUD;
import entity.Cineplex;
import entity.Movie;
import entity.Showtimes;

public class ShowtimesListUI extends AbstractUI {

	@Override
	public void start() {
		// TODO Auto-generated method stub
		System.out.println();
		System.out.println("Choose a cineplex:");
		CineplexCRUD<Cineplex> cineplexCRUD = new CineplexCRUD<>(Cineplex.class);
		int noCineplexChoice = cineplexCRUD.printChoices();
		int cineplexChoice = this.getInputChoice(0, noCineplexChoice-1);
		Cineplex cineplex = cineplexCRUD.getCineplex(cineplexChoice);
		
		System.out.println("Enter desired showing date");
		String dateStr = this.getInputDate();
		
		this.run(cineplex.getId(), dateStr);		
	}

	public void run(int cineplexId, String dateStr) {
		ShowtimesCRUD<Showtimes> showtimesCRUD = new ShowtimesCRUD<>(Showtimes.class, cineplexId, dateStr);
		System.out.println("All available showtimes:");
		showtimesCRUD.printShowtimesListByMovie();
		
		ArrayList<Integer> movieIdList = showtimesCRUD.getMovieIdList();
		if (movieIdList.size()==0) {
			System.out.println("No showtimes available, sorry!");
			this.goBack();
			return;
		}
		System.out.println();
		System.out.println("Choose a movie:");
		MovieCRUD<Movie> movieCRUD = new MovieCRUD<>(Movie.class);
		movieCRUD.printMovieListById(movieIdList);
		
		int choice = this.getInputChoice(0, movieIdList.size()-1);
		System.out.println();
		System.out.println("Available showtimes for your movie");
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
