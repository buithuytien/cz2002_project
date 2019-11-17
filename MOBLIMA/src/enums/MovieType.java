package enums;

/**
 * different categories of MovieType
 * @author Ronald
 *
 */
public enum MovieType {
	BLOCKBUSTER("Blockbuster"), NORMAL("Normal"), THREE_D("3D");
	
	/**
	 * names of the different categories of MovieType
	 */
	private String nameStr;
	
	/**
	 * constructor
	 * @param nameStr
	 */
	MovieType(String nameStr) {
		this.nameStr = nameStr;
	}
	
	/**
	 * method to get the name of the different categories
	 * @return name of the enumerations
	 */
	public String getName() {
		return nameStr;
	}
	
	/**
	 * method to print the movietype categories of all the movies
	 * @return length of the data
	 */
	public static int printChoices() {
		int N = MovieType.values().length;
		for (int i=0; i<N; i++) {
			System.out.println(i+" : "+MovieType.values()[i].getName());
		}
		
		return N;
	}
}
