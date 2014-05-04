package org.jtraining.Exceptions;

public class InvalidWithdrawlAmmount extends Exception {

	@Override
	public String getMessage() {
		return "Invalid Withdrwal Amount Please Enter A Valid Amount";
	}
	
}
