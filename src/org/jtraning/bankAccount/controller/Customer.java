package org.jtraning.bankAccount.controller;

import java.util.HashMap;
import java.util.LinkedHashMap;

public abstract class Customer {
	private String name;
	private long custId;
	private String address;
	private static HashMap<Long,createAccount> custAcctList = new LinkedHashMap<Long,createAccount>();
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getCustId() {
		return custId;
	}
	public void setCustId(long custId) {
		this.custId = custId;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public abstract void createAccount();
	
	public static HashMap<Long,createAccount> getCustAcctList() {
		return custAcctList;
	}
	public static void setCustAcctList(HashMap<Long,createAccount> custAcctList) {
		Customer.custAcctList = custAcctList;
	}
}
