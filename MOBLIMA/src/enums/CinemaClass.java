package enums;

public enum CinemaClass {
	PLATINUM("Platinum"), GOLD("Gold"), SILVER("Silver"), NORMAL("Normal");
	
	private String nameStr;
	
	CinemaClass(String nameStr) {
		this.nameStr = nameStr;
	}
	
	public String getName() {
		return nameStr;
	}
	
	public static int printChoices() {
		int N = CinemaClass.values().length;
		for (int i=0; i<N; i++) {
			System.out.println(i+" : "+CinemaClass.values()[i].getName());
		}
		
		return N;
	}
}
