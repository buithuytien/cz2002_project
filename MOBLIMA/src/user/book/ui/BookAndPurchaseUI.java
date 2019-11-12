package user.book.ui;

import base.AbstractUI;
import cache.Cache;
import staff.entity.enums.CinemaClass;
import staff.entity.enums.DayType;
import staff.entity.enums.MovieType;
import staff.movie.crud.MovieCRUD;
import staff.movie.entity.Movie;
import staff.settings.crud.PriceCRUD;
import staff.settings.entity.AgePrice;
import staff.settings.entity.CinemaClassPrice;
import staff.settings.entity.DayPrice;
import staff.settings.entity.MovieTypePrice;
import staff.showtimes.crud.CinemaCRUD;
import staff.showtimes.entity.Cinema;
import staff.showtimes.entity.Showtimes;
import user.book.crud.BookingCRUD;
import user.book.entity.Booking;
import user.ui.UserUI;
import util.DateTimeHelper;

public class BookAndPurchaseUI extends AbstractUI {
	private Showtimes showtimes;
	
	public BookAndPurchaseUI(Showtimes chosen) {
		this.showtimes = chosen;
	}
	@Override
	public void start() {
		// TODO Auto-generated method stub
		System.out.println();
		if (showtimes.isFull()) {
			System.out.println("No seat available!");
			this.home();
			return;
		}
		
		System.out.println("Seat available:");
		this.showtimes.viewSeat();
		System.out.println("0 : Proceed to book");
		System.out.println("1 : Back to Home");
		
		int choice = this.getInputChoice(0, 1);
		this.run(choice);
	}

	public void run(int choice) {
		switch(choice) {
		case 0:
			this.startBook();
			break;
		case 1:
			this.home();
			break;
		}
	}
	
	public void startInfo() {
		System.out.println();
		System.out.println("Enter your name:");
		String name = this.getInputString();
		System.out.println("Mobile:");
		int number = this.getInputInteger();
		System.out.println("Email:");
		String email = this.getInputString();
	}
	
	public void startBook() {
		this.startInfo();
		System.out.println();
		int maxNoSeat = this.showtimes.getNoSeatAvailable();
		System.out.println("How many tickets you want to purchase (Max:"+maxNoSeat+"):");
		int choice = this.getInputChoice(1, maxNoSeat);
		

		
		// Array to store age of Movie-goers
		int[] ageArray = new int[choice];
		for (int i=0; i< choice; ++i) {
			System.out.println();
			this.showtimes.viewSeat();
			System.out.println("Please choose your seat (eg A1):");
			int[] seat = this.getInputSeat();
			
			this.showtimes.takeSeat(seat[0], seat[1]);
			System.out.println("Enter Movie-goer's Age:");
			int age = this.getInputInteger();
			ageArray[i] = age;
		}
		this.runBook(choice, ageArray);
	}
	
	public void runBook(int sales, int[] ageArray) {
		// Update ticket sales of movie
		MovieCRUD<Movie> movieCRUD = new MovieCRUD<>(Movie.class);
		movieCRUD.updateTicketSales(this.showtimes.getMovieId(), sales);
		double totalPrice =0;
		for (int i=0; i<sales; ++i) {
			System.out.println();
			System.out.println("Ticket "+(i+1)+" : ");
			totalPrice += this.runPrice(ageArray[i]);
		}
		System.out.println("----------------");
		System.out.println("Total Price: "+totalPrice);
		System.out.println("Transaction successfully");
		
		// Create Booking History
		BookingCRUD<Booking> bookingCRUD = new BookingCRUD<>(Booking.class);
		bookingCRUD.createBooking(Cache.getUsername(), this.showtimes.getMovieId(), sales, 
				DateTimeHelper.getTodayDate(), DateTimeHelper.getCurrentTime(), 
				Showtimes.getCineplexId(), this.showtimes.getCinemaId());
		
		this.home();
		
	}
	
	public double runPrice(int age) {
		// PriceCRUD for calculating price later
		PriceCRUD<CinemaClassPrice> cinemaClassCRUD = new PriceCRUD<>(CinemaClassPrice.class);
		PriceCRUD<MovieTypePrice> movieTypeCRUD = new PriceCRUD<>(MovieTypePrice.class);
		PriceCRUD<DayPrice> dayCRUD = new PriceCRUD<>(DayPrice.class);
		PriceCRUD<AgePrice> ageCRUD = new PriceCRUD<>(AgePrice.class);
		
		// Get cinema class price
		CinemaCRUD<Cinema> cinemaCRUD = new CinemaCRUD<Cinema>(Cinema.class, Showtimes.getCineplexId());
		CinemaClass cinemaClass = cinemaCRUD.getCinemaType(this.showtimes.getCinemaId());
		CinemaClassPrice cinemaClassPrice = cinemaClassCRUD.getElementPrice(cinemaClass);
		
		// Get movie type price
		MovieCRUD<Movie> movieCRUD = new MovieCRUD<>(Movie.class);
		MovieType movieType = movieCRUD.getMovieById(this.showtimes.getMovieId()).getType();
		MovieTypePrice movieTypePrice = movieTypeCRUD.getElementPrice(movieType);
		
		// Get Day type price
		DayType dayType = DateTimeHelper.getDayType(this.showtimes.getDate());
		DayPrice dayTypePrice = dayCRUD.getElementPrice(dayType);
		
		// Get Age Range Price
		AgePrice agePrice = ageCRUD.getElementPrice(age);
		
		// Print receipt for 1 ticket
		System.out.println(cinemaClassPrice.toString());
		System.out.println(movieTypePrice.toString());
		System.out.println(dayTypePrice.toString());
		System.out.println(agePrice.toString());
		double ticketPrice = cinemaClassPrice.getPrice()+movieTypePrice.getPrice()+dayTypePrice.getPrice()+agePrice.getPrice();
		System.out.println("Ticket price: "+ticketPrice);
		
		return ticketPrice;
	}
	
	public void home() {
		UserUI ui = new UserUI();
		ui.start();
	}
	
	public int[] getInputSeat() {
		int[] seat = new int[2];
		String input;
		int A = (int)('A');
		while (true) {
			input = this.getInputString();
			if (!input.matches("[A-Z]\\d+")) {
				System.out.println("Wrong Format! Try again:");
				continue;
			}
			int row = (int)input.charAt(0) - A;
			int col = Integer.valueOf(input.substring(1));
			if (this.showtimes.isAvailableSeat(row, col)) {
				seat[0] = row;
				seat[1] = col;
				break;
			}
		}
		
		return seat;
	}
}
