package login.ui;

import base.AbstractUI;
import cache.Cache;

/**
 * UserUI inherits AbstractUI
 * @author Ronald
 *
 */
public class UserUI extends AbstractUI {

	/**
	 * constructor
	 */
	public UserUI() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void start() {
		// TODO Auto-generated method stub
		System.out.println();
		System.out.println("Welcome user "+Cache.getUsername());
	}

}
