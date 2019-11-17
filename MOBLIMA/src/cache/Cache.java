package cache;

import crud.AbstractCRUD;

public class Cache {
	// Be really careful about the path (should include examples of Linux and Windows, Mac)
	public static final String DBPath="/home/nhan/git/cz2002_project/MOBLIMA/db/";
	private static String userName;
	private static AbstractCRUD currentCRUD;
	private static boolean isStaff;
	
	public static boolean isStaff() {
		return isStaff;
	}
	
	public static void setStaff() {
		isStaff = true;
	}
	
	public static void setUserName(String str) {
		userName = str;
	}
	
	public static String getUsername() {
		return userName;
	}
	
	public static void setCurrentCRUD(AbstractCRUD obj) {
		currentCRUD = obj;
	}
	
	public static AbstractCRUD getCurrentCRUD() {
		return currentCRUD;
	}
}
