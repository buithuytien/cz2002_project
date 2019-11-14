package base;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;

import util.TextDB;


public abstract class AbstractCRUD <T extends AbstractEntity> {
	protected ArrayList<T> dataList;
	protected Class<T> dataClazz;
	
	public void create(T object) {
		this.dataList.add(object);
		this.save();
	}
	
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
	
	public void deleteByIndex(int idx) {
		this.dataList.remove(idx);
		this.save();
	}
	
	public void list() {
		for (int i=0; i<getDataLength(); i++) {
			System.out.println(this.dataList.get(i).toString());
		}
	}
	
	protected void save(){
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
	
	protected void sort() {
		Collections.sort(this.dataList);
	}
	
	protected int getDataLength() {
		return this.dataList.size();
	}
	
	protected String getFilePath() throws Exception {
		Method getFilePathMethod = dataClazz.getDeclaredMethod("getFilePath");
		String filePath = (String)getFilePathMethod.invoke(null);
		
		return filePath;
	}
	
	public int printChoices() {
		int N = this.getDataLength();
		for (int i=0; i < N; i++) {
			System.out.println(i+" : "+this.dataList.get(i).toString());
		}
		
		return N;
	}
}
