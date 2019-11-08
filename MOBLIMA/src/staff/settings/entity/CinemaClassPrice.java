package staff.settings.entity;

import java.util.StringTokenizer;

import base.AbstractEntity;
import staff.entity.enums.CinemaClass;
import util.TextDB;

public class CinemaClassPrice extends Price {
	public static String directoryName="Price";
	public static String fileName="CinemaClassPrice.txt";
	private CinemaClass cinemaClass;
	
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
		st.append(this.cinemaClass.getName());
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
