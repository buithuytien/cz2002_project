package user.book.crud;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import base.AbstractCRUD;
import user.book.entity.Booking;

public class BookingCRUD<T extends Booking> extends AbstractCRUD<T> {
	public BookingCRUD(Class<T> clazz) {
		this.dataList = new ArrayList<T>();
		this.dataClazz = clazz;
		this.read();
	}
	
	public void createBooking(String username, int movieId, int numTicket, LocalDate date, LocalTime time, int cineplexId, int cinemaId) {
		Booking book = new Booking(username, movieId, numTicket, date, time, cineplexId, cinemaId);
		this.create((T)book);
	}
	
	public void printHistoryBooking(String username) {
		System.out.println("Booking history of username "+username);
		for (int i=0; i<getDataLength(); ++i) {
			if (this.dataList.get(i).getUsername().equals(username)) {
				System.out.println(this.dataList.get(i).toString());
			}
		}
	}
}
