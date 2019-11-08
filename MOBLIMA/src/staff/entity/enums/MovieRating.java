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
}
