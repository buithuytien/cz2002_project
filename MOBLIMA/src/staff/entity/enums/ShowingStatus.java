package staff.entity.enums;

public enum ShowingStatus {
	COMING_SOON("Coming Soon",2), PREVIEW("Preview",1), 
		NOW_SHOWING("Now Showing",0), END_SHOWING("Past Movie",3);
	private String nameStr;
	private int priority;
	ShowingStatus(String nameStr, int priority) {
		this.nameStr = nameStr;
		this.priority = priority;
	}
	
	public String getName() {
		return nameStr;
	}
	
	public int getPriority() {
		return priority;
	}
	
	public static int printChoices() {
		int N = ShowingStatus.values().length;
		for (int i=0; i<N; i++) {
			System.out.println(i+" : "+ShowingStatus.values()[i].getName());
		}
		
		return N;
	}
}
