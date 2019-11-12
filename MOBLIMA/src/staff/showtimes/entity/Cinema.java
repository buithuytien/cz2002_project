package staff.showtimes.entity;

import java.io.File;
import java.io.IOException;
import java.util.StringTokenizer;

import base.AbstractEntity;
import cache.Cache;
import staff.entity.enums.CinemaClass;
import util.TextDB;

public class Cinema extends AbstractEntity {
	public static String directoryName="Cineplex";
	public static String fileName;
	
	private int id;
	private CinemaClass type;
	private int row;
	private int col;
	
	public Cinema(int id, CinemaClass type, int row, int col) {
		this.id = id;
		this.type = type;
		this.row = row;
		this.col = col;
	}
	
	public Cinema(String raw) {
		StringTokenizer star = new StringTokenizer(raw, TextDB.SEPERATOR);
		
		String idStr = star.nextToken().trim();
		String typeStr = star.nextToken().trim();
		String rowStr = star.nextToken().trim();
		String colStr = star.nextToken().trim();
		
		this.id= Integer.valueOf(idStr);
		this.type = CinemaClass.valueOf(typeStr);
		this.row = Integer.valueOf(rowStr);
		this.col = Integer.valueOf(colStr);
	}
	@Override
	public int compareTo(AbstractEntity o) {
		// TODO Auto-generated method stub
		return this.id - ((Cinema)o).getId();
	}

	@Override
	public String processToDBString() {
		StringBuilder st = new StringBuilder();
		st.append(this.id);
		st.append(TextDB.SEPERATOR);
		st.append(this.type);
		st.append(TextDB.SEPERATOR);
		st.append(this.row);
		st.append(TextDB.SEPERATOR);
		st.append(this.col);
		
		return st.toString();
	}

	@Override
	public String toString() {
		return this.processToDBString();
	}

	@Override
	public boolean checkExistence(AbstractEntity object) {
		// TODO Auto-generated method stub
		return false;
	}

	public int getId() {
		return this.id;
	}
	
	public CinemaClass getCinemaClass() {
		return this.type;
	}
	
	public int getRow() {
		return this.row;
	}
	
	public int getCol() {
		return this.col;
	}
	
	public static void setFileName(int cineplexId) {
		fileName = Integer.toString(cineplexId) + ".txt";
	}
	
	public static String getFilePath() {
		String path = directoryName + "/" + fileName;
		File file = new File(Cache.DBPath+path);
		file.getParentFile().mkdirs();
		try {
			file.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return path;
	}
}
