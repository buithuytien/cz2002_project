package login.ui;

import base.AbstractUI;
import booking.CinemaLayoutUI;
import cache.Cache;
import staff.movie.entity.Movie;
import staff.movie.ui.MovieDetailUI;
import staff.movie.ui.MovieListUI;

public class UserUI extends AbstractUI {
    Movie movie;
	public UserUI() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void start() {
		// TODO Auto-generated method stub
		System.out.println();
		System.out.println("Welcome user "+Cache.getUsername());
		System.out.println("0: Search/List movie");
		System.out.println("1: View movie details – including reviews and ratings "); 
		System.out.println("2: Check seat availability and selection of seat/s. ");
		System.out.println("3: Book and purchase ticket");
		System.out.println("4: View booking history");
		System.out.println("5: List the Top 5 ranking by ticket sales OR by overall reviewers’ ratings ");
		System.out.println("6: Exit");
		
		int choice = this.getInputChoice(0, 6);
		
		this.run(choice);
	}
	
	public void run(int choice) {
		
		switch(choice) {
		case 0:
			this.intent(new MovieListUI());
			
			break;
		case 1:
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
			this.exit();
			break;
			
			
		
		
		
		
		}
		
		
		
		
	}
	

}
