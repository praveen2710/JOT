package org.jtraning.bankAccount.exceptions;

public class InvalidNumberException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String getMessage(){
		return "lenght Of Number is invalid";
	}
	
}