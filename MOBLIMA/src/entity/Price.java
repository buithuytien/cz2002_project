package entity;

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
	 * accessor method to get the price of the movie ticket given the specific category
	 * @return double value of the price
	 */
	public double getPrice() {
		return this.price;
	};

	/**
	 * mutator method to set the price of the movie ticket given the specific category
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
	 * @return True or False
	 */
	public abstract boolean match(Object o);
}
