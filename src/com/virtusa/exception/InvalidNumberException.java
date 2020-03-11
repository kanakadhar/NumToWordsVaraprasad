package com.virtusa.exception;

public class InvalidNumberException extends Exception {

	/**
	 * Its a custom checked exception to be throw when given input is not a number
	 */
	private static final long serialVersionUID = 1539563303939097239L;

	public InvalidNumberException() {}
	
	public InvalidNumberException(String message) {
		super(message);		
	}
	
}
