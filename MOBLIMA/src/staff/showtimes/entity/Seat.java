package staff.showtimes.entity;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

import cache.Cache;
import util.TextDB;

public class Seat {
	private String filePath;
	
	private int row;
	private int col;
	private int[][] layout;
	
	
	public Seat(int row, int col, String filePath) {
		this.filePath = filePath;
		
		this.row = row;
		this.col = col;
		this.layout = new int[row][col];
		this.saveSeat();
	}

	public Seat(String filePath) {
		this.filePath = filePath;
		ArrayList<String> store = new ArrayList<>();
		try {
			store = TextDB.read(filePath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		StringTokenizer star0 = new StringTokenizer(store.get(0), TextDB.SEPERATOR);
		String rowStr = star0.nextToken().trim();
		String colStr = star0.nextToken().trim();
		
		this.row = Integer.valueOf(rowStr);
		this.col = Integer.valueOf(colStr);
		this.layout = new int[this.row][this.col];
		for (int i=0; i<this.row; ++i) {
			StringTokenizer star = new StringTokenizer(store.get(i+1), TextDB.SEPERATOR);
			for (int j=0; j<this.col; ++j) {
				layout[i][j] = Integer.valueOf(star.nextToken().trim());
			}
		}
	}
	
	public void saveSeat() {
		ArrayList<String> store = new ArrayList<>();
		StringBuilder st = new StringBuilder();
		st.append(this.row);
		st.append(TextDB.SEPERATOR);
		st.append(this.col);
		store.add(st.toString());
		
		for (int i=0; i<this.row; ++i) {
			StringBuilder star = new StringBuilder();
			for (int j=0; j<this.col-1; ++j) {
				star.append(this.layout[i][j]);
				star.append(TextDB.SEPERATOR);
			}
			star.append(this.layout[i][this.col-1]);
			store.add(star.toString());
		}
		
		try {
			TextDB.write(this.filePath, store);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public boolean isOccupied(int rowChoice, int colChoice) {
		return this.layout[rowChoice][colChoice] == 1;
	}
	
	public void takeSeat(int rowChoice, int colChoice) {
		if (!isOccupied(rowChoice, colChoice))
			this.layout[rowChoice][colChoice] = 1;
		else 
			System.out.println("Seat Occupied");
		
		this.saveSeat();
	}
	
	public boolean isFull() {
		for (int i=0; i<this.row; ++i) {
			for (int j=0; j<this.col; ++j) {
				if (!isOccupied(i,j))
					return false;
			}
		}
		return true;
	}
}
