//make Unique Account Number for each customer related to his custId
package org.jtraning.bankAccount.controller;

import java.util.*;

import org.jtraining.Exceptions.InsufficientFundsException;
import org.jtraining.Exceptions.InvalidWithdrawlAmmount;

public class createAccount{
 
  private long accountNumber;
  private double balance=0;
  private float intRate;
  private Date date;
  

  public createAccount(long acctNumber){
	 this.intRate=3;
	 this.balance=0;
	 this.accountNumber=acctNumber;
  }
  public createAccount(long acctNumber,double balance,float intRate){
    this.accountNumber=acctNumber;
    this.balance = balance;
    this.intRate = intRate;
    this.date = new Date();
  }

  public long getAcctNumber(){
    return accountNumber;
  } 
    
  public double getBalance(){
    return balance;
  }

  public float getIntRate(){
    return intRate;
  }

  public Date getDateCreated(){
    return date;
  }
  
  public void makeDeposit(float deposit){
	  balance +=deposit;//why use this
  }
  
  public double makeWithdrwal(double withdrawl) throws InsufficientFundsException,InvalidWithdrawlAmmount{
	  if(withdrawl<=0){
		  InvalidWithdrawlAmmount iwa = new InvalidWithdrawlAmmount();
		  throw iwa;
	  }
	  double newBal = balance - withdrawl;
	  if(newBal<0){
		  InsufficientFundsException ife = new InsufficientFundsException();
		  throw ife;
	  }
	  balance -=withdrawl;
	  return withdrawl;
  }
}
