package login.ui;

import base.AbstractUI;

public class LoginCRUDUI extends AbstractUI {

	public LoginCRUDUI() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void start() {
		// TODO Auto-generated method stub
		System.out.println();
		System.out.println("0: Create Account");
		System.out.println("1: Login");
		System.out.println("2: Back");
		
		int choice = getInputChoice(0,2);
		
		this.run(choice);
	}
	
	public void run(int choice) {
		switch(choice) {
			case 0:
				this.intent(new LoginCreateUI());
				break;
			case 1:
				this.intent(new LoginValidateUI());
				break;
			case 2:
				this.goBack();
		}
	}

}
