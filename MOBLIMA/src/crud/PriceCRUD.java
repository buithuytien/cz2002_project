package crud;

import java.util.ArrayList;

import entity.Price;

/**
 * PriceCRUD inherits AbstractCRUD
 * whereby attributes from AbstractCRUD is replaced by attributes from Price
 * @author Ronald
 *
 * @param <T>
 */
public class PriceCRUD<T extends Price> extends AbstractCRUD<T> {
	/**
	 * constructor
	 * @param clazz
	 */
	public PriceCRUD(Class<T> clazz) {
		this.dataList = new ArrayList<T>();
		this.dataClazz = clazz;
		this.read();
	}
	
	/**
	 * method to update the list
	 * @param idx
	 * @param price
	 */
	public void update(int idx, double price) {
		this.dataList.get(idx).setPrice(price);
		this.save();
	}
	
	/**
	 * method to get the price of the ticket
	 * @param o
	 * @return list of pricing given the object
	 */
	public T getElementPrice(Object o) {
		for (int i=0; i<getDataLength(); ++i) {
			if (this.dataList.get(i).match(o))
				return this.dataList.get(i);
		}
		return null;
	}
}
