package staff.entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringTokenizer;

import base.AbstractEntity;
import util.TextDB;

public class PublicHoliday extends AbstractEntity {
	public static String directoryName="";
	public static String fileName="PublicHoliday.txt";
	public static final String FORMAT="dd/MM/yyyy";
	private Date date;
	private String name;
	
	public PublicHoliday(String dateStr, String name) {
		try {
			this.date = new SimpleDateFormat(FORMAT).parse(dateStr);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.name = name;
	}
	
	public PublicHoliday(String raw) {
		StringTokenizer star = new StringTokenizer(raw, TextDB.SEPERATOR);
		
		String dateStr = star.nextToken().trim();
		String name = star.nextToken().trim();
		
		try {
			this.date = new SimpleDateFormat(FORMAT).parse(dateStr);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.name = name;
	}
	
	@Override
	public int compareTo(AbstractEntity object) {
		if (((PublicHoliday)object).getDate().before(this.date))
			return 1;
		else
			return -1;
	}

	public boolean match(Date date) {
		return this.date.equals(date);
	}
	
	@Override
	public String processToDBString() {
		StringBuilder st = new StringBuilder();
		SimpleDateFormat formatter = new SimpleDateFormat(FORMAT); 
		String dateStr = formatter.format(this.date);
		st.append(dateStr.trim());
		st.append(TextDB.SEPERATOR);
		st.append(this.name.trim());
		
		return st.toString();
	}

	@Override
	public String toString() {
		return this.processToDBString();
	}

	@Override
	public boolean checkExistence(AbstractEntity object) {
		if (((PublicHoliday)object).getDate().equals(this.date))
			return true;
		return false;
	}

	public Date getDate() {
		return this.date;
	}
	
	public static String getFilePath() {
		return directoryName + "/" + fileName;
	}
}
