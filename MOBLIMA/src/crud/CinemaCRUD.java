package crud;

import java.util.ArrayList;

import entity.Cinema;
import enums.CinemaClass;

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
	
	public CinemaClass getCinemaType(int cinemaId) {
		for (int i=0; i<getDataLength(); ++i) {
			if (this.dataList.get(i).getId()==cinemaId)
				return this.dataList.get(i).getCinemaClass();
		}
		return null;
	}
}