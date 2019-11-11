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
	
	public boolean checkUsernameExist() {
		for (int i=0; i<this.getDataLength(); ++i) {
			if (this.dataList.get(i).checkUsernameExist())
				return true;
		}
		
		return false;
	}
	
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
