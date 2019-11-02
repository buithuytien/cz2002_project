package login;

import java.util.ArrayList;

import base.AbstractCRUD;

public class AccountCRUD <T extends Account> extends AbstractCRUD<T> {
	public AccountCRUD(){
		this.dataList = new ArrayList<T>();
	}
	
	
}
