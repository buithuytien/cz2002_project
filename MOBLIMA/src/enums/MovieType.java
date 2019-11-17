package enums;

public enum MovieType {
	BLOCKBUSTER("Blockbuster"), NORMAL("Normal"), THREE_D("3D");
	
	private String nameStr;
	
	MovieType(String nameStr) {
		this.nameStr = nameStr;
	}
	
	public String getName() {
		return nameStr;
	}
	
	public static int printChoices() {
		int N = MovieType.values().length;
		for (int i=0; i<N; i++) {
			System.out.println(i+" : "+MovieType.values()[i].getName());
		}
		
		return N;
	}
}
