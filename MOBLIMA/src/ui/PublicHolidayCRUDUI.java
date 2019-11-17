package ui;

import cache.Cache;
import crud.PublicHolidayCRUD;
import entity.PublicHoliday;
import util.DateTimeHelper;
import util.TextDB;

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
	
	public void startCreate() {
		System.out.println();
		System.out.println("Enter the date in format " + DateTimeHelper.DATE_FORMAT);
		String dateStr = this.getInputString();
		System.out.println("Enter the name of the public holiday");
		String name = this.getInputString();
		
		this.runCreate(dateStr, name);
	}

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
	
	public void startDelete() {
		System.out.println();
		int noChoice = Cache.getCurrentCRUD().printChoices();
		
		int choice = this.getInputChoice(0, noChoice-1);
		
		this.runDelete(choice);
	}
	
	public void runDelete(int choice) {
		PublicHolidayCRUD crud = (PublicHolidayCRUD) Cache.getCurrentCRUD();
		crud.deleteByIndex(choice);
		
		this.start();
	}
}