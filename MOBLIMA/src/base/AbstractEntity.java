package base;

public abstract class AbstractEntity implements Comparable <AbstractEntity> {
	private static final String PATH="./db/";
	private static String directoryName="";
	private String fileName;
	
	
	public abstract String processToDBString();
	
	public abstract String toString();
	
	public abstract boolean checkExistence(AbstractEntity object);
	
	public static String getFilePath(Class clazz) {
		String className = clazz.getSimpleName();
		directoryName = PATH+ className + "/";
		String filePath = directoryName + className + ".txt";
		System.out.println(filePath);
		
		return filePath;
	}
}
