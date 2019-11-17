package entity;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

import cache.Cache;
import crud.ReviewCRUD;
import enums.MovieRating;
import enums.MovieType;
import enums.ShowingStatus;
import util.TextDB;

/**
 * Movie inherits AbstractEntity
 * @author Ronald
 *
 */
public class Movie extends AbstractEntity {
	/**
	 * method to declare strings
	 */
	private static final String ARR_SEPERATOR = ",";
	public static String directoryName="";
	public static String fileName="Movie.txt";
	
	/**
	 * the movie id
	 */
	private int id;
	/**
	 * title of the movie
	 */
	private String title;
	/**
	 * status of the movie, whether it is showing on this cinema or not
	 */
	private ShowingStatus status;
	/**
	 * type of movie, categorised into the enumerations from MovieType class
	 */
	private MovieType type;
	/**
	 * the rating of the movie based on user's rating
	 */
	private MovieRating movieRating;
	/**
	 * a synopsis of the movie
	 */
	private String synopsis;
	/**
	 * name of the director
	 */
	private String director;
	/**
	 * number of tickets sold
	 */
	private int ticketSales=0;
	/**
	 * array of the names of the cast
	 */
	private ArrayList<String> cast;
	/**
	 * array of the reviews by the user's
	 */
	private ArrayList<Review> reviewList;
	/**
	 * duration of the movie
	 */
	private int duration;
	
	/**
	 * constructor
	 * @param id
	 * @param title
	 * @param statusChoice
	 * @param typeChoice
	 * @param ratingChoice
	 * @param synopsis
	 * @param director
	 * @param cast
	 * @param duration
	 */
	public Movie(int id, String title, int statusChoice, int typeChoice, int ratingChoice, 
			String synopsis, String director, ArrayList<String> cast, int duration) {
		this.id = id;
		this.title = title;
		this.status = ShowingStatus.values()[statusChoice];
		this.type = MovieType.values()[typeChoice];
		this.movieRating = MovieRating.values()[ratingChoice];
		this.synopsis = synopsis;
		this.director = director;
		this.cast = cast;
		this.reviewList = new ArrayList<Review>();
		this.duration = duration;
	}
	
	/**
	 * constructor to store the input values in a text file
	 * @param raw
	 */
	public Movie(String raw) {
		StringTokenizer star = new StringTokenizer(raw, TextDB.SEPERATOR);
		
		String idStr = star.nextToken().trim();
		String title = star.nextToken().trim();
		String statusStr = star.nextToken().trim();
		String typeStr = star.nextToken().trim();
		String movieRatingStr = star.nextToken().trim();
		String synopsis = star.nextToken().trim();
		String director = star.nextToken().trim();
		String ticketSalesStr = star.nextToken().trim();
		String castStr = star.nextToken().trim();
		String durationStr = star.nextToken().trim();
		
		this.id = Integer.valueOf(idStr);
		this.title = title;
		this.status = ShowingStatus.valueOf(statusStr);
		this.type = MovieType.valueOf(typeStr);
		this.movieRating = MovieRating.valueOf(movieRatingStr);
		this.synopsis = synopsis;
		this.director = director;
		this.ticketSales = Integer.valueOf(ticketSalesStr);
		
		this.cast = new ArrayList<String>();
		StringTokenizer castToken = new StringTokenizer(castStr, ARR_SEPERATOR);
		while (castToken.hasMoreTokens()) {
			this.cast.add(castToken.nextToken().trim());
		}
		this.reviewList = this.getReviewList();
		this.duration = Integer.valueOf(durationStr);
	}
	
	/**
	 * method to obtain the ratings of the movie
	 * then calculated to obtain the average rating of the movie under ReviewCRUD class
	 * @return the double value of the average rating
	 */
	public double computeRating() {
		ReviewCRUD<Review> reviewCRUD = this.getReviewCRUD();
		return reviewCRUD.computeRating();
	}
	
	@Override
	public int compareTo(AbstractEntity arg0) {
		int diff = this.getStatus().getPriority() - ((Movie)arg0).getStatus().getPriority();
		if (diff!=0)
			return diff;
		
		return this.getTitle().compareTo(((Movie)arg0).getTitle());
	}

