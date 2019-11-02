package login;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.StringTokenizer;

import base.AbstractEntity;
import util.TextDB;

public class Account extends AbstractEntity {
	private String username;
	private String hashPass;
	
	public Account(String username, String password) {
		this.username = username;
		this.hashPass = hashFunction(password);
	}
	
	public Account(String raw) {
		StringTokenizer star = new StringTokenizer(raw, TextDB.SEPERATOR);
		
		String username = star.nextToken().trim();
		String hashPass = star.nextToken().trim();
		
		this.username = username;
		this.hashPass = hashPass;
	};
	
	private String hashFunction(String passwordToHash) {
		String generatedPassword = null;
		
		try {
            // Create MessageDigest instance for MD5
            MessageDigest md = MessageDigest.getInstance("MD5");
            //Add password bytes to digest
            md.update(passwordToHash.getBytes());
            //Get the hash's bytes 
            byte[] bytes = md.digest();
            //This bytes[] has bytes in decimal format;
            //Convert it to hexadecimal format
            StringBuilder sb = new StringBuilder();
            for(int i=0; i< bytes.length ;i++)
            {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            //Get complete hashed password in hex format
            generatedPassword = sb.toString();
        } 
        catch (NoSuchAlgorithmException e) 
        {
            e.printStackTrace();
        }
		
		return generatedPassword;
	}
	
	@Override
	public int compareTo(AbstractEntity arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String processToDBString() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean checkExistence(AbstractEntity object) {
		// TODO Auto-generated method stub
		return false;
	}

}
