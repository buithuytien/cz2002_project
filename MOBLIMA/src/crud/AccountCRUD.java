package crud;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

import entity.Account;

/**
 * AccountCRUD inherits AbstractCRUD
 * whereby attributes from AbstractCRUD is replaced by attributes from Account
 * @author Ronald
 *
 * @param <T>
 */
public class AccountCRUD <T extends Account> extends AbstractCRUD<T> {
	/**
	 * constructor
	 * @param clazz
	 */
	public AccountCRUD(Class<T> clazz){
		this.dataList = new ArrayList<T>();
		this.dataClazz = clazz;
		this.read();
	}
	
	/**
	 * method to check if object matches data in datalist
	 * returns true if object matches data in datalist
	 * @param object
	 * @return True or False
	 */
	public boolean validate(T object) {
		for (int i=0; i<this.getDataLength(); i++) {
			if (this.dataList.get(i).validate(object))
				return true;
		}
		
		return false;
	}
	
	/**
	 * method to check if object exists in datalist
	 * returns true if object exists in datalist
	 * @param object
	 * @return True or False
	 */
	public boolean isExist(T object) {
		for (int i=0; i<this.getDataLength(); i++) {
			if (this.dataList.get(i).checkExistence(object))
				return true;
		}
		
		return false;
	}
	
	/**
	 * method to create an account
	 * @param username
	 * @param password
	 * @return account object
	 */
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
