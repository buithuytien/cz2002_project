package staff.showtimes.ui;

import base.AbstractUI;
import staff.movie.crud.MovieCRUD;
import staff.movie.entity.Movie;
import staff.showtimes.crud.CinemaCRUD;
import staff.showtimes.crud.CineplexCRUD;
import staff.showtimes.entity.Cinema;
import staff.showtimes.entity.Cineplex;
import util.DateTimeHelper;
import util.TextDB;

public class ShowtimesCRUDUI extends AbstractUI {

	@Override
	public void start() {
		// TODO Auto-generated method stub
		System.out.println();
		System.out.println("Choose Cineplex:");
		CineplexCRUD<Cineplex> cineplexCRUD = new CineplexCRUD<>(Cineplex.class);
		int noCineplexChoice = cineplexCRUD.printChoices();
		int cineplexChoice = this.getInputChoice(0, noCineplexChoice-1);
		
		System.out.println("Choose Cinema");
		Cineplex cineplex = cineplexCRUD.getCineplex(cineplexChoice);
		CinemaCRUD<Cinema> cinemaCRUD = cineplex.getCinemaCRUD();
		int noCinemaChoice = cinemaCRUD.printChoices();
		int cinemaChoice = this.getInputChoice(0, noCinemaChoice-1);
		
		System.out.println("Choose Preview and Now Showing Movies");
		MovieCRUD<Movie> movieCRUD = new MovieCRUD<>(Movie.class);
		int noMovieChoice = movieCRUD.printChoicesForShowtimes();
		int movieChoice = this.getInputChoice(0, noMovieChoice-1);
		
		System.out.println("Choose ");
		
		System.out.println("Enter Start Time in " + DateTimeHelper.TIME_FORMAT);
		String date = this.getInputString();
	}

}
