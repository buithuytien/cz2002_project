package enums;

/**
 * different categories of film classification guidelines
 * @author Ronald
 *
 */
public enum MovieRating {
	PG("PG"), G("G"), R("R"), PG_13("PG-13"), NC_17("NC-17");
	
	/**
	 * classifications of the movie ratings, showin in the enumerations
	 */
	private String nameStr;
	
	/**
	 * constructor
	 * @param nameStr
	 */
	MovieRating(String nameStr) {
		this.nameStr = nameStr;
	}
	
	/**
	 * accessor method to get the classification of the movie
	 * @return name of the enumerations
	 */
	public String getName() {
		return nameStr;
	}
	
	/**
	 * method to print the classifications of each movie
	 * @return length of the data
	 */
	public static int printChoices() {
		int N = MovieRating.values().length;
		for (int i=0; i<N; i++) {
			System.out.println(i+" : "+MovieRating.values()[i].getName());
		}
		
		return N;
	}
}
