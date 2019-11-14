package staff.entity;

import base.AbstractEntity;

/**
 * abstract class Price inherits AbstractEntity
 * @author Ronald
 *
 */
public abstract class Price extends AbstractEntity {
	/**
	 * price of the selected category of movie ticket
	 */
	protected double price;
	
	/**
	 * method to get the price of the movie ticket given the specific category
	 * @return
	 */
	public double getPrice() {
		return this.price;
	};

	/**
	 * method to set the price of the movie ticket given the specific category
	 * @param price
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	
	/**
	 * to check the enumeration of the object
	 * return true if input matches data saved in text file
	 * return false if input does not match data saved in text file
	 * to be override
	 * @param o
	 * @return
	 */
	public abstract boolean match(Object o);
}
