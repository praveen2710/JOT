package org.jtraining.Exceptions;
//how to check all classes that can be implemented from super class in eclipse
public class InsufficientFundsException extends Exception {

	@Override
	public String getMessage(){
		return "Insufficient Funds please Enter a Valid amount";
	}
}
