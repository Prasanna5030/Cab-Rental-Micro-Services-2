package com.sl.Exception;

public class DriverNotAvailableException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String message;
	public DriverNotAvailableException(String message) {
		super(message);
		this.message= message; 
	}
	

}
