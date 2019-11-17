package crud;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import entity.Booking;

/**
 * BookingCRUD inherits AbstractCRUD
 * whereby attributes from AbstractCRUD is replaced by attributes from Booking
 * @author Ronald
 *
 * @param <T>
 */
public class BookingCRUD<T extends Booking> extends AbstractCRUD<T> {
	/**
	 * constructor
	 * @param clazz
	 */
	public BookingCRUD(Class<T> clazz) {
		this.dataList = new ArrayList<T>();
		this.dataClazz = clazz;
		this.read();
	}
	
	/**
	 * method to create new object, which is the booking of the movie tickets
	 * given the parameters as attributes
	 * @param username
	 * @param movieId
	 * @param numTicket
	 * @param date
	 * @param time
	 * @param cineplexId
	 * @param cinemaId
	 */
	public void createBooking(String username, int movieId, int numTicket, LocalDate date, LocalTime time, int cineplexId, int cinemaId) {
		Booking book = new Booking(username, movieId, numTicket, date, time, cineplexId, cinemaId);
		this.create((T)book);
	}
	
	/**
	 * method to print the booking history of a user
	 * @param username
	 */
	public void printHistoryBooking(String username) {
		System.out.println("Booking history of user "+username);
		for (int i=0; i<getDataLength(); ++i) {
			if (this.dataList.get(i).getUsername().equals(username)) {
				System.out.println(this.dataList.get(i).toString());
			}
		}
	}
}
