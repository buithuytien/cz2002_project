package util;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class DateTimeHelper {
	public static final String DATE_FORMAT="d-MM-yyyy";
	public static final String TIME_FORMAT="HH:mm";
	
	public static LocalDate convertStringToDate(String dateStr) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMAT);
		return LocalDate.parse(dateStr, formatter);
	}
	
	public static String convertDateToString(LocalDate date) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMAT);
		return date.format(formatter);
	}
	
	public static LocalTime convertStringToTime(String timeStr) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(TIME_FORMAT);
		return LocalTime.parse(timeStr, formatter);
	}
	
	public static String convertTimeToString(LocalTime time) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(TIME_FORMAT);
		return time.format(formatter);
	}
}
