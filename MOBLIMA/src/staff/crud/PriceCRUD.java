package staff.crud;

import java.util.ArrayList;

import base.AbstractCRUD;
import staff.entity.Price;

public class PriceCRUD<T extends Price> extends AbstractCRUD<T> {
	public PriceCRUD(Class<T> clazz) {
		this.dataList = new ArrayList<T>();
		this.dataClazz = clazz;
		this.read();
	}
	
	public void update(int idx, double price) {
		this.dataList.get(idx).setPrice(price);
		this.save();
	}
}
