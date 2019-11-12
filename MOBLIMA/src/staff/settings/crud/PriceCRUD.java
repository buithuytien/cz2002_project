package staff.settings.crud;

import java.util.ArrayList;

import base.AbstractCRUD;
import staff.settings.entity.Price;

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
	
	public T getElementPrice(Object o) {
		for (int i=0; i<getDataLength(); ++i) {
			if (this.dataList.get(i).match(o))
				return this.dataList.get(i);
		}
		return null;
	}
}
