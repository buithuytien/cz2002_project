package staff.entity;

import java.util.StringTokenizer;

import base.AbstractEntity;
import staff.entity.enums.CinemaClass;
import util.TextDB;

/**
 * CinemaClassPrice inherits Price
 * @author Ronald
 *
 */
public class CinemaClassPrice extends Price {
	/**
	 * method to declare strings
	 */
	public static String directoryName="Price";
	public static String fileName="CinemaClassPrice.txt";
	/**
	 * constructor for the different enumerations in CinemaClass
	 */
	private CinemaClass cinemaClass;
	
	/**
	 * to store the prices of each category of cinema class in a text file
	 * @param raw
	 */
	public CinemaClassPrice(String raw) {
		StringTokenizer star = new StringTokenizer(raw, TextDB.SEPERATOR);
		
		String cinemaClassStr = star.nextToken().trim();
		String priceStr = star.nextToken().trim();
		
		this.cinemaClass = CinemaClass.valueOf(cinemaClassStr);
		this.price = Double.valueOf(priceStr);
	};
	
	@Override
	public int compareTo(AbstractEntity o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean match(Object o) {
		return this.cinemaClass.equals((CinemaClass)o);
	}

	@Override
	public String processToDBString() {
		StringBuilder st = new StringBuilder();
		st.append(this.cinemaClass);
		st.append(TextDB.SEPERATOR);
		st.append(this.price);
		
		return st.toString();
	}

	@Override
	public String toString() {
		StringBuilder st = new StringBuilder();
		st.append(this.cinemaClass);
		st.append("->");
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
	 * @return
	 */
	public static String getFilePath() {
		return directoryName + "/" + fileName;
	}
}
