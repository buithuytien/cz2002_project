package staff.movie.entity;

import java.io.File;
import java.io.IOException;
import java.util.StringTokenizer;

import base.AbstractEntity;
import cache.Cache;
import util.TextDB;

public class Review extends AbstractEntity {
	public static String directoryName="Review";
	public static String fileName;
//	private int id;
//	private int movieId;
	private String username;
	private String review;
	private int rating;
	
	public Review(String username, String review, int rating) {
		this.username = username;
		this.review = review;
		this.rating = rating;
	}
	
	public Review(String raw) {
		StringTokenizer star = new StringTokenizer(raw, TextDB.SEPERATOR);
		
		String username = star.nextToken().trim();
		String review = star.nextToken().trim();
		String ratingStr = star.nextToken().trim();
		
		this.username = username;
		this.review = review;
		this.rating = Integer.valueOf(ratingStr);
	}
	
	@Override
	public int compareTo(AbstractEntity arg0) {
		return 0;
	}

	@Override
	public String processToDBString() {
		StringBuilder st = new StringBuilder();
//		st.append(this.id);
//		st.append(TextDB.SEPERATOR);
//		st.append(this.movieId);
//		st.append(TextDB.SEPERATOR);
		st.append(this.username);		
		st.append(TextDB.SEPERATOR);
		st.append(this.review);		
		st.append(TextDB.SEPERATOR);
		st.append(this.rating);
		
		return st.toString();
	}

	@Override
	public String toString() {
		StringBuilder st = new StringBuilder();
//		st.append(this.id);
//		st.append("\n");
		st.append(this.username);		
		st.append("\n");
		st.append(this.review);		
		st.append("\n");
		st.append(this.rating);
		
		return st.toString();
	}

	public boolean checkUsernameExist() {
		return this.username.equals(Cache.getUsername());
	}
	
	@Override
	public boolean checkExistence(AbstractEntity object) {
		// TODO Auto-generated method stub
//		return ((Review)object).getId() == this.id;
		return false;
	}
	
//	public int getId() {
//		return this.id;
//	}

	public int getRating() {
		return this.rating;
	}
	
	public static void setFileName(int movieId) {
		fileName = Integer.toString(movieId) + ".txt";
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
	
	
}
