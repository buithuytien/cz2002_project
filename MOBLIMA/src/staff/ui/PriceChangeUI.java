package staff.ui;

import base.AbstractUI;
import cache.Cache;
import staff.crud.PriceCRUD;
import staff.entity.AgePrice;
import staff.entity.CinemaClassPrice;
import staff.entity.DayPrice;
import staff.entity.MovieTypePrice;

/**
 * PriceChangeUI inherits AbstractUI
 * @author Ronald
 *
 */
public class PriceChangeUI extends AbstractUI {

	/**
	 * constructor
	 */
	public PriceChangeUI() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void start() {
		// TODO Auto-generated method stub
		System.out.println();
		System.out.println("0 : Movie Type");
		System.out.println("1 : Cinema Class");
		System.out.println("2 : Age");
		System.out.println("3 : Day Type");
		System.out.println("4 : Back");
		
		int choice = this.getInputChoice(0, 4);
		
		this.run(choice);
	}

	/**
	 * method for user to choose an option to carry out
	 * choice '0' creates a new object with the input as the new price for the given movie type
	 * choice '1' creates a new object with the input as the new price for the given cinema class
	 * choice '2' creates a new object with the input as the new price for the given age range
	 * choice '3' creates a new object with the input as the new price for the given day type
	 * choice '4' returns to the previous menu
	 * @param choice
	 */
	public void run(int choice) {
		switch (choice) {
		case 0:
			PriceCRUD<MovieTypePrice> typeCRUD = new PriceCRUD<>(MovieTypePrice.class);
			Cache.setCurrentCRUD(typeCRUD);
			this.intent(new PriceUpdateUI());
			break;
		case 1:
			PriceCRUD<CinemaClassPrice> cinemaCRUD = new PriceCRUD<>(CinemaClassPrice.class);
			Cache.setCurrentCRUD(cinemaCRUD);
			this.intent(new PriceUpdateUI());
			break;
		case 2:
			PriceCRUD<AgePrice> ageCRUD = new PriceCRUD<>(AgePrice.class);
			Cache.setCurrentCRUD(ageCRUD);
			this.intent(new PriceUpdateUI());
			break;
		case 3:
			PriceCRUD<DayPrice> dayCRUD = new PriceCRUD<>(DayPrice.class);
			Cache.setCurrentCRUD(dayCRUD);
			this.intent(new PriceUpdateUI());
			break;
		case 4:
			this.goBack();
			break;
		}
	}
}
