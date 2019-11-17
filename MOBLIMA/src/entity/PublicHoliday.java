package entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.StringTokenizer;

import util.DateTimeHelper;
import util.TextDB;

/**
 * PublicHoliday inherits AbstractEntity
 * @author Ronald
 *
 */
public class PublicHoliday extends AbstractEntity {
	/**
	 * method to declare strings
	 */
	public static String directoryName="";
	public static String fileName="PublicHoliday.txt";
	/**
	 * date of the holiday
	 */
	private LocalDate date;
	/**
	 * name of the holiday
	 */
	private String name;
	
	/**
	 * constructor 
	 * converts date to a string 
	 * @param dateStr
	 * @param name
	 */
	public PublicHoliday(String dateStr, String name) {
		this.date = DateTimeHelper.convertStringToDate(dateStr);
		
		this.name = name;
	}
	
	/**
	 * constructor method to store the date and name of the holiday in a text file
	 * @param raw
	 */
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

	/**
	 * method to check if input date matches current date
	 * returns true if the date matches
	 * @param date
	 * @return True or False
	 */
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

	/**
	 * accessor method to get the date of the saved holiday
	 * @return date
	 */
	public LocalDate getDate() {
		return this.date;
	}
	
	/**
	 * method to get file path
	 * @return the file path
	 */
	public static String getFilePath() {
		return directoryName + "/" + fileName;
	}
}
