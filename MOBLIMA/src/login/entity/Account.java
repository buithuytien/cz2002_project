package login.entity;

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
	
	public boolean validate(Account object) {
		if ((this.username.equals(object.getUsername())) && (this.hashPass.equals(object.getHashPass())))
			return true;
		return false;
	}
	
	@Override
	public int compareTo(AbstractEntity arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String processToDBString() {
		StringBuilder st = new StringBuilder();
		st.append(this.username.trim());
		st.append(TextDB.SEPERATOR);
		st.append(this.hashPass.trim());
		
		return st.toString();
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.username;
	}

	@Override
	public boolean checkExistence(AbstractEntity object) {
		if (object instanceof Account)
			if (((Account) object).getUsername().equals(this.username))
				return true;
		return false;
	}

	public String getHashPass() {
		return this.hashPass;
	}
	
	public String getUsername() {
		return this.username;
	}
	
}
