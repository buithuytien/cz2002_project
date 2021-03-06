package ui;

import cache.Cache;
import crud.PublicHolidayCRUD;
import entity.PublicHoliday;
import util.DateTimeHelper;
import util.TextDB;

/**
 * PublicHolidayCRUDUI inherits AbstractUI
 * @author Ronald
 *
 */
public class PublicHolidayCRUDUI extends AbstractUI {
	
	@Override
	public void start() {
		// TODO Auto-generated method stub
		System.out.println();
		System.out.println("0 : Create a public holiday");
		System.out.println("1 : List all public holidays");
		System.out.println("2 : Delete a public holiday");
		System.out.println("3 : Back to previous menu");
		int choice = this.getInputChoice(0, 3);
		
		this.run(choice);
	}
	
	/**
	 * method to create, list or delete the public holiday date and name
	 * choice '0' creates a public holiday with the input of the date and name
	 * choice '1' lists the saved public holidays
	 * choice '2' deletes the data of the saved public holiday
	 * choice '3' returns to the previous menu
	 * @param choice
	 */
	public void run (int choice) {
		if (choice==3)
			this.goBack();
		
		PublicHolidayCRUD<PublicHoliday> crud = new PublicHolidayCRUD<>(PublicHoliday.class);
		Cache.setCurrentCRUD(crud);
		
		if (choice==0) {
			this.startCreate();
		} else if (choice==1) {
			crud.list();
			this.start();
		} else if (choice==2) {
			this.startDelete();
		}
	}
	
	/**
	 * method to get the input of date and name
	 * to create the the public holiday
	 */
	public void startCreate() {
		System.out.println();
		System.out.println("Enter the date in format " + DateTimeHelper.DATE_FORMAT);
		String dateStr = this.getInputString();
		System.out.println("Enter the name of the public holiday");
		String name = this.getInputString();
		
		this.runCreate(dateStr, name);
	}

	/**
	 * method to use the input of date and time to create a new public holiday object
	 * @param dateStr
	 * @param name
	 */
	public void runCreate(String dateStr, String name) {
		PublicHolidayCRUD crud = (PublicHolidayCRUD) Cache.getCurrentCRUD();
		PublicHoliday obj = crud.createPublicHoliday(dateStr, name);
		if (crud.isExist(obj))
			System.out.println("There is already a public holiday created on this date!");
		else {
			crud.create(obj);
			System.out.println("Public holiday created successfully!");
		}
		this.start();
	}
	
	/**
	 * method to allow user to choice which public holiday object to delete
	 */
	public void startDelete() {
		System.out.println();
		int noChoice = Cache.getCurrentCRUD().printChoices();
		
		int choice = this.getInputChoice(0, noChoice-1);
		
		this.runDelete(choice);
	}
	
	/**
	 * method to delete the public holiday object 
	 * @param choice
	 */
	public void runDelete(int choice) {
		PublicHolidayCRUD crud = (PublicHolidayCRUD) Cache.getCurrentCRUD();
		crud.deleteByIndex(choice);
		
		this.start();
	}
}
