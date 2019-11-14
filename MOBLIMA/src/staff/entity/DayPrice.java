package staff.entity;

import java.util.StringTokenizer;

import base.AbstractEntity;
import staff.entity.enums.DayType;
import util.TextDB;

/**
 * DayPrice inherits Price
 * @author Ronald
 *
 */
public class DayPrice extends Price {
	/**
	 * methods to declare strings
	 */
	public static String directoryName="Price";
	public static String fileName="DayPrice.txt";
	/**
	 * constructor for the different enumerations in DayType
	 */
	private DayType dayType;
	
	/**
	 * stores the dayType and price of each type of day in a text file
	 * @param raw
	 */
	public DayPrice(String raw) {
		StringTokenizer star = new StringTokenizer(raw, TextDB.SEPERATOR);
		
		String dayTypeStr = star.nextToken().trim();
		String priceStr = star.nextToken().trim();
		
		this.dayType = DayType.valueOf(dayTypeStr);
		this.price = Double.valueOf(priceStr);
	};
	
	@Override
	public int compareTo(AbstractEntity o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean match(Object o) {
		return this.dayType.equals((DayType) o);
	}

	@Override
	public String processToDBString() {
		StringBuilder st = new StringBuilder();
		st.append(this.dayType);
		st.append(TextDB.SEPERATOR);
		st.append(this.price);
		
		return st.toString();
	}

	@Override
	public String toString() {
		StringBuilder st = new StringBuilder();
		st.append(this.dayType);
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
