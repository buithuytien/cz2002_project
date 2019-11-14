package base;

/**
 * abstract class AbstractEntity realises AbstractEntity 
 * objects can be naturally ordered through 'comparable'
 *
 */
public abstract class AbstractEntity implements Comparable <AbstractEntity> {
	/**
	 * method to declare the strings 
	 */
	public static String directoryName="";
	public static String fileName;
	
	/**
	 * abstract method to store username and password as string
	 * to be override
	 * @return
	 */
	public abstract String processToDBString();
	
	/**
	 * abstract method to convert other data types to string
	 * to be override
	 */
	public abstract String toString();
	/**
	 * abstract method to return true if the username password combination is valid
	 * return false if the username password combination is not valid
	 * to be override
	 * @param object
	 * @return
	 */
	
	public abstract boolean checkExistence(AbstractEntity object);
	
}
