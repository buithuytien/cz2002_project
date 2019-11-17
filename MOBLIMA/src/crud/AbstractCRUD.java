package crud;

import util.TextDB;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;

import entity.AbstractEntity;

/**
 * attributes from AbstractCRUD inherits AbstractEntity 
 * @author Ronald
 *
 * @param <T>
 */
public abstract class AbstractCRUD <T extends AbstractEntity> {
	/**
	 * list of attributes to be added in a list
	 */
	protected ArrayList<T> dataList;
	/**
	 * classifications of data in the list
	 */
	protected Class<T> dataClazz;
	
	/**
	 * method to save objects into a list
	 * @param object
	 */
	public void create(T object) {
		this.dataList.add(object);
		this.save();
	}
	
	/**
	 * method to read the data in the list
	 */
	protected void read() {
		ArrayList<String> rawData = new ArrayList<>();
		try {
			rawData = TextDB.read(getFilePath());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (int i=0; i < rawData.size(); i++) {
			String objStr = rawData.get(i);
			T obj = null;
			try {
				obj = this.dataClazz.getDeclaredConstructor(String.class).newInstance(objStr);
			} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
					| InvocationTargetException | NoSuchMethodException | SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.dataList.add(obj);
		}
	}
	
	/**
	 * method to delete data in the list
	 * @param idx
	 */
	public void deleteByIndex(int idx) {
		this.dataList.remove(idx);
		this.save();
	}
	
	/**
	 * method to print out the data in the list
	 */
	public void list() {
		for (int i=0; i<getDataLength(); i++) {
			System.out.println(this.dataList.get(i).toString());
		}
	}
	
	/**
	 * method to create new object to save in the list
	 */
	public void save(){
		ArrayList<String> saveData = new ArrayList<>();
		this.sort();
		
		for (int i=0; i<getDataLength(); i++) {
			saveData.add(this.dataList.get(i).processToDBString());
		}
		
		try {
			TextDB.write(getFilePath(), saveData);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * method to sort the list
	 */
	protected void sort() {
		Collections.sort(this.dataList);
	}
	
	/**
	 * method to get the size of the list
	 * @return size of data
	 */
	protected int getDataLength() {
		return this.dataList.size();
	}
	
	/**
	 * method to get file path
	 * @return name of file path
	 * @throws Exception if any type of exceptions occurred
	 */
	protected String getFilePath() throws Exception {
		Method getFilePathMethod = dataClazz.getDeclaredMethod("getFilePath");
		String filePath = (String)getFilePathMethod.invoke(null);
		
		return filePath;
	}
	
	/**
	 * method get the size of data in the list and to print them out
	 * @return length of data
	 */
	public int printChoices() {
		int N = this.getDataLength();
		for (int i=0; i < N; i++) {
			System.out.println(i+" : "+this.dataList.get(i).toString());
		}
		
		return N;
	}
}
