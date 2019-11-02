package base;

import util.TextDB;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;

public abstract class AbstractCRUD <T extends AbstractEntity> {
	protected ArrayList<T> dataList;
	private Class<T> dataClazz;
	
	
	public void read() throws IOException, Exception {
		ArrayList<T> rawData = new ArrayList<>();
		rawData = TextDB.read(getFilePath());
		for (int i=0; i < rawData.size(); i++) {
			dataList.add(dataClazz.)
		}
	}
	
	public void deleteByIndex(int idx) {
		dataList.remove(idx);
	}
	
	public void list() {
		for (int i=0; i<getDataLength(); i++) {
			System.out.println(dataList.get(i).toString());
		}
	}
	
	public void save() throws IOException, Exception{
		ArrayList saveData = new ArrayList();
		
		for (int i=0; i<getDataLength(); i++) {
			saveData.add(this.dataList.get(i).processToDBString());
		}
		
		TextDB.write(getFilePath(), saveData);
	}
	
	public void sort() {
		Collections.sort(this.dataList);
	}
	
	private int getDataLength() {
		return this.dataList.size();
	}
	
	private String getFilePath() throws Exception {
		Method getFilePathMethod = dataClazz.getDeclaredMethod("getFilePath", Class.class);
		String filePath = (String)getFilePathMethod.invoke(null, dataClazz);
		
		return filePath;
	}
}
