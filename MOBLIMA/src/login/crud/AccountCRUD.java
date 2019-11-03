package login.crud;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

import base.AbstractCRUD;
import login.entity.Account;

public class AccountCRUD <T extends Account> extends AbstractCRUD<T> {
	public AccountCRUD(Class<T> clazz){
		this.dataList = new ArrayList<T>();
		this.dataClazz = clazz;
		this.read();
	}
	
	public boolean validate(T object) {
		for (int i=0; i<this.getDataLength(); i++) {
			if (this.dataList.get(i).validate(object))
				return true;
		}
		
		return false;
	}
	
	public boolean isExist(T object) {
		for (int i=0; i<this.getDataLength(); i++) {
			if (this.dataList.get(i).checkExistence(object))
				return true;
		}
		
		return false;
	}
	
	public T createAccount(String username, String password){
		T object=null;
		try {
			object = this.dataClazz.getDeclaredConstructor(String.class, String.class).newInstance(username, password);
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return object;
	}
}
