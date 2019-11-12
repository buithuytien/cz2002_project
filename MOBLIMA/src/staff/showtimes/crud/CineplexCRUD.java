package staff.showtimes.crud;

import java.util.ArrayList;

import base.AbstractCRUD;
import staff.showtimes.entity.Cineplex;

public class CineplexCRUD<T extends Cineplex> extends AbstractCRUD<T> {
	public CineplexCRUD(Class<T> clazz) {
		this.dataList = new ArrayList<T>();
		this.dataClazz = clazz;
		this.read();
	}
	
	public Cineplex getCineplex(int idx) {
		return (Cineplex)this.dataList.get(idx);
	}
}
