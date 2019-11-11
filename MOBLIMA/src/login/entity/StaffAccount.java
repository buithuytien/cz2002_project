package login.entity;

public class StaffAccount extends Account {
	public static String directoryName="";
	public static String fileName="StaffAccount.txt";
	
	public StaffAccount(String username, String password) {
		super(username, password);
		// TODO Auto-generated constructor stub
	}

	public StaffAccount(String raw) {
		super(raw);
		// TODO Auto-generated constructor stub
	}

	public static String getFilePath() {
		return directoryName + "/" + fileName;
	}
}
