package org.jtraning.bankAccount.controller;

/*enum for customer type account 
abstract class or inhertiance to avoid writing getter and setter for each variable that are common
need to figure out how to differentiate commerical cutomer and personal customer
*/

import java.util.*;

import org.jtraning.bankAccount.exceptions.InvalidNumberException;

public class commercialCustomer extends Customer{
	private String contactPerson;
	private long contactPersonNumber;
	
	public commercialCustomer(String str){
		setName(str);
	}

	public String getContactPerson() {
		return contactPerson;
	}

	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}

	public long getContactPersonNumber() {
		return contactPersonNumber;
	}

	public void setContactPersonNumber(long phone) throws InvalidNumberException {
		int phoneLength=Long.toString(phone).length();
		if(phoneLength!=10){
			InvalidNumberException ine = new InvalidNumberException();
			throw ine;
		}	
		else{
			this.contactPersonNumber = phone;
		}
	}

	@Override
	public void createAccount() {
		System.out.println("Absctracr Methid or a new class");
		
	}
}

