package com.sl.Exception;

public class TripNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public String message;
	
	public TripNotFoundException(String message) {
		super(message);
		this.message= message;
	}

}
