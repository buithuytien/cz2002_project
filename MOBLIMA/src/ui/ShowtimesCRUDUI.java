package ui;

import crud.CinemaCRUD;
import crud.CineplexCRUD;
import crud.MovieCRUD;
import crud.ShowtimesCRUD;
import entity.Cinema;
import entity.Cineplex;
import entity.Movie;
import entity.Showtimes;
import util.DateTimeHelper;
import util.TextDB;

/**
 * ShowtimesCRUDUI inherits AbstractUI
 * UI for create showtimes in staff mode
 * @author Ronald
 *
 */
public class ShowtimesCRUDUI extends AbstractUI {

	@Override
	public void start() {
		// TODO Auto-generated method stub
		System.out.println();
		System.out.println("Choose a cineplex:");
		CineplexCRUD<Cineplex> cineplexCRUD = new CineplexCRUD<>(Cineplex.class);
		int noCineplexChoice = cineplexCRUD.printChoices();
		int cineplexChoice = this.getInputChoice(0, noCineplexChoice-1);
		
		System.out.println("Choose a cinema:");
		Cineplex cineplex = cineplexCRUD.getCineplex(cineplexChoice);
		CinemaCRUD<Cinema> cinemaCRUD = cineplex.getCinemaCRUD();
		int noCinemaChoice = cinemaCRUD.printChoices();
		int cinemaChoice = this.getInputChoice(0, noCinemaChoice-1);
		Cinema cinema = cinemaCRUD.getCinema(cinemaChoice);
		
		System.out.println("Choose a movie:");
		MovieCRUD<Movie> movieCRUD = new MovieCRUD<>(Movie.class);
		int noMovieChoice = movieCRUD.printChoicesForShowtimes();
		int movieChoice = this.getInputChoice(0, noMovieChoice-1);
		Movie movie = movieCRUD.getMovie(movieChoice);
		
		System.out.println("Enter desired showing date:");
		String dateStr = this.getInputDate();
		
		System.out.println("Enter desired movie start time:");
		String timeStr = this.getInputTime(dateStr, movie.getDuration());
		
		this.run(cineplex, dateStr, cinema, timeStr, movie);
	}

	/**
	 * method to get the start time of the movie
	 * also checks if the movie carries on past 12am
	 * @param dateStr
	 * @param movieDuration
	 * @return string value of time
	 */
	// Need to check if pass next day
	public String getInputTime(String dateStr, int movieDuration) {
		String input;
		try {
			while (true) {
				System.out.println("Enter time in " + DateTimeHelper.TIME_FORMAT);
				input = this.getInputString();
				if (DateTimeHelper.isToday(dateStr)) {
					if (!DateTimeHelper.checkAfterMinutesFromNow(input)) {
						System.out.println("Input time is 15 minutes after current time!");
						continue;
					}
				} 
				if (DateTimeHelper.getMinutesTillMidnight(input)>movieDuration)
					break;
				System.out.println("Movie showing cannot be past midnight!");
			}
		} catch (Exception e) {
			System.out.println("Wrong input! Please try again!");
			return this.getInputTime(dateStr, movieDuration);
		}
		return input;
	}
	
	/**
	 * method to create a new showtime object for a movie, with the given parameters as attributes
	 * @param cineplex
	 * @param dateStr
	 * @param cinema
	 * @param timeStr
	 * @param movie
	 */
	public void run(Cineplex cineplex, String dateStr, Cinema cinema, String timeStr, Movie movie ) {
		ShowtimesCRUD<Showtimes> crud = new ShowtimesCRUD<>(Showtimes.class, cineplex.getId(), dateStr);
		Showtimes showtimes = new Showtimes(cinema, timeStr, movie);
		crud.create(showtimes);
		System.out.println("Showtime created successfully!");
		this.goBack();
	}
}
