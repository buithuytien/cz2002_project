package enums;

/**
 * different categories of CinemaClass
 * @author Ronald
 *
 */
public enum CinemaClass {
	PLATINUM("Platinum"), GOLD("Gold"), SILVER("Silver"), NORMAL("Normal");
	
	/**
	 * name of the categories 
	 */
	private String nameStr;
	
	/**
	 * constructor
	 * @param nameStr
	 */
	CinemaClass(String nameStr) {
		this.nameStr = nameStr;
	}
	
	/**
	 * accessor method to get the name of the categories
	 * @return name of the enumerations
	 */
	public String getName() {
		return nameStr;
	}
	
	/**
	 * method to print the class categories of the all the cinemas
	 * @return length of the data
	 */
	public static int printChoices() {
		int N = CinemaClass.values().length;
		for (int i=0; i<N; i++) {
			System.out.println(i+" : "+CinemaClass.values()[i].getName());
		}
		
		return N;
	}
}
