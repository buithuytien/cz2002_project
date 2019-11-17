package crud;

import java.util.ArrayList;

import entity.Cineplex;

/**
 * CineplexCRUD extends AbstractCRUD 
 * whereby attributes from AbstractCRUD is replaced by attributes from Cineplex
 * @author Ronald
 *
 * @param <T>
 */
public class CineplexCRUD<T extends Cineplex> extends AbstractCRUD<T> {
	/**
	 * constructor
	 * @param clazz
	 */
	public CineplexCRUD(Class<T> clazz) {
		this.dataList = new ArrayList<T>();
		this.dataClazz = clazz;
		this.read();
	}
	
	/**
	 * accessor method to get the details of the cineplex
	 * @param idx
	 * @return list of cineplex objects with its attributes
	 */
	public Cineplex getCineplex(int idx) {
		return (Cineplex)this.dataList.get(idx);
	}
}
