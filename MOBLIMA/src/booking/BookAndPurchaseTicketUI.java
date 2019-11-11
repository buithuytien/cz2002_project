package booking;

import base.AbstractUI;
<<<<<<< Updated upstream
=======
import staff.settings.crud.PriceCRUD;
import staff.settings.entity.AgePrice;

import java.time.*;
import java.util.EnumSet;
import java.util.Set;

import util.DateTimeHelper;
>>>>>>> Stashed changes

public class BookAndPurchaseTicketUI extends AbstractUI {
	int basicPrice = 0;
	// Book and purchase ticket 
	//get the age group first(it can be different between ticket owners), other things are all the same
	public void BookAndPurchaseTicketUI(){
		
		
	}
	
	@Override
	public void start(){ // just sum
		
<<<<<<< Updated upstream
		System.out.println("please input date in DD/MM/YYYY format: ");
		
		

		
		
		
		
		
		
		//CinemaLayoutUI.ticketNum
		for( int i = 0;i < 1 ; i++)
		{
			
			System.out.println("Please select the age group");
			System.out.println("Age between 0~20 : select 0");
			System.out.println("Age between 21~64 : select 1");
			System.out.println("Age upper 65 : select 2");
			
			int choice = this.getInputChoice(1, 3);
			
			this.run(choice);
			
		}
		
		System.out.println("Please select the Cinema Type");
		System.out.println("PLATINUM, additional 2.5 SGD : select 0");
		System.out.println("GOLD, additional 1.75 SGD : select 1");
		System.out.println("SILVER, additional 1.0 SGD : select 2");
		System.out.println("NORMAL, additional 0.5 SGD : select 3");
		
		int choice = this.getInputChoice(1, 3);
		
		this.chooseCinema(choice);
		
		// the Movie Type (normal, three d...) is already in the database
		
		//detects which date will someone watch the movie  and sum the price
		
		
		
		
		
		
		
	}
	
	public void run(int choice) {
		
		switch(choice) {
		case 0:
			basicPrice += 0.5;
			break;
		case 1:
			basicPrice += 1.5;
			break;
		case 2:
			basicPrice += 1.0;
			break;
		
		}
		
	}
	
	public void chooseCinema(int choice) {
		
		switch(choice) {
		case 0:
			basicPrice += 2.5;
			break;
		case 1:
			basicPrice += 1.75;
			break;
		case 2:
			basicPrice += 1.0;
			break;
		case 3:
			basicPrice += 0.5;
		
		
		}
		
		
		
		
		
		
		
		
		
=======
		System.out.println("please input date in D-MM-YYYY format: ");
		String dateStr = this.getInputString();
	    LocalDate date = DateTimeHelper.convertStringToDate(dateStr);
		
		DayOfWeek dow = date.getDayOfWeek();
		Set<DayOfWeek> weekend = EnumSet.of( DayOfWeek.SATURDAY , DayOfWeek.SUNDAY );
		Boolean todayIsWeekend = weekend.contains( dow );
		
		if (todayIsWeekend) {
			
			
		}
		else {
			
			
			
		}
		
		int age = this.getInputInteger();
		
	//	PriceCRUD<AgePrice> priceCRUD = new PriceCRUD<>();
	//	double price = priceCRUD.getPrice(age);

	
		System.out.println("The total ticket price is: ");
		System.out.println("Do you want to proceed to purchase? (Y/N) ");
		
	
		
		
		

	}
	
	
>>>>>>> Stashed changes
		
		
	}
	
	
	
<<<<<<< Updated upstream
	
	
}
=======
	
>>>>>>> Stashed changes
