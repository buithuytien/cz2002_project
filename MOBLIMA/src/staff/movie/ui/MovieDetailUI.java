package staff.movie.ui;

import base.AbstractUI;
import staff.movie.entity.Movie;

public class MovieDetailUI extends AbstractUI {
	Movie movie;
	public MovieDetailUI(Movie movie) {
		this.movie = movie;
	}
	@Override
	public void start() {
		// TODO Auto-generated method stub
		System.out.println();
		System.out.println("0 : Movie Details");
		System.out.println("1 : Movie Review");
		System.out.println("2 : Back");
		
		int choice = this.getInputChoice(0, 2);
		this.run(choice);
	}
	
	public void run(int choice) {
		switch(choice) {
		case 0:
			this.movie.printMovieDetail();
			this.start();
			break;
		case 1:
			this.movie.printReview();
			this.start();
			break;
		case 2:
			this.goBack();
			break;
		}
	}

}
