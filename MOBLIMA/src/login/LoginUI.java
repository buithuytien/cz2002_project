package login;

import base.AbstractUI;

public class LoginUI extends AbstractUI {
	public void start() {
		
		System.out.println("You are?");
		System.out.println("0 : User");
		System.out.println("1 : Staff");
		
		int choice = getInputChoice(0,1);
		
		run(choice);
	}
	
	public void run(int choice) {
		switch(choice) {
			case 0:
				break;
			case 1:
				break;
		}
				
	}
}
