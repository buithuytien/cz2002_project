package staff.settings.entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.StringTokenizer;

import base.AbstractEntity;
import util.DateTimeHelper;
import util.TextDB;

public class PublicHoliday extends AbstractEntity {
	public static String directoryName="";
	public static String fileName="PublicHoliday.txt";
	private LocalDate date;
	private String name;
	
	
	public PublicHoliday(String dateStr, String name) {
		this.date = DateTimeHelper.convertStringToDate(dateStr);
		
		this.name = name;
	}
	
	public PublicHoliday(String raw) {
		StringTokenizer star = new StringTokenizer(raw, TextDB.SEPERATOR);
		
		String dateStr = star.nextToken().trim();
		String name = star.nextToken().trim();
		this.date = DateTimeHelper.convertStringToDate(dateStr);
		
		this.name = name;
	}
	
	@Override
	public int compareTo(AbstractEntity object) {
		if (((PublicHoliday)object).getDate().isBefore(this.date))
			return 1;
		else
			return -1;
	}

	public boolean match(LocalDate date) {
		return this.date.equals(date);
	}
	
	@Override
	public String processToDBString() {
		StringBuilder st = new StringBuilder();

		String dateStr = DateTimeHelper.convertDateToString(this.date);
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

	public LocalDate getDate() {
		return this.date;
	}
	
	public static String getFilePath() {
		return directoryName + "/" + fileName;
	}
}
