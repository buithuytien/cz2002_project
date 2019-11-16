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

public class PublicHolidayCRUD<T extends PublicHoliday> extends AbstractCRUD<T> {
	public PublicHolidayCRUD(Class<T> clazz) {
		this.dataList = new ArrayList<T>();
		this.dataClazz = clazz;
		this.read();
	}
	
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
	
	public boolean isExist(T object) {
		for (int i=0; i<this.getDataLength(); i++) {
			if (this.dataList.get(i).checkExistence(object))
				return true;
		}
		
		return false;
	}
	
	public boolean isPublicHoliday(LocalDate date) {
		for (int i=0; i<this.getDataLength(); i++) {
			if (this.dataList.get(i).match(date))
				return true;
		}
		
		return false;
	}
	
	public boolean isPublicHoliday(String dateStr) {

		LocalDate date = DateTimeHelper.convertStringToDate(dateStr);
		return this.isPublicHoliday(date);
	}
}
