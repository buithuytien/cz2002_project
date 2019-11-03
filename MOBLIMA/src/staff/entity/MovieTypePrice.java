package staff.entity;

import java.util.StringTokenizer;

import base.AbstractEntity;
import util.TextDB;

public class MovieTypePrice extends Price {
	public static String directoryName="Price";
	public static String fileName="MovieTypePrice.txt";
	private MovieType movieType;
	
	public MovieTypePrice(String raw) {
		StringTokenizer star = new StringTokenizer(raw, TextDB.SEPERATOR);
		
		String movieTypeStr = star.nextToken().trim();
		String priceStr = star.nextToken().trim();
		
		this.movieType = MovieType.valueOf(movieTypeStr);
		this.price = Double.valueOf(priceStr);
	};
	
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
		st.append(this.movieType);
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

	public static String getFilePath() {
		return directoryName + "/" + fileName;
	}
}
