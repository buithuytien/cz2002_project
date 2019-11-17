package ui;

/**
 * SettingsUI inherits AbstractUI
 * @author Ronald
 *
 */
public class SettingsUI extends AbstractUI {

	/**
	 * constructor
	 */
	public SettingsUI() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void start() {
		// TODO Auto-generated method stub
		System.out.println();
		System.out.println("0 : Change movie prices");
		System.out.println("1 : Update public holidays");
		System.out.println("2 : Back to previous menu");
		
		int choice = this.getInputChoice(0, 3);
		
		this.run(choice);
	}

	/**
	 * method for staff user to input which menu to enter
	 * choice '0' enters the menu to change the price allocation, under PriceChangeUI
	 * choice '1' enters the menu to edit the public holiday data, under PublicHolidayCRUDUI
	 * choice '2' returns to the previous menu
	 * @param choice
	 */
	public void run(int choice) {
		switch (choice) {
		case 0:
			this.intent(new PriceChangeUI());
			break;
		case 1:
			this.intent(new PublicHolidayCRUDUI());
			break;
		case 2:
			this.goBack();
			break;
		}
	}
}
