package login.ui;

import base.AbstractUI;
import cache.Cache;
import login.crud.AccountCRUD;
import login.entity.Account;
import login.entity.UserAccount;
import staff.ui.StaffUI;
import user.ui.UserUI;

public class LoginValidateUI extends AbstractUI {

	public LoginValidateUI() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void start() {
		// TODO Auto-generated method stub
		System.out.println();
		System.out.println("Enter your username:");
		String username = getInputString();
		
		System.out.println("Enter your password");
		String password = getInputString();
		
		this.run(username, password);
	}
	
	public void run(String username, String password) {
		AccountCRUD crud = (AccountCRUD) Cache.getCurrentCRUD();
		try {
			Account acc = crud.createAccount(username, password);
			if (crud.validate(acc)) {
				System.out.println("Login Successfully");
				Cache.setUserName(acc.getUsername());
				if (acc instanceof UserAccount) {
					this.intent(new UserUI());
				}
				else {
					Cache.setStaff();
					this.intent(new StaffUI());
				}
			} else {
				System.out.println("Wrong login info");
				this.goBack();
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
