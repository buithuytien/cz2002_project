package staff.settings.ui;

import base.AbstractUI;

public class SettingsUI extends AbstractUI {

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
