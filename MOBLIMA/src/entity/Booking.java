package entity;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.StringTokenizer;

import cache.Cache;
import util.DateTimeHelper;
import util.TextDB;

/**
 * Booking inherits AbstractEntity
 * @author Ronald
 *
 */
public class Booking extends AbstractEntity {
	/**
	 * method to declare strings
	 */
	public static String directoryName="";
	public static String fileName="Booking.txt";
	
	/**
	 * username of the account
	 */
	private String username;
	/**
	 * transaction id for payments
	 */
	private String TID;
	/**
	 * id for the movie
	 */
	private int movieId;
	/**
	 * number of tickets
	 */
	private int numTicket;
	/**
	 * date and time
	 */
	private LocalDate date;
	private LocalTime time;
	
	/**
	 * constructor
	 * @param username
	 * @param movieId
	 * @param numTicket
	 * @param date
	 * @param time
	 * @param cineplexId
	 * @param cinemaId
	 */
	public Booking(String username, int movieId, int numTicket, LocalDate date, LocalTime time, int cineplexId, int cinemaId) {
		this.username = username;
		this.numTicket = numTicket;
		this.movieId = movieId;
		this.date = date;
		this.time = time;
		this.TID = "0"+cineplexId+cinemaId+DateTimeHelper.convertDateToTransactionString(date)+DateTimeHelper.convertTimeToTransactionString(time);
	}
	
	/**
	 * constructor to store the attributes of the booking object in a text file
	 * @param raw
	 */
	public Booking(String raw) {
		StringTokenizer star = new StringTokenizer(raw, TextDB.SEPERATOR);
		
		String username = star.nextToken().trim();
		String TID = star.nextToken().trim();
		String movieIdStr = star.nextToken().trim();
		String numTicketStr = star.nextToken().trim();
		String dateStr = star.nextToken().trim();
		String timeStr = star.nextToken().trim();
		
		this.username = username;
		this.TID = TID;
		this.numTicket = Integer.valueOf(numTicketStr);
		this.movieId = Integer.valueOf(movieIdStr);
		this.date = DateTimeHelper.convertStringToDate(dateStr);
		this.time = DateTimeHelper.convertStringToTime(timeStr);

	}
	@Override
	public int compareTo(AbstractEntity arg0) {
		Booking obj = (Booking) arg0;
		if (!this.username.equals(obj.getUsername()))
			return this.username.compareTo(obj.getUsername());
		if (!this.date.isEqual(obj.getDate()))
			return this.date.compareTo(obj.getDate());
		return this.time.compareTo(obj.getTime());
	}

	@Override
	public String processToDBString() {
		StringBuilder st = new StringBuilder();
		st.append(this.username);
		st.append(TextDB.SEPERATOR);
		st.append(this.TID);
		st.append(TextDB.SEPERATOR);
		st.append(this.movieId);
		st.append(TextDB.SEPERATOR);
		st.append(this.numTicket);
		st.append(TextDB.SEPERATOR);
		String dateStr = DateTimeHelper.convertDateToString(this.date);
		st.append(dateStr);
		st.append(TextDB.SEPERATOR);
		String timeStr = DateTimeHelper.convertTimeToString(this.time);
		st.append(timeStr);
		
		return st.toString();
	}

	@Override
	public String toString() {
		return this.processToDBString();
	}

	@Override
	public boolean checkExistence(AbstractEntity object) {
		// TODO Auto-generated method stub
		return false;
	}
	
	/**
	 * accessor method to get the account's username
	 * @return account's username
	 */
	public String getUsername() {
		return this.username;
	}
	
	/**
	 * accessor method to get the date
	 * @return the date
	 */
	public LocalDate getDate() {
		return this.date;
	}
	
	/**
	 * accessor method to get the time
	 * @return the time
	 */
	public LocalTime getTime() {
		return this.time;
	}

	/**
	 * method to get file path
	 * @return the file path
	 */
	public static String getFilePath() {
		String path = directoryName + "/" + fileName;
		File file = new File(Cache.DBPath+path);
		file.getParentFile().mkdirs();
		try {
			file.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return path;
	}
}
