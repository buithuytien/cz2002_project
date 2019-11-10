package staff.showtimes.ui;

import base.AbstractUI;
import staff.movie.crud.MovieCRUD;
import staff.movie.entity.Movie;
import staff.showtimes.crud.CinemaCRUD;
import staff.showtimes.crud.CineplexCRUD;
import staff.showtimes.crud.ShowtimesCRUD;
import staff.showtimes.entity.Cinema;
import staff.showtimes.entity.Cineplex;
import staff.showtimes.entity.Showtimes;
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
		Cinema cinema = cinemaCRUD.getCinema(cinemaChoice);
		
		System.out.println("Choose Preview and Now Showing Movies");
		MovieCRUD<Movie> movieCRUD = new MovieCRUD<>(Movie.class);
		int noMovieChoice = movieCRUD.printChoicesForShowtimes();
		int movieChoice = this.getInputChoice(0, noMovieChoice-1);
		Movie movie = movieCRUD.getMovie(movieChoice);
		
		System.out.println("Enter Showing Date");
		String dateStr = this.getInputDate();
		
		System.out.println("Enter Start Time in " + DateTimeHelper.TIME_FORMAT);
		String timeStr = this.getInputTime(movie.getDuration());
		
		this.run(cineplex, dateStr, cinema, timeStr, movie);
	}

	// Need to check if pass next day
	public String getInputTime(int movieDuration) {
		return this.getInputString();
	}
	
	public void run(Cineplex cineplex, String dateStr, Cinema cinema, String timeStr, Movie movie ) {
		ShowtimesCRUD<Showtimes> crud = new ShowtimesCRUD<>(Showtimes.class, cineplex.getId(), dateStr);
		Showtimes showtimes = new Showtimes(cinema, timeStr, movie);
		crud.create(showtimes);
		System.out.println("Create Showtimes Successfully");
		this.goBack();
	}
}
