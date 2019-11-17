package enums;

/**
 * different categories of the status of the movie in the cinema
 * @author Ronald
 *
 */
public enum ShowingStatus {
	COMING_SOON("Coming Soon",2), PREVIEW("Preview",1), 
		NOW_SHOWING("Now Showing",0), END_SHOWING("End of Showing",3);
	/**
	 * status of the movie, given in the enumerations
	 */
	private String nameStr;
	/**
	 * integer value for sorting
	 * now showing-0, preview-1, coming soon-2, end of showing-3
	 */
	private int priority;
	/**
	 * constructor
	 * @param nameStr
	 * @param priority
	 */
	ShowingStatus(String nameStr, int priority) {
		this.nameStr = nameStr;
		this.priority = priority;
	}
	
	/**
	 * accessor method to get status of movie
	 * @return name of enumerations
	 */
	public String getName() {
		return nameStr;
	}
	
	/**
	 * accessor method to get integer value of priority 
	 * @return integer value of movie's priority
	 */
	public int getPriority() {
		return priority;
	}
	
	/**
	 * method to print the showing status for each movie
	 * @return length of data
	 */
	public static int printChoices() {
		int N = ShowingStatus.values().length;
		for (int i=0; i<N; i++) {
			System.out.println(i+" : "+ShowingStatus.values()[i].getName());
		}
		
		return N;
	}
}
