package cache;

import crud.AbstractCRUD;

/**
 * class to access the database
 * @author Ronald
 *
 */
public class Cache {
	// Be really careful about the path (should include examples of Linux and Windows, Mac)
	/**
	 * to declare file path for database
	 */
	public static final String DBPath="/home/nhan/git/cz2002_project/MOBLIMA/db/";
	/**
	 * username of the account
	 */
	private static String userName;
	/**
	 * static nested class for currentCRUD to have access to attributes of AbstractCRUD
	 */
	private static AbstractCRUD currentCRUD;
	/**
	 * to check if user is a staff
	 */
	private static boolean isStaff;
	
	/**
	 * method to return true if user is a staff
	 * @return True or False
	 */
	public static boolean isStaff() {
		return isStaff;
	}
	
	/**
	 * mutator method to set the user as a staff
	 */
	public static void setStaff() {
		isStaff = true;
	}
	
	/**
	 * mutator method to set the username
	 * @param str
	 */
	public static void setUserName(String str) {
		userName = str;
	}
	
	/**
	 * accessor method to get the username
	 * @return the username of the account
	 */
	public static String getUsername() {
		return userName;
	}
	
	/**
	 * mutator method to set the current account object created
	 * @param obj
	 */
	public static void setCurrentCRUD(AbstractCRUD obj) {
		currentCRUD = obj;
	}
	
	/**
	 * mutator method to get the current account object created
	 * @return the account object
	 */
	public static AbstractCRUD getCurrentCRUD() {
		return currentCRUD;
	}
}
