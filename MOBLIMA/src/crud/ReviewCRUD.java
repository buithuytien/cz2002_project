package crud;

import java.util.ArrayList;

import cache.Cache;
import entity.Review;

/**
 * ReviewCRUD inherits AbstractCRUD
 * whereby attributes from AbstractCRUD is replaced by attributes from Review
 * @author Ronald
 *
 * @param <T>
 */
public class ReviewCRUD<T extends Review> extends AbstractCRUD<T> {
	/**
	 * constructor
	 * @param clazz
	 * @param movieId
	 */
	public ReviewCRUD(Class<T> clazz, int movieId) {
		Review.setFileName(movieId);
		this.dataList = new ArrayList<T>();
		this.dataClazz = clazz;
		this.read();
	}
	
	/**
	 * accessor method to get list of reviews
	 * @return list of reviews
	 */
	public ArrayList<T> getReviewList() {
		return this.dataList;
	}
	
	/**
	 * method to create review object
	 * attributes of this review object is the user's username, reviews and ratings of the movie
	 * @param review
	 * @param rating
	 */
	public void createReview(String review, int rating) {
		Review obj = new Review(Cache.getUsername(), review, rating);
		this.create((T)obj);
	}
	
	/**
	 * method that return true if the username exists in the database of saved usernames
	 * @return True of False
	 */
	public boolean checkUsernameExist() {
		for (int i=0; i<this.getDataLength(); ++i) {
			if (this.dataList.get(i).checkUsernameExist())
				return true;
		}
		
		return false;
	}
	
	/**
	 * method to calculate the average of the ratings of each movie based on user's given ratings
	 * @return the double value of the average rating of the movie
	 */
	public double computeRating() {
		int N = this.getDataLength();
		if (N==0)
			return -1;
		int sum = 0;
		for (int i=0; i<N; ++i) {
			sum+=this.dataList.get(i).getRating();
		}
		double res = (double)sum/N;
		
		return Math.round(res * 10) / 10.0;
	}
}
