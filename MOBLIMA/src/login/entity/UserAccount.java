package login.entity;
/**
 * UserAccount inherits Account
 * @author Ronald
 */
public class UserAccount extends Account {
	/**
	 * methods to declare strings
	 */
	public static String directoryName="";
	public static String fileName="UserAccount.txt";
	
	/**
	 * constructor to activate constructor in Account class
	 * @param username
	 * @param password
	 */
	public UserAccount(String username, String password) {
		super(username, password);
	}

	/**
	 * constructor to activate constructor in Account class
	 * @param raw
	 */
	public UserAccount(String raw) {
		super(raw);	
	}

	/**
	 * method to get file path
	 * @return
	 */
	public static String getFilePath() {
		return directoryName + "/" + fileName;
	}
}
