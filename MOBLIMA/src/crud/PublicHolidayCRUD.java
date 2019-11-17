package crud;

import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

import entity.PublicHoliday;
import util.DateTimeHelper;
import util.TextDB;

/**
 * PublicHolidayCRUD inherits AbstractCRUD
 * whereby attributes from AbstractCRUD is replaced by attributes from PublicHoliday
 * @author Ronald
 *
 * @param <T>
 */
public class PublicHolidayCRUD<T extends PublicHoliday> extends AbstractCRUD<T> {
	/**
	 * constructor
	 * @param clazz
	 */
	public PublicHolidayCRUD(Class<T> clazz) {
		this.dataList = new ArrayList<T>();
		this.dataClazz = clazz;
		this.read();
	}
	
	/**
	 * method to create a public holiday 
	 * @param dateStr
	 * @param name
	 * @return public holiday object created
	 */
	public T createPublicHoliday(String dateStr, String name) {
		T object=null;
		try {
			object = this.dataClazz.getDeclaredConstructor(String.class, String.class).newInstance(dateStr, name);
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return object;
	}
	
	/**
	 * method to check if the holiday exists in the database
	 * returns true if the holiday already exists in the database
	 * @param object
	 * @return True or False
	 */
	public boolean isExist(T object) {
		for (int i=0; i<this.getDataLength(); i++) {
			if (this.dataList.get(i).checkExistence(object))
				return true;
		}
		
		return false;
	}
	
	/**
	 * method to check if the date is a public holiday
	 * returns true if the date is a public holiday
	 * method overloading
	 * @param date
	 * @return True or False
	 */
	public boolean isPublicHoliday(LocalDate date) {
		for (int i=0; i<this.getDataLength(); i++) {
			if (this.dataList.get(i).match(date))
				return true;
		}
		
		return false;
	}
	
	/**
	 * method to convert the date string into date format
	 * to call on isPublicHoliday method
	 * method overloading
	 * @param dateStr
	 * @return True or False
	 */
	public boolean isPublicHoliday(String dateStr) {

		LocalDate date = DateTimeHelper.convertStringToDate(dateStr);
		return this.isPublicHoliday(date);
	}
}
