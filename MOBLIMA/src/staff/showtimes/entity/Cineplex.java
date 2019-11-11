package staff.showtimes.entity;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

import base.AbstractEntity;
import cache.Cache;
import staff.showtimes.crud.CinemaCRUD;
import util.TextDB;

public class Cineplex extends AbstractEntity {
	public static String directoryName="";
	public static String fileName="Cineplex.txt";
	
	private int id;
	private String name;
	private String location;
	private ArrayList<Cinema> cinemaList;
	
	public Cineplex(int id, String name, String location) {
		this.id = id;
		this.name = name;
		this.location = location;
		this.cinemaList = new ArrayList<Cinema>();
	}
	
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
	
	public int getId() {
		return this.id;
	}
	
	public CinemaCRUD<Cinema> getCinemaCRUD() {
		return new CinemaCRUD<Cinema>(Cinema.class, this.id);
	}
	
	public ArrayList<Cinema> getCinemaList() {
		CinemaCRUD<Cinema> crud = this.getCinemaCRUD();
		return crud.getCinemaList();
	}
}