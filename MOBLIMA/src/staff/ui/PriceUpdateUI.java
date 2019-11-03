package staff.ui;

import base.AbstractUI;
import cache.Cache;
import staff.crud.PriceCRUD;

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
	
	private void run(int choice, double price) {
		PriceCRUD crud = (PriceCRUD) Cache.getCurrentCRUD();
		crud.update(choice, price);
		System.out.println("Update Successfully");
		this.goBack();
	}

}
