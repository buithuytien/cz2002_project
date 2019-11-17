package ui;

import cache.Cache;
import crud.AccountCRUD;
import entity.Account;

/**
 * LoginCreateUI inherits AbstractUI
 * UI for create Login inputs 
 * @author Ronald
 */
public class LoginCreateUI extends AbstractUI {

	/**
	 * constructor
	 */
	public LoginCreateUI() {
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
	 * create an account with the username and password input
	 * 2 accounts with the same username is not allowed
	 * @param username
	 * @param password
	 */
	public void run(String username, String password) {
		AccountCRUD crud = (AccountCRUD) Cache.getCurrentCRUD();
		try {
			Account acc = crud.createAccount(username, password);
			if (crud.isExist(acc)) {
				System.out.println("Username already exists!");
			} else {
				crud.create(acc);
				System.out.println("Account created successfully!");
			}
			this.goBack();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
