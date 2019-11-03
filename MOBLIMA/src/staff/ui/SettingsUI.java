package staff.ui;

import base.AbstractUI;

public class SettingsUI extends AbstractUI {

	public SettingsUI() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void start() {
		// TODO Auto-generated method stub
		System.out.println();
		System.out.println("0 : Change Price");
		System.out.println("1 : Update Public Holiday");
		System.out.println("2 : Back");
		
		int choice = this.getInputChoice(0, 3);
		
		this.run(choice);
	}

	public void run(int choice) {
		switch (choice) {
		case 0:
			this.intent(new PriceChangeUI());
			break;
		case 1:
			break;
		case 2:
			this.goBack();
			break;
		}
	}
}
