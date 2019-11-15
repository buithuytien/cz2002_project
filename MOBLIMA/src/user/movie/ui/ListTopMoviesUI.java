package user.movie.ui;

import base.AbstractUI;
import staff.movie.crud.MovieCRUD;
import staff.movie.entity.Movie;

public class ListTopMoviesUI extends AbstractUI {

	@Override
	public void start() {
		// TODO Auto-generated method stub
		System.out.println();
		System.out.println("0 : List top 5 movies by overall rating");
		System.out.println("1 : List top 5 movies by ticket sales");
		System.out.println("2 : Back to previous menu");
		
		int choice = this.getInputChoice(0, 2);
		this.run(choice);
	}
	
	public void run(int choice) {
		if (choice==2) {
			this.goBack();
			return;
		}
		MovieCRUD<Movie> crud = new MovieCRUD<>(Movie.class);
		switch (choice) {
		case 0: 
			crud.printTopRatingMovies();
			this.start();
			break;
		case 1:
			crud.printTopSalesMovies();
			this.start();
			break;
		}
	}

}
