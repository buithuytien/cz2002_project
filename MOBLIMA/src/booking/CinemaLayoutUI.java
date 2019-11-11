package booking;

import java.util.Scanner;
<<<<<<< Updated upstream
import java.util.*;

import base.AbstractUI;
=======
import java.io.File;
import java.io.IOException;
import java.time.LocalTime;
import java.util.*;

import base.AbstractUI;
import cache.Cache;
import staff.movie.entity.Movie;
import staff.showtimes.entity.Cinema;
import staff.showtimes.entity.Seat;
import util.DateTimeHelper;
import staff.showtimes.*;

>>>>>>> Stashed changes
//System.out.println("2: Check seat availability and selection of seat/s. ");
public class CinemaLayoutUI extends AbstractUI{
	char A,B,C,D,E,F,G,H,J;
	List<String> a,b,c,d,e,f,g,h,j;
	
<<<<<<< Updated upstream

	public CinemaLayoutUI(){
		
		
	}
	
	@Override
	public void start() {	
		//20
		System.out.println("-----------------------------------------------");
		System.out.println("                    Screen                    ");
		System.out.println("");
		//8
		System.out.println("");
		
		System.out.println("    0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15"); // print column name
		System.out.println("");
		
		//make and display the row
		
		this.makeRow(j, 'J',16);
		System.out.println("");
		this.makeRow(h, 'H',16);
		System.out.println("");
		this.makeRow(g,'G', 16);
		System.out.println("");
		this.makeRow(f,'F', 16);
		System.out.println("");
		this.makeRow(e,'E', 16);
		System.out.println("");
		this.makeRow(d,'D',16);
		System.out.println("");
		this.makeRow(c,'C',16);
		System.out.println("");
		this.makeRow(b,'B', 16);
		System.out.println("");
		this.makeRow(a,'A', 16);
		System.out.println("");
		
		// display the Row
=======
	public static String fileName="";
	private Seat seat;
	public static String directoryName="CinemaLayoutUI";
	private int[][] layout;
	private LocalTime time;

	//choose movie, cinema, time first
	//and then book the seat
	

	public CinemaLayoutUI(Cinema cinema, String timeStr, Movie movie){
		
	this.time = DateTimeHelper.convertStringToTime(timeStr);
	this.seat = new Seat(cinema.getRow(), cinema.getCol(), this.getFilePath());
	
	
	for(int i = 0 ; i < cinema.getRow() ; i++) {
		for(int j = 0 ; j<cinema.getCol() ; j++) {
			System.out.println(layout[i][j]);
		}
		
		
	}
	}
	
	
	
	@Override
	public void start() {	
		
		System.out.println("-----------------------------------------------");
		System.out.println("                    Screen                    ");
		System.out.println("");
		
		System.out.println("");
		
	//	System.out.println("    0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15"); // print column name
		System.out.println("");
		
		
	
		
>>>>>>> Stashed changes
		System.out.println("");
		System.out.println("");
		System.out.println("                    |Entrance|                    ");
		System.out.println("--------------------------------------------------");
		System.out.println("LEGEND");
		System.out.println("Seat Available: 0 ");
		System.out.println("Seat Taken: 1");
				
		Scanner sc = new Scanner(System.in);
		System.out.println("--------------------------------------------------");

		System.out.println("How many seats you want to book?");
		
		int ticketNum = sc.nextInt();
		
	
		for(int i = 0 ; i < ticketNum ;i++) {
			
			System.out.println("Please input the row name of the seat:");
			 sc.next().charAt(0);	
			 
			System.out.println("Please input the column name of the seat:");
			sc.nextInt();
		}
		//showing the selected seats
		
		
		System.out.println("Do you want to confirm seats? (Y/N)");
		long yesOrNo =  sc.next().charAt(0);	
		
		if (yesOrNo == 'Y') {
			System.out.println("Seat Confirmed");
		}
		else
		{
			for(int i = 0 ; i < ticketNum ;i++) {
				
				System.out.println("Please input the row name of the seat:");
				 sc.next().charAt(0);	
				 
				System.out.println("Please input the column name of the seat:");
				sc.nextInt();
			}
			
		}
		
	}
	
<<<<<<< Updated upstream
	
	public List<String> makeRow(List<String> row, char rowName, int seatNum){
		
		row = new ArrayList<String>(seatNum);
		
		System.out.print(rowName + "   ");
		
		for(int i = 0; i < seatNum;i++) {
			row.add("0");
		
			System.out.print(row.get(i));
			if(i<9) {
			System.out.print(" ");
			}
			else
				System.out.print("  ");
					
		}
		return row;
		
	}
	

}
=======
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
>>>>>>> Stashed changes
