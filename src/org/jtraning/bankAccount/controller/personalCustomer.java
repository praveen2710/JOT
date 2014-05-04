package org.jtraning.bankAccount.controller;


/*
* need to understand use of math.random also how to return multiple type in one get method
*/

import java.util.*;

import org.jtraning.bankAccount.exceptions.InvalidNumberException;

public class personalCustomer extends Customer{
	
	private long homePhone;
	private long workPhone;
	Scanner sn = new Scanner(System.in);
	private static long custId = 10000;
	
	public personalCustomer(String str){
		setName(str);
		setCustId(custId);
		custId++;
		createAccount();
	}

	public long getWorkPhone() {
		return workPhone;
	}
	
	public void setWorkPhone(long Phone) throws InvalidNumberException {
		int phoneLength=Long.toString(Phone).length();
		if(phoneLength!=10){
			InvalidNumberException ine = new InvalidNumberException();
			throw ine;
		}	
		else{
			this.workPhone = Phone;
		}
	}

	public long getHomePhone() {
		return homePhone;
	}

	public void setHomePhone(long Phone) throws InvalidNumberException {
		int phoneLength=Long.toString(Phone).length();//boxing
		if(phoneLength!=10){
			InvalidNumberException ine = new InvalidNumberException();
			throw ine;
		}	
		else{
			this.homePhone = Phone;
		}
	}
	
	@Override
	public void createAccount() {
		System.out.println("Enter Interest Rate");//how to intiate if user enters nothing dont want to do nextLinea as he can enter string  which raise a whole new set of errosrs
		float intRate = sn.nextFloat();
		System.out.println("Enter Initial Balance");
		long balance = sn.nextLong();
//		createAccount createAccount = new createAccount(custId,intRate,balance); //same as before use hash map ?
		getCustAcctList().put(getCustId(), new createAccount(getCustId(),balance,intRate)); //what if each customer has multiple accounts ?
	}
	
}