	@Override
	public String processToDBString() {
		StringBuilder st = new StringBuilder();
		st.append(this.id);
		st.append(TextDB.SEPERATOR);
		st.append(this.title);
		st.append(TextDB.SEPERATOR);
		st.append(this.status);
		st.append(TextDB.SEPERATOR);
		st.append(this.type);
		st.append(TextDB.SEPERATOR);
		st.append(this.movieRating);
		st.append(TextDB.SEPERATOR);
		st.append(this.synopsis);
		st.append(TextDB.SEPERATOR);
		st.append(this.director);
		st.append(TextDB.SEPERATOR);
		st.append(this.ticketSales);
		st.append(TextDB.SEPERATOR);
		for (int i=0; i<this.cast.size()-1; i++) {
			st.append(this.cast.get(i));
			st.append(ARR_SEPERATOR);
		}
		st.append(this.cast.get(this.cast.size()-1));
		st.append(TextDB.SEPERATOR);
		st.append(this.duration);
//		st.append(TextDB.SEPERATOR);
//		
//
//		
//		for (int i=0; i<this.reviewList.size()-1; i++) {
//			st.append(this.reviewList.get(i).getId());
//			st.append(ARR_SEPERATOR);
//		}
//		st.append(this.reviewList.get(this.reviewList.size()-1).getId());
		
		return st.toString();
	}

	@Override
	public String toString() {
		StringBuilder st = new StringBuilder();
		st.append("ID - ");
		st.append(this.id);
		st.append(TextDB.SEPERATOR);
		st.append("Title - ");
		st.append(this.title);
		st.append(TextDB.SEPERATOR);
		st.append("Duration - ");
		st.append(this.duration);
		st.append(TextDB.SEPERATOR);
		st.append("Director - ");
		st.append(this.director);		
		st.append(TextDB.SEPERATOR);
		st.append("Showing status - ");
		st.append(this.status.getName());
		st.append(TextDB.SEPERATOR);
		st.append("Rating - ");
		double rating = this.computeRating();
		if (rating==-1)
			st.append("NA");
		else {
			st.append(rating);
		}

		return st.toString();
	}
	
	/**
	 * method to merge all the attributes of a movie to a single string
	 * @return string of all the attributes
	 */
	public String toDetailedString() {
		StringBuilder st = new StringBuilder();
		st.append("ID - ");
		st.append(this.id);
		st.append("\n");
		st.append("Title - ");
		st.append(this.title);
		st.append("\n");
		st.append("Duration - ");
		st.append(this.duration);
		st.append("\n");
		st.append("Showing status - ");
		st.append(this.status);
		st.append("\n");
		st.append("Movie Type - ");
		st.append(this.type);
		st.append("\n");
		st.append("Movie Rating - ");
		st.append(this.movieRating);
		st.append("\n");
		st.append("Synopsis - ");
		st.append(this.synopsis);
		st.append("\n");
		st.append("Director - ");
		st.append(this.director);
		st.append("\n");
		st.append("Cast - ");
		for (int i=0; i<this.cast.size()-1; i++) {
			st.append(this.cast.get(i));
			st.append(ARR_SEPERATOR);
		}
		st.append(this.cast.get(this.cast.size()-1));
		st.append("\n");
		st.append("Ticket Sales - ");
		st.append(this.ticketSales);
		st.append("\n");
		st.append("Rating - ");
		double rating = this.computeRating();
		if (rating==-1)
			st.append("NA");
		else {
			st.append(rating);
		}

		return st.toString();
	}

	@Override
	public boolean checkExistence(AbstractEntity object) {
		// TODO Auto-generated method stub
		return ((Movie)object).getId() == this.id;
	}
	
	/**
	 * accessor method to get the movie id
	 * @return movie id
	 */
	public int getId() {
		return this.id;
	}
	
	/**
	 * accessor method to get the movie title
	 * @return movie title
	 */
	public String getTitle() {
		return this.title;
	}
	
	/**
	 * mutator method to set the title of the movie
	 * @param title
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	
	/**
	 * accessor method to get the showing status of the movie, under enumeration of ShowingStatus class
	 * @return class of categories of the showing status
	 */
	public ShowingStatus getStatus() {
		return this.status;
	}
	
