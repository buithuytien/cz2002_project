package staff.showtimes.crud;

import java.util.ArrayList;

import base.AbstractCRUD;
import staff.showtimes.entity.Showtimes;

public class ShowtimesCRUD<T extends Showtimes> extends AbstractCRUD<T> {
	public ShowtimesCRUD(Class<T> clazz, int cineplexId, String dateStr) {
		Showtimes.setFileName(cineplexId, dateStr);
		this.dataList = new ArrayList<T>();
		this.dataClazz = clazz;
		this.read();
	}
	
}
