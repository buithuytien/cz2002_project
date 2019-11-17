package ui;

import cache.Cache;
/**
 * StaffUI inherits AbstractUI
 * @author Ronald
 *
 */
public class StaffUI extends AbstractUI {

	/**
	 * constructor
	 */
	public StaffUI() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void start() {
		// TODO Auto-generated method stub
		System.out.println();
		System.out.println("Welcome staff "+Cache.getUsername());
		System.out.println("0 : View/Create/Update/Remove movie listing");
		System.out.println("1 : Create/Update/Remove cinema showtimes");
		System.out.println("2 : Configure system settings");
		System.out.println("3 : Exit MOBLIMA");
		
		int choice = this.getInputChoice(0, 3);
		
		this.run(choice);
	}
	
	/**
	 * method for staff user to choose movie listing, cinema showtimes or system settings to edit
	 * choice '0' displays the menu to edit the move listings, under MovieStaffUI class 
	 * choice '1' displays the menu to edit the cinema showtimes, under ShowtimesStaffUI class
	 * choice '2' displays the menu to edit the pricing or public holiday, under SettingsUI
	 * @param choice
	 */
	public void run(int choice) {
		switch (choice) {
		case 0:
			this.intent(new MovieStaffUI());
			break;
		case 1:
			this.intent(new ShowtimesStaffUI());
			break;
		case 2:
			this.intent(new SettingsUI());
			break;
		case 3:
			this.exit();
			break;
		}
	}

}
