package staff.entity;

import java.util.StringTokenizer;

import base.AbstractEntity;
import util.TextDB;

public class AgePrice extends Price {
	public static String directoryName="Price";
	public static String fileName="AgePrice.txt";
	private int startAge;
	private int endAge;
	

	public AgePrice(String raw) {
		StringTokenizer star = new StringTokenizer(raw, TextDB.SEPERATOR);
		
		int startAge = Integer.valueOf(star.nextToken().trim());
		int endAge = Integer.valueOf(star.nextToken().trim());
		double price = Double.valueOf(star.nextToken().trim());
		
		this.startAge = startAge;
		this.endAge = endAge;
		this.price = price;
	}
	
	@Override
	public int compareTo(AbstractEntity o) {
		if (this.startAge < ((AgePrice)o).getStartAge())
			return -1;
		else
			return 1;
	}

	@Override
	public boolean match(Object o) {
		if ((int)o>=this.startAge && (int)o<=this.endAge)
			return true;
		return false;
	}

	@Override
	public String processToDBString() {
		StringBuilder st = new StringBuilder();
		st.append(this.startAge);
		st.append(TextDB.SEPERATOR);
		st.append(this.endAge);
		st.append(TextDB.SEPERATOR);
		st.append(this.price);
		return st.toString();
	}

	@Override
	public String toString() {
		StringBuilder st = new StringBuilder();
		st.append("Age from ");
		st.append(this.startAge);
		st.append(" to ");
		st.append(this.endAge);
		st.append("->");
		st.append(this.price);
		st.append("SGD");
		return st.toString();
	}

	@Override
	public boolean checkExistence(AbstractEntity object) {
		// TODO Auto-generated method stub
		return false;
	}

	public int getStartAge() {
		return this.startAge;
	}
	
	public static String getFilePath() {
		return directoryName + "/" + fileName;
	}
}
