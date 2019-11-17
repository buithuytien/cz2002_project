package ui;

/**
 * ShowtimesStaffUI inherits AbstractUI
 * @author Ronald
 *
 */
public class ShowtimesStaffUI extends AbstractUI {

	@Override
	public void start() {
		// TODO Auto-generated method stub
		System.out.println();
		System.out.println("0 : List all showtimes for a cinema");
		System.out.println("1 : Create showtimes");
		System.out.println("2 : Back to previous menu");
		
		int choice = this.getInputChoice(0, 2);
		this.run(choice);
	}

	/**
	 * method to list the showtimes for a cinema or create a showtime for the cinema
	 * choice '0' lists all the showtimes of all movies for a particular cinema
	 * choice '1' displays the menu to create showtimes in a cinema, under ShowtimesCRUDUI class
	 * choice '2' returns to the previous menu
	 * @param choice
	 */
	public void run(int choice) {
		switch(choice) {
		case 0:
			this.intent(new ShowtimesListUI());
			break;
		case 1:
			this.intent(new ShowtimesCRUDUI());
			break;
		case 2:
			this.goBack();
			break;
		}
	}
}
