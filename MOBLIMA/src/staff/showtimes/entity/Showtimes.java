package staff.showtimes.entity;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.StringTokenizer;

import base.AbstractEntity;
import cache.Cache;
import staff.movie.crud.MovieCRUD;
import staff.movie.entity.Movie;
import util.DateTimeHelper;
import util.TextDB;

public class Showtimes extends AbstractEntity {
	public static String directoryName="Showtimes";
	public static String fileName="";
	
	private static int cineplexId;
	private static LocalDate date;
	
	private int cinemaId;
	private LocalTime time;
	private int movieId;
	private Seat seat;
	
	public Showtimes(Cinema cinema, String timeStr, Movie movie) {
		this.cinemaId = cinema.getId();
		
		this.time = DateTimeHelper.convertStringToTime(timeStr);
		this.movieId = movie.getId();
		
		
		this.seat = new Seat(cinema.getRow(), cinema.getCol(), this.getFilePath());
	}
	
	public Showtimes(String raw) {
		StringTokenizer star = new StringTokenizer(raw, TextDB.SEPERATOR);
		
		String cinemaIdStr = star.nextToken().trim();
		String timeStr = star.nextToken().trim();
		String movieIdStr = star.nextToken().trim();
		
		this.cinemaId = Integer.valueOf(cinemaIdStr);
		
		this.time = DateTimeHelper.convertStringToTime(timeStr);
		this.movieId = Integer.valueOf(movieIdStr);
		
		this.seat = new Seat(this.getFilePath());
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
		st.append(this.cinemaId);
		
		String timeStr = DateTimeHelper.convertTimeToString(this.time);
		st.append(timeStr.trim());
		st.append(TextDB.SEPERATOR);
		st.append(movieCRUD.getMovieById(this.movieId).getTitle());
		
		return st.toString();
	}

	@Override
	public boolean checkExistence(AbstractEntity object) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public int getCinemaId() {
		return this.cinemaId;
	}
	
	public LocalTime getStartTime() {
		return this.time;
	}
	
	public static void setFileName(int cineplexId, String dateStr) {
		fileName = Integer.toString(cineplexId)+"/"+dateStr + ".txt";
		date = DateTimeHelper.convertStringToDate(dateStr);
	}
	
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
	
	public String getSeatFilePath() {

		String dateStr = DateTimeHelper.convertDateToString(Showtimes.date);
		String timeStr = DateTimeHelper.convertTimeToString(this.time);
		String path = cineplexId+"/"+dateStr+"/"+timeStr+".txt";
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
