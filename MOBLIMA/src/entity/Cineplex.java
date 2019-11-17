package entity;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

import cache.Cache;
import crud.CinemaCRUD;
import util.TextDB;

/**
 * Cineplex inherits AbstractEntity
 * @author Ronald
 *
 */
public class Cineplex extends AbstractEntity {
	/**
	 * method to declare strings
	 */
	public static String directoryName="";
	public static String fileName="Cineplex.txt";
	
	/**
	 * cineplex id
	 */
	private int id;
	/**
	 * name of cineplex
	 */
	private String name;
	/**
	 * location of cineplex
	 */
	private String location;
	/**
	 * list of cinemas in cineplex
	 */
	private ArrayList<Cinema> cinemaList;
	
	/**
	 * constructor
	 * @param id
	 * @param name
	 * @param location
	 */
	public Cineplex(int id, String name, String location) {
		this.id = id;
		this.name = name;
		this.location = location;
		this.cinemaList = new ArrayList<Cinema>();
	}
	
	/**
	 * constructor to store cineplex id, cineplex name, cineplex location 
	 * and list of cinemas in the particular cineplex in a text file
	 * @param raw
	 */
	public Cineplex(String raw) {
		StringTokenizer star = new StringTokenizer(raw, TextDB.SEPERATOR);
		
		String idStr = star.nextToken().trim();
		String name = star.nextToken().trim();
		String location = star.nextToken().trim();
		this.id = Integer.valueOf(idStr);
		this.name = name;
		this.location = location;
		this.cinemaList = this.getCinemaList();
	}
	@Override
	public int compareTo(AbstractEntity o) {
		// TODO Auto-generated method stub
		return this.id - ((Cineplex)o).getId();
	}

	@Override
	public String processToDBString() {
		StringBuilder st = new StringBuilder();
		st.append(this.id);
		st.append(TextDB.SEPERATOR);
		st.append(this.name);
		st.append(TextDB.SEPERATOR);
		st.append(this.location);
		
		return st.toString();
	}

	@Override
	public String toString() {
		StringBuilder st = new StringBuilder();
		st.append("ID - ");
		st.append(this.id);
		st.append(TextDB.SEPERATOR);
		st.append("Name - ");
		st.append(this.name);
		st.append(TextDB.SEPERATOR);
		st.append("Location - ");
		st.append(this.location);

		return st.toString();
	}

	@Override
	public boolean checkExistence(AbstractEntity object) {
		// TODO Auto-generated method stub
		return false;
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
	
	/**
	 * accessor method to get cineplex id
	 * @return cineplex id
	 */
	public int getId() {
		return this.id;
	}
	
	/**
	 * accessor method to get category of cinema class, based on enumerations in CinemaClass class
	 * and to get id of cinema
	 * @return class of category of cinema and cinema id
	 */
	public CinemaCRUD<Cinema> getCinemaCRUD() {
		return new CinemaCRUD<Cinema>(Cinema.class, this.id);
	}
	
	/**
	 * accessor method to get list of cinemas in cineplex
	 * @return list of cinemas
	 */
	public ArrayList<Cinema> getCinemaList() {
		CinemaCRUD<Cinema> crud = this.getCinemaCRUD();
		return crud.getCinemaList();
	}
}
