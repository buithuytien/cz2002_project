package staff.settings.entity;

import base.AbstractEntity;

public abstract class Price extends AbstractEntity {
	protected double price;
	
	public double getPrice() {
		return this.price;
	};

	public void setPrice(double price) {
		this.price = price;
	}
	
	public abstract boolean match(Object o);
}