	/**
	 * mutator method to set the showing status of the movie, under enumeration of ShowingStatus class
	 * @param statusChoice
	 */
	public void setStatus(int statusChoice) {
		this.status = ShowingStatus.values()[statusChoice];
	}
	
	/**
	 * accessor method to get the type of movie, under enumerations of MovieType class
	 * @return class of categories of the movie type
	 */
	public MovieType getType() {
		return this.type;
	}
	
	/**
	 * mutator method to set the type of movie
	 * @param typeChoice
	 */
	public void setType(int typeChoice) {
		this.type = MovieType.values()[typeChoice];
	}
	
	/**
	 * mutator method to set the rating of the movie
	 * @param movieRatingChoice
	 */
	public void setMovieRating(int movieRatingChoice) {
		this.movieRating = MovieRating.values()[movieRatingChoice];
	}
	
	/**
	 * mutator method to set the synopsis of the movie
	 * @param synopsis
	 */
	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}
	
	/**
	 * mutator method to set the name of the director
	 * @param director
	 */
	public void setDirector(String director) {
		this.director = director;
	}
	
	/**
	 * mutator method to set the names of the cast of movie
	 * @param cast
	 */
	public void setCast(ArrayList<String> cast) {
		this.cast = cast;
	}
	
	/**
	 * accessor method to get the duration of the movie
	 * @return integer value of the duration of the movie
	 */
	public int getDuration() {
		return this.duration;
	}
	
	/**
	 * mutator method to set the duration of the movie
	 * @param duration
	 */
	public void setDuration(int duration) {
		this.duration = duration;
	}
	
	/**
	 * accessor method to get the number of tickets sold
	 * @return integer value of the number of tickets sold
	 */
	public int getTicketSales() {
		return this.ticketSales;
	}
	
	/**
	 * method to update the number of tickets sold
	 * @param sales
	 */
	public void updateTicketSales(int sales) {
		this.ticketSales += sales;
	}
	
	/**
	 * method to get the file path
	 * @return the file path
	 */
	public static String getFilePath() {
		String path = directoryName + "/" + fileName;
		File file = new File(Cache.DBPath+path);
		file.getParentFile().mkdirs();
		try {
			file.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return path;
	}
	
	/**
	 * method that return true if the movie is no longer showing in the cinema
	 * @return True or False
	 */
	public boolean isEndShowing() {
		return this.status == ShowingStatus.END_SHOWING;
	}
	
	/**
	 * method that return true if the movie is not out in the cinema yet
	 * @return True or False
	 */
	public boolean isComingSoon() {
		return this.status == ShowingStatus.COMING_SOON;
	}
	
	/**
	 * accessor method to get the review of the movie
	 * @return review object 
	 */
	public ReviewCRUD<Review> getReviewCRUD() {
		return new ReviewCRUD<Review>(Review.class, this.id);
	}
	
	/**
	 * method that return true of there exists a review of the movie
	 * @return True or False
	 */
	public boolean checkReviewExist() {
		ReviewCRUD<Review> reviewCRUD = this.getReviewCRUD();
		return reviewCRUD.checkUsernameExist();
	}
	
	/**
	 * accessor method to get the array of reviews of a movie
	 * @return list of review objects
	 */
	public ArrayList<Review> getReviewList() {
		ReviewCRUD<Review> reviewCRUD = this.getReviewCRUD();
		return reviewCRUD.getReviewList();
	}
	
	/**
	 * method to add reviews to a particular movie
	 * @param review
	 * @param rating
	 */
	public void addReview(String review, int rating) {
		ReviewCRUD<Review> reviewCRUD = this.getReviewCRUD();
		reviewCRUD.createReview(review, rating);
		this.reviewList = reviewCRUD.getReviewList();
	}
	
	/**
	 * method to print all the attributes of the movie
	 */
	public void printMovieDetail() {
		System.out.println(this.toDetailedString());
	}
	
	/**
	 * method to print the list of reviews of a particular movie
	 */
	public void printReview() {
		for (int i=0; i<this.reviewList.size(); ++i) {
			System.out.println(this.reviewList.get(i).toString());
		}
	}
}
