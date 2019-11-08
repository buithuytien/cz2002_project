package staff.movie.entity;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

import base.AbstractEntity;
import cache.Cache;
import staff.entity.enums.MovieRating;
import staff.entity.enums.MovieType;
import staff.entity.enums.ShowingStatus;
import staff.movie.crud.ReviewCRUD;
import util.TextDB;

public class Movie extends AbstractEntity {
	private static final String ARR_SEPERATOR = ",";
	public static String directoryName="";
	public static String fileName="Movie.txt";
	
	private int id;
	private String title;
	private ShowingStatus status;
	private MovieType type;
	private MovieRating movieRating;
	private String synopsis;
	private String director;
	private int ticketSales=0;
	private ArrayList<String> cast;
	private int rating=-1;
	private ArrayList<Review> reviewList;
	
	public Movie(int id, String title, int statusChoice, int typeChoice, int ratingChoice, 
			String synopsis, String director, ArrayList<String> cast) {
		this.id = id;
		this.title = title;
		this.status = ShowingStatus.values()[statusChoice];
		this.type = MovieType.values()[typeChoice];
		this.movieRating = MovieRating.values()[ratingChoice];
		this.synopsis = synopsis;
		this.director = director;
		this.cast = cast;
		this.reviewList = new ArrayList<Review>();
	}
	
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
		st.append(this.id);
		st.append(TextDB.SEPERATOR);
		st.append(this.title);
		st.append(TextDB.SEPERATOR);
		
		st.append(this.director);		
		st.append(TextDB.SEPERATOR);
		
		st.append(this.rating);
		
		return st.toString();
	}
	
	public String toDetailedString() {
		StringBuilder st = new StringBuilder();
		st.append(this.id);
		st.append("\n");
		st.append(this.title);
		st.append("\n");
		st.append(this.status);
		st.append("\n");
		st.append(this.type);
		st.append("\n");
		st.append(this.movieRating);
		st.append("\n");
		st.append(this.synopsis);
		st.append("\n");
		st.append(this.director);
		st.append("\n");
		
		for (int i=0; i<this.cast.size()-1; i++) {
			st.append(this.cast.get(i));
			st.append(ARR_SEPERATOR);
		}
		st.append(this.cast.get(this.cast.size()-1));
		
		st.append("\n");
		
		st.append(this.rating);
		
		return st.toString();
	}

	@Override
	public boolean checkExistence(AbstractEntity object) {
		// TODO Auto-generated method stub
		return ((Movie)object).getId() == this.id;
	}

	public int getId() {
		return this.id;
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public ShowingStatus getStatus() {
		return this.status;
	}
	
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
	
	public boolean isEndShowing() {
		return this.status == ShowingStatus.END_SHOWING;
	}
	
	public ReviewCRUD<Review> getReviewCRUD() {
		return new ReviewCRUD<Review>(Review.class, this.id);
	}
	
	public ArrayList<Review> getReviewList() {
		ReviewCRUD<Review> reviewCRUD = this.getReviewCRUD();
		return reviewCRUD.getReviewList();
	}
	
	public void addReview(String review, int rating) {
		ReviewCRUD<Review> reviewCRUD = this.getReviewCRUD();
		reviewCRUD.createReview(review, rating);
		this.reviewList = reviewCRUD.getReviewList();
	}
	
	public void printMovieDetail() {
		System.out.println(this.toDetailedString());
	}
	
	public void printReview() {
		for (int i=0; i<this.reviewList.size(); ++i) {
			System.out.println(this.reviewList.get(i).toString());
		}
	}
}
