package ui;

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
