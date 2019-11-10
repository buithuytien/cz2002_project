package user.ui;

import base.AbstractUI;
import staff.showtimes.crud.CineplexCRUD;
import staff.showtimes.crud.ShowtimesCRUD;
import staff.showtimes.entity.Cineplex;
import staff.showtimes.entity.Showtimes;

public class ShowtimesListUserUI extends AbstractUI {

	@Override
	public void start() {
		// TODO Auto-generated method stub
		System.out.println();
		System.out.println("Choose Cineplex:");
		CineplexCRUD<Cineplex> cineplexCRUD = new CineplexCRUD<>(Cineplex.class);
		int noCineplexChoice = cineplexCRUD.printChoices();
		int cineplexChoice = this.getInputChoice(0, noCineplexChoice-1);
		Cineplex cineplex = cineplexCRUD.getCineplex(cineplexChoice);
		
		System.out.println("Enter Showing Date");
		String dateStr = this.getInputDate();
		
		this.run(cineplex.getId(), dateStr);		
	}

	public void run(int cineplexId, String dateStr) {
		ShowtimesCRUD<Showtimes> showtimesCRUD = new ShowtimesCRUD<>(Showtimes.class, cineplexId, dateStr);
		
	}
}
