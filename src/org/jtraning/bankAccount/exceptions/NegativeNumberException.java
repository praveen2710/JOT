package org.jtraning.bankAccount.exceptions;

public class NegativeNumberException extends Exception {
	@Override
	public String getMessage(){
		return "Number is Not postive Please Enter a positive Number";
	}
}
