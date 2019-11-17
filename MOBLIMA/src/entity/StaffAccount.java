package entity;

/**
 * StaffAcount inherits Account
 * @author Ronald
 */
public class StaffAccount extends Account {
	/**
	 * method to declare strings
	 */
	public static String directoryName="";
	public static String fileName="StaffAccount.txt";
	
	/**
	 * constructor to activate constructor in Account class
	 * @param username
	 * @param password
	 */
	public StaffAccount(String username, String password) {
		super(username, password);
		// TODO Auto-generated constructor stub
	}

	/**
	 * constructor to activate constructor in Account class
	 * @param raw
	 */
	public StaffAccount(String raw) {
		super(raw);
		// TODO Auto-generated constructor stub
	}

	/**
	 * method to get file path
	 * @return the file path
	 */
	public static String getFilePath() {
		return directoryName + "/" + fileName;
	}
}
