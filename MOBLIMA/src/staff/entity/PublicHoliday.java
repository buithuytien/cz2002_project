package staff.entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringTokenizer;

import base.AbstractEntity;
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
	 * method to declare the format of the string for the date
	 */
	public static final String FORMAT="dd/MM/yyyy";
	/**
	 * date of the holiday
	 */
	private Date date;
	/**
	 * name of the holiday
	 */
	private String name;
	
	/**
	 * method to handle exceptions where format of date is entered wrongly 
	 * @param dateStr
	 * @param name
	 */
	public PublicHoliday(String dateStr, String name) {
		try {
			this.date = new SimpleDateFormat(FORMAT).parse(dateStr);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.name = name;
	}
	
	/**
	 * method to store the date and name of the holiday in a text file
	 * @param raw
	 */
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

	/**
	 * to check if date entered is a saved public holiday
	 * return true if the date matches the data saved in the text file
	 * return false if the date does not match the date saved in the text file
	 * @param date
	 * @return
	 */
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

	/**
	 * method to get the date of saved holiday
	 * @return
	 */
	public Date getDate() {
		return this.date;
	}
	
	/**
	 * method to get file path
	 * @return
	 */
	public static String getFilePath() {
		return directoryName + "/" + fileName;
	}
}
