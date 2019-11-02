package cache;

import base.AbstractCRUD;

public class Cache {
	private static String userName;
	private static AbstractCRUD currentCRUD;
	
	
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
