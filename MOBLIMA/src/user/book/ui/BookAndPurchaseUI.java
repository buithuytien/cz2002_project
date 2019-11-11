package user.book.ui;

import base.AbstractUI;
import staff.showtimes.entity.Showtimes;
import user.ui.UserUI;

public class BookAndPurchaseUI extends AbstractUI {
	private Showtimes showtimes;
	
	public BookAndPurchaseUI(Showtimes chosen) {
		this.showtimes = chosen;
	}
	@Override
	public void start() {
		// TODO Auto-generated method stub
		System.out.println();
		if (showtimes.isFull()) {
			System.out.println("No seat available!");
			this.home();
			return;
		}
		
		System.out.println("Seat available:");
		this.showtimes.viewSeat();
		System.out.println("0 : Proceed to book");
		System.out.println("1 : Back to Home");
		
		int choice = this.getInputChoice(0, 1);
		this.run(choice);
	}

	public void run(int choice) {
		switch(choice) {
		case 0:
			break;
		case 1:
			this.home();
			break;
		}
	}
	
	public void home() {
		UserUI ui = new UserUI();
		ui.start();
	}
}
