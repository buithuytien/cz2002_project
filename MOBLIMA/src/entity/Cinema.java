package entity;

import java.io.File;
import java.io.IOException;
import java.util.StringTokenizer;

import cache.Cache;
import enums.CinemaClass;
import util.TextDB;

/**
 * Cinema inherits AbstractEntity
 * @author Ronald
 *
 */
public class Cinema extends AbstractEntity {
	/**
	 * method to declare strings
	 */
	public static String directoryName="Cineplex";
	public static String fileName;
	
	/**
	 * cinema id
	 */
	private int id;
	/**
	 * type of CinemaClass, based on enumerations in CinemaClass class
	 */
	private CinemaClass type;
	/**
	 * the row and column values of the seating in the cinema
	 */
	private int row;
	private int col;
	
	public Cinema(int id, CinemaClass type, int row, int col) {
		this.id = id;
		this.type = type;
		this.row = row;
		this.col = col;
	}
	
	/**
	 * constructor
	 * @param id
	 * @param type
	 * @param row
	 * @param col
	 */
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

	/**
	 * accessor method to get cinema id
	 * @return cinema id
	 */
	public int getId() {
		return this.id;
	}
	
	/**
	 * accessor method to get the cinema class, based on the enumerations in CinemaClass class
	 * @return classes of categories of the cinema
	 */
	public CinemaClass getCinemaClass() {
		return this.type;
	}
	
	/**
	 * accessor method to get the row value of the seat
	 * @return integer value for row
	 */
	public int getRow() {
		return this.row;
	}
	
	/**
	 * accessor method to get the column value of the seat 
	 * @return integer value for column
	 */
	public int getCol() {
		return this.col;
	}
	
	/**
	 * method to create a text file based on the cineplexid
	 * @param cineplexId
	 */
	public static void setFileName(int cineplexId) {
		fileName = Integer.toString(cineplexId) + ".txt";
	}
	
	/**
	 * method to get file path
	 * @return the file path
	 */
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
