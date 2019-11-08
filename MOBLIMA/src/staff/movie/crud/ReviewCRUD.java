package staff.movie.crud;

import java.util.ArrayList;

import base.AbstractCRUD;
import cache.Cache;
import staff.movie.entity.Review;

public class ReviewCRUD<T extends Review> extends AbstractCRUD<T> {
	public ReviewCRUD(Class<T> clazz, int movieId) {
		Review.setFileName(movieId);
		this.dataList = new ArrayList<T>();
		this.dataClazz = clazz;
		this.read();
	}
	
	public ArrayList<T> getReviewList() {
		return this.dataList;
	}
	
	public void createReview(String review, int rating) {
		Review obj = new Review(Cache.getUsername(), review, rating);
		this.create((T)obj);
	}
}
