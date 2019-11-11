package login.ui;

import java.time.LocalTime;

import base.AbstractUI;
<<<<<<< Updated upstream
=======
import booking.BookAndPurchaseTicketUI;
>>>>>>> Stashed changes
import booking.CinemaLayoutUI;
import cache.Cache;
import staff.movie.entity.Movie;
import staff.movie.ui.MovieDetailUI;
import staff.movie.ui.MovieListUI;
<<<<<<< Updated upstream

public class UserUI extends AbstractUI {
    Movie movie;
=======
import staff.showtimes.entity.Cinema;

public class UserUI extends AbstractUI {
    Movie movie;
    private String time;
    public Cinema cinema;
    
>>>>>>> Stashed changes
	public UserUI() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void start() {
		// TODO Auto-generated method stub
		System.out.println();
		System.out.println("Welcome user "+Cache.getUsername());
		System.out.println("0: Search/List movie");
<<<<<<< Updated upstream
		System.out.println("1: View movie details – including reviews and ratings "); 
		System.out.println("2: Check seat availability and selection of seat/s. ");
		System.out.println("3: Book and purchase ticket");
		System.out.println("4: View booking history");
		System.out.println("5: List the Top 5 ranking by ticket sales OR by overall reviewers’ ratings ");
		System.out.println("6: Exit");
=======
		//System.out.println("1: View movie details – including reviews and ratings "); 
		System.out.println("1: Check seat availability and selection of seat/s. ");
		System.out.println("2: Book and purchase ticket");
		System.out.println("3: View booking history");
		System.out.println("4: List the Top 5 ranking by ticket sales OR by overall reviewers’ ratings ");
		System.out.println("5: Exit");
>>>>>>> Stashed changes
		
		int choice = this.getInputChoice(0, 6);
		
		this.run(choice);
	}
	
	public void run(int choice) {
		
		switch(choice) {
		case 0:
			this.intent(new MovieListUI());
			
			break;
		case 1:
<<<<<<< Updated upstream
			this.intent(new MovieDetailUI(movie));
		
			break;
		case 2:
			this.intent(new CinemaLayoutUI());
			
			break;
		case 3:
			
		
			break;
			
		case 4:
			
			
			break;
		case 5:
			
			
			break;
		case 6:
=======
			this.intent(new CinemaLayoutUI(cinema, time, movie));
			break;
		case 2:
			
		    this.intent(new BookAndPurchaseTicketUI());
			break;
			
		case 3:
			
			break;
		case 4:
			
			break;
		case 5:
>>>>>>> Stashed changes
			this.exit();
			break;
			
			
<<<<<<< Updated upstream
		
		
		
		
=======
	
>>>>>>> Stashed changes
		}
		
		
		
		
	}
	

}