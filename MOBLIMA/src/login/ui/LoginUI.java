package login.ui;

import base.AbstractUI;
import cache.Cache;
import login.crud.AccountCRUD;
import login.entity.StaffAccount;
import login.entity.UserAccount;

/**
 * LoginUI inherits from AbstractUI
 * @author Ronald
 */
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
	/**
	 * choice '0' to create UserAccount object
	 * choice '1' to create StaffAccount object
	 * choice '2' to exit program
	 * @param choice The user's input
	 */
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
		/**
		 * to call LoginCRUDUI class
		 */
		this.intent(new LoginCRUDUI());
				
	}
}
