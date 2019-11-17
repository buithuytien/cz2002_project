package entity;

import java.util.StringTokenizer;

import enums.MovieType;
import util.TextDB;

/**
 * MovieTypePrice inherits Price 
 * @author Ronald
 *
 */
public class MovieTypePrice extends Price {
	/**
	 * method to declare strings
	 */
	public static String directoryName="Price";
	public static String fileName="MovieTypePrice.txt";
	/**
	 * initializing the different enumerations in MovieType
	 */
	private MovieType movieType;
	
	/**
	 * constructor to store the price of each type of movie in a text file
	 * @param raw
	 */
	public MovieTypePrice(String raw) {
		StringTokenizer star = new StringTokenizer(raw, TextDB.SEPERATOR);
		
		String movieTypeStr = star.nextToken().trim();
		String priceStr = star.nextToken().trim();
		
		this.movieType = MovieType.valueOf(movieTypeStr);
		this.price = Double.valueOf(priceStr);
	};
	@Override
	public boolean match(Object o) {
		return this.movieType.equals((MovieType)o);
	}
	
	@Override
	public int compareTo(AbstractEntity o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String processToDBString() {
		StringBuilder st = new StringBuilder();
		st.append(this.movieType);
		st.append(TextDB.SEPERATOR);
		st.append(this.price);
		
		return st.toString();
	}

	@Override
	public String toString() {
		StringBuilder st = new StringBuilder();
		st.append("Movie type - ");
		st.append(this.movieType.getName());
		st.append("->");
		st.append("Price - ");
		st.append(this.price);
		st.append("SGD");
		return st.toString();
	}

	@Override
	public boolean checkExistence(AbstractEntity object) {
		// TODO Auto-generated method stub
		return true;
	}

	/**
	 * method to get file path
	 * @return the file path
	 */
	public static String getFilePath() {
		return directoryName + "/" + fileName;
	}
}
