package ui;

import cache.Cache;
import crud.AccountCRUD;
import entity.StaffAccount;
import entity.UserAccount;

public class LoginUI extends AbstractUI {
	@Override
	public void start() {
		System.out.println();
		System.out.println("Welcome to MOBLIMA! Are you a staff or a user?");
		System.out.println("0 : User Login");
		System.out.println("1 : Staff Login");
		System.out.println("2 : Exit MOBLIMA");
		int choice = getInputChoice(0,2);
		
		run(choice);
	}
	
	public void run(int choice) {
		switch(choice) {
			case 0:
				AccountCRUD<UserAccount> userCRUD = new AccountCRUD<>(UserAccount.class);
				Cache.setCurrentCRUD(userCRUD);
				break;
			case 1:
				AccountCRUD<StaffAccount> staffCRUD = new AccountCRUD<>(StaffAccount.class);
				Cache.setCurrentCRUD(staffCRUD);
				break;
			case 2:
				this.exit();
				break;
		}
		
		this.intent(new LoginCRUDUI());
				
	}
}
