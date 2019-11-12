package login.ui;

import base.AbstractUI;
import cache.Cache;
import login.crud.AccountCRUD;
import login.entity.StaffAccount;
import login.entity.UserAccount;

public class LoginUI extends AbstractUI {
	@Override
	public void start() {
		System.out.println();
		System.out.println("You are?");
		System.out.println("0 : User");
		System.out.println("1 : Staff");
		System.out.println("2 : Exit");
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
