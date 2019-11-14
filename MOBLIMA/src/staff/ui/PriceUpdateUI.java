package staff.ui;

import base.AbstractUI;
import cache.Cache;
import staff.crud.PriceCRUD;

/**
 * PriceUpdateUI inherits AbstractUI
 * @author Ronald
 *
 */
public class PriceUpdateUI extends AbstractUI {

	@Override
	public void start() {
		// TODO Auto-generated method stub
		System.out.println();
		int noChoice = Cache.getCurrentCRUD().printChoices();
		
		int choice = this.getInputChoice(0, noChoice-1);
		
		System.out.println("Enter the adjusted price:");
		double price = getInputDouble();
		
		this.run(choice, price);
	}
	
	/**
	 * method to edit the price of the different variables depending on choice in PriceChangeUI
	 * @param choice
	 * @param price
	 */
	private void run(int choice, double price) {
		PriceCRUD crud = (PriceCRUD) Cache.getCurrentCRUD();
		crud.update(choice, price);
		System.out.println("Update Successfully");
		this.goBack();
	}

}
