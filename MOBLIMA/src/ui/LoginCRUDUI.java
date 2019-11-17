package ui;

/**
 * LoginCRUDUI inherits AbstractUI
 * @author Ronald
 */
public class LoginCRUDUI extends AbstractUI {

	/**
	 * constructor
	 */
	public LoginCRUDUI() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void start() {
		// TODO Auto-generated method stub
		System.out.println();
		System.out.println("0 : Create an account");
		System.out.println("1 : Login");
		System.out.println("2 : Back to previous menu");
		
		int choice = getInputChoice(0,2);
		
		this.run(choice);
	}
	
	/**
	 * case '0' display LoginCreateUI menu
	 * case '1' display menu enter username and password
	 * case '2' go back to previous menu, LoginUI
	 * @param choice
	 */
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
