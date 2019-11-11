package staff.settings.entity;

import java.util.StringTokenizer;

import base.AbstractEntity;
import staff.entity.enums.DayType;
import util.TextDB;

public class DayPrice extends Price {
	public static String directoryName="Price";
	public static String fileName="DayPrice.txt";
	private DayType dayType;
	
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
		st.append("DayType - ");
		st.append(this.dayType);
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

	public static String getFilePath() {
		return directoryName + "/" + fileName;
	}
}
