package crud;

import java.util.ArrayList;

import entity.Cinema;
import enums.CinemaClass;

/**
 * CinemaCRUD extends AbstractCRUD 
 * whereby attributes from AbstractCRUD is replaced by attributes from Cinema
 * @author Ronald
 *
 * @param <T>
 */
public class CinemaCRUD<T extends Cinema> extends AbstractCRUD<T> {
	/**
	 * constructor
	 * @param clazz
	 * @param cineplexId
	 */
	public CinemaCRUD(Class<T> clazz, int cineplexId) {
		Cinema.setFileName(cineplexId);
		this.dataList = new ArrayList<T>();
		this.dataClazz = clazz;
		this.read();
	}
	
	/**
	 * accessor method to get the list of cinemas
	 * @return list of cinemas
	 */
	public ArrayList<T> getCinemaList() {
		return this.dataList;
	}
	
	/**
	 * accessor method to get the cinema based on the id
	 * @param idx
	 * @return list of cinema objects and its attributes
	 */
	public Cinema getCinema(int idx) {
		return (Cinema)this.dataList.get(idx);
	}
	
	/**
	 * accessor method to get the cinema type based on enumerations in CinemaClass class
	 * @param cinemaId
	 * @return list of cinema and its class categories 
	 */
	public CinemaClass getCinemaType(int cinemaId) {
		for (int i=0; i<getDataLength(); ++i) {
			if (this.dataList.get(i).getId()==cinemaId)
				return this.dataList.get(i).getCinemaClass();
		}
		return null;
	}
}