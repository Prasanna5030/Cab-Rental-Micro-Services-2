package com.sl.Exception;

public class UserNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public String username;
	
	public UserNotFoundException(String username) {
		
		super("User" + username +"nor exists");
		this.username=username;
	}
	

}
