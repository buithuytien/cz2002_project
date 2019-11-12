package staff.ui;

import base.AbstractUI;
import cache.Cache;
import staff.movie.ui.MovieStaffUI;
import staff.settings.ui.SettingsUI;
import staff.showtimes.ui.ShowtimesStaffUI;

public class StaffUI extends AbstractUI {

	public StaffUI() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void start() {
		// TODO Auto-generated method stub
		System.out.println();
		System.out.println("Welcome staff "+Cache.getUsername());
		System.out.println("0 : View/Create/Update/Remove Movie Listing");
		System.out.println("1 : Create/Update/Remove cinema showtimes");
		System.out.println("2 : Configure system settings");
		System.out.println("3 : Exit");
		
		int choice = this.getInputChoice(0, 3);
		
		this.run(choice);
	}
	
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