package entity;

public abstract class AbstractEntity implements Comparable <AbstractEntity> {
	public static String directoryName="";
	public static String fileName;
	
	
	public abstract String processToDBString();
	
	public abstract String toString();
	
	public abstract boolean checkExistence(AbstractEntity object);
	
}
