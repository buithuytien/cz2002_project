package staff.entity.enums;

public enum ShowingStatus {
	COMING_SOON("Coming Soon"), PREVIEW("Preview"), NOW_SHOWING("Now Showing"), END_SHOWING("End of Showing");
	
	private String nameStr;
	
	ShowingStatus(String nameStr) {
		this.nameStr = nameStr;
	}
	
	public String getName() {
		return nameStr;
	}
}
