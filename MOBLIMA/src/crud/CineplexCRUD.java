package crud;

import java.util.ArrayList;

import entity.Cineplex;

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
