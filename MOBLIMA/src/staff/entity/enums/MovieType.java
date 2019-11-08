package staff.entity.enums;

public enum MovieType {
	BLOCKBUSTER("Blockbuster"), NORMAL("Normal"), THREE_D("3D");
	
	private String nameStr;
	
	MovieType(String nameStr) {
		this.nameStr = nameStr;
	}
	
	public String getName() {
		return nameStr;
	}
}
