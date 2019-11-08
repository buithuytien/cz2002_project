package staff.entity.enums;

public enum MovieRating {
	PG("PG"), G("G"), R("R"), PG_13("PG-13"), NC_17("NC-17");
	
	private String nameStr;
	
	MovieRating(String nameStr) {
		this.nameStr = nameStr;
	}
	
	public String getName() {
		return nameStr;
	}
	
	public static int printChoices() {
		int N = MovieRating.values().length;
		for (int i=0; i<N; i++) {
			System.out.println(i+" : "+MovieRating.values()[i].getName());
		}
		
		return N;
	}
}
