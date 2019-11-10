package booking;

import java.util.Scanner;
import java.util.*;

import base.AbstractUI;
//System.out.println("2: Check seat availability and selection of seat/s. ");
public class CinemaLayoutUI extends AbstractUI{
	char A,B,C,D,E,F,G,H,J;
	List<String> a,b,c,d,e,f,g,h,j;
	

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
