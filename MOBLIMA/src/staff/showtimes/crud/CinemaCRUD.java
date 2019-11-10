package staff.showtimes.crud;

import java.util.ArrayList;

import base.AbstractCRUD;
import staff.showtimes.entity.Cinema;

public class CinemaCRUD<T extends Cinema> extends AbstractCRUD<T> {
	public CinemaCRUD(Class<T> clazz, int cineplexId) {
		Cinema.setFileName(cineplexId);
		this.dataList = new ArrayList<T>();
		this.dataClazz = clazz;
		this.read();
	}
	
	public ArrayList<T> getCinemaList() {
		return this.dataList;
	}
	
	public Cinema getCinema(int idx) {
		return (Cinema)this.dataList.get(idx);
	}
}
