package staff.entity.enums;

public enum CinemaClass {
	PLATINUM("Platinum"), GOLD("Gold"), SILVER("Silver"), NORMAL("Normal");
	
	private String nameStr;
	
	CinemaClass(String nameStr) {
		this.nameStr = nameStr;
	}
	
	public String getName() {
		return nameStr;
	}
}
