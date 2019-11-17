package entity;

import java.io.File;
import java.io.IOException;
import java.util.StringTokenizer;

import cache.Cache;
import util.TextDB;

/**
 * Review inherits AbstractEntity
 * @author Ronald
 *
 */
public class Review extends AbstractEntity {
	/**
	 * method to declare strings
	 */
	public static String directoryName="Review";
	public static String fileName;
//	private int id;
//	private int movieId;
	/**
	 * username of the user's account
	 */
	private String username;
	/**
	 * review of the user on a particular movie
	 */
	private String review;
	/**
	 * ratings of the particular movie 
	 */
	private int rating;
	
	/**
	 * constructor
	 * @param username
	 * @param review
	 * @param rating
	 */
	public Review(String username, String review, int rating) {
		this.username = username;
		this.review = review;
		this.rating = rating;
	}
	
	/**
	 * constructor to store the user's username, review of the movie and the rating given in a text file
	 * @param raw
	 */
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
		st.append("Username - ");
		st.append(this.username);		
		st.append("\n");
		st.append("Review - ");
		st.append(this.review);		
		st.append("\n");
		st.append("Rating - ");
		st.append(this.rating);

		return st.toString();
	}

	/**
	 * method that return true if the username exists in the database of usernames
	 * @return True or False
	 */
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

	/**
	 * accessor method to get the rating of the movie
	 * @return integer value of the rating
	 */
	public int getRating() {
		return this.rating;
	}
	
	/**
	 * method to create a text file named after the movie
	 * @param movieId
	 */
	public static void setFileName(int movieId) {
		fileName = Integer.toString(movieId) + ".txt";
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
	
	
}
