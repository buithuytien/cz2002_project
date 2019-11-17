package ui;

import cache.Cache;
import crud.AccountCRUD;
import entity.Account;
import entity.UserAccount;

/**
 * LoginValidateUI inherits AbstractUI
 * @author Ronald
 */
public class LoginValidateUI extends AbstractUI {

	/**
	 * constructor
	 */
	public LoginValidateUI() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void start() {
		// TODO Auto-generated method stub
		System.out.println();
		System.out.println("Enter your username:");
		String username = getInputString();
		
		System.out.println("Enter your password:");
		String password = getInputString();
		
		this.run(username, password);
	}
	
	/**
	 * check username and password details
	 * if username and password is valid, login successful
	 * else print "wrong login info" and return to LoginCRUDUI display
	 * @param username
	 * @param password
	 */
	public void run(String username, String password) {
		AccountCRUD crud = (AccountCRUD) Cache.getCurrentCRUD();
		try {
			Account acc = crud.createAccount(username, password);
			if (crud.validate(acc)) {
				System.out.println("Login successful!");
				Cache.setUserName(acc.getUsername());
				if (acc instanceof UserAccount) {
					this.intent(new UserUI());
				}
				else {
					Cache.setStaff();
					this.intent(new StaffUI());
				}
			} else {
				System.out.println("Wrong login info entered! Please try again.");
				this.goBack();
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
