package login.entity;

public class UserAccount extends Account {
	public static String directoryName="";
	public static String fileName="UserAccount.txt";
	
	public UserAccount(String username, String password) {
		super(username, password);
	}

	public UserAccount(String raw) {
		super(raw);	
	}

	public static String getFilePath() {
		return directoryName + "/" + fileName;
	}
}
