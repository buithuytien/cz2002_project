package entity;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.StringTokenizer;

import cache.Cache;
import crud.MovieCRUD;
import util.DateTimeHelper;
import util.TextDB;

/**
 * Showtimes inherits AbstractEntity
 * @author Ronald
 *
 */
public class Showtimes extends AbstractEntity {
	/**
	 * method to declare strings
	 */
	public static String directoryName="Showtimes";
	public static String fileName="";
	
	private static int cineplexId;
	private static LocalDate date;
	
	/**
	 * id of the cineplex
	 */
	private int cinemaId;
	/**
	 * current time
	 */
	private LocalTime time;
	/**
	 * id of the movie
	 */
	private int movieId;
	/**
	 * row and column value of seats, based on Seat class
	 */
	private Seat seat;
	
	/**
	 * constructor
	 * @param cinema
	 * @param timeStr
	 * @param movie
	 */
	public Showtimes(Cinema cinema, String timeStr, Movie movie) {
		this.cinemaId = cinema.getId();
		
		this.time = DateTimeHelper.convertStringToTime(timeStr);
		this.movieId = movie.getId();
		
		
		this.seat = new Seat(cinema.getRow(), cinema.getCol(), this.getSeatFilePath());
	}
	
	/**
	 * constructor to store the cinemaid, time movie begins and the movieid
	 * store these details in a text file
	 * @param raw
	 */
	public Showtimes(String raw) {
		StringTokenizer star = new StringTokenizer(raw, TextDB.SEPERATOR);
		
		String cinemaIdStr = star.nextToken().trim();
		String timeStr = star.nextToken().trim();
		String movieIdStr = star.nextToken().trim();
		
		this.cinemaId = Integer.valueOf(cinemaIdStr);
		
		this.time = DateTimeHelper.convertStringToTime(timeStr);
		this.movieId = Integer.valueOf(movieIdStr);
		
		this.seat = new Seat(this.getSeatFilePath());
	}
	
	/**
	 * method to calculate the end time of the particular movie
	 * @return the end time of the movie
	 */
	public LocalTime computeEndTime() {
		MovieCRUD<Movie> crud = new MovieCRUD<>(Movie.class);
		Movie movie = crud.getMovieById(this.movieId);
		return this.time.plusMinutes(movie.getDuration());
	}
	
	@Override
	public int compareTo(AbstractEntity arg0) {
		if (((Showtimes)arg0).getCinemaId()!=this.cinemaId) {
			return this.cinemaId - ((Showtimes)arg0).getCinemaId();
		} else {
			if (((Showtimes)arg0).getStartTime().isBefore(this.time))
				return -1;
			else 
				return 1;
		}
	}

	@Override
	public String processToDBString() {
		StringBuilder st = new StringBuilder();
		st.append(this.cinemaId);
		st.append(TextDB.SEPERATOR);
		String timeStr = DateTimeHelper.convertTimeToString(this.time);
		st.append(timeStr.trim());
		st.append(TextDB.SEPERATOR);
		st.append(this.movieId);
		
		return st.toString();
	}

	@Override
	public String toString() {
		MovieCRUD<Movie> movieCRUD = new MovieCRUD<>(Movie.class);
		StringBuilder st = new StringBuilder();
		st.append("CinemaID - ");
		st.append(this.cinemaId);
		st.append(TextDB.SEPERATOR);
		st.append("Time - ");
		String timeStr = DateTimeHelper.convertTimeToString(this.time);
		st.append(timeStr.trim());
		st.append(TextDB.SEPERATOR);
		st.append("Title - ");
		st.append(movieCRUD.getMovieById(this.movieId).getTitle());
		
		return st.toString();
	}

	@Override
	public boolean checkExistence(AbstractEntity object) {
		// TODO Auto-generated method stub
		return false;
	}
	
	/**
	 * accessor method to get date of the movie showing
	 * @return date of the movie showing
	 */
	public static LocalDate getDate() {
		return Showtimes.date;
	}
	
	/**
	 * accessor method to get id of cineplex
	 * @return showtimes object of the cineplex
	 */
	public static int getCineplexId() {
		return Showtimes.cineplexId;
	}
	
	/**
	 * accessor method to get id of cinema
	 * @return id of cinema
	 */
	public int getCinemaId() {
		return this.cinemaId;
	}
	
	/**
	 * accessor method to get id of movie
	 * @return id of movie
	 */
	public int getMovieId() {
		return this.movieId;
	}
	
	/**
	 * accessor method to get starting time of the movie
	 * @return start time of the movie
	 */
	public LocalTime getStartTime() {
		return this.time;
	}
	
	/**
	 * method to display UI of available seats 
	 */
	public void viewSeat() {
		this.seat.viewSeat();
		if (this.seat.isFull())
			System.out.println("No seat is available!");
	}
	
	/**
	 * method to call the method from Seat class to get number of seats that are taken
	 * @return integer value of number of seats not available
	 */
	public int getNoSeatAvailable() {
		return this.seat.getNoSeatAvailable();
	}
	
	/**
	 * method to call the method from Seat class to check if all the seats are taken
	 * returns true if all seats are taken 
	 * @return True or False
	 */
	public boolean isFull() {
		return this.seat.isFull();
	}
	
	/**
	 * method to call the method from Seat class to check if the particular seat is available
	 * @param row
	 * @param col
	 * @return True or False
	 */
	public boolean isAvailableSeat(int row, int col) {
		return this.seat.isAvailableSeat(row, col);
	}
	
	/**
	 * method to call the method from Seat class to book an avaiable seat
	 * @param row
	 * @param col
	 */
	public void takeSeat(int row, int col) {
		this.seat.takeSeat(row, col);
	}
	
	/**
	 * method to create a text file base on the cineplex and date
	 * @param cineplexId
	 * @param dateStr
	 */
	public static void setFileName(int cineplexId, String dateStr) {
		fileName = Integer.toString(cineplexId)+"/"+dateStr + ".txt";
		Showtimes.date = DateTimeHelper.convertStringToDate(dateStr);
		Showtimes.cineplexId = cineplexId;
	}
	
	/**
	 * method to get the file path
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
	
	/**
	 * method to get file path of the seatings for a particular date time
	 * @return the file path
	 */
	public String getSeatFilePath() {

		String dateStr = DateTimeHelper.convertDateToString(Showtimes.date);
		String timeStr = DateTimeHelper.convertTimeToString(this.time);
		String path = directoryName+"/"+cineplexId+"/"+dateStr+"/"+timeStr+".txt";
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
