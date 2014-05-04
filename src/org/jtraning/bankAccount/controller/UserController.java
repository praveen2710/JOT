package org.jtraning.bankAccount.controller;

/*Still need to figure how to handle letters in place of number
*the try catch block works and I initialize it a while of 9
but loop runs infintely.Tried resetting option to 0 at beginning of loop
but does not seem to affect need to have a look at it later.
*/
/*
switch() case break;
every switch starts with switch and every case has a break;
also do while() has ; at end of while
*/
/*
 *This class is getting way to big need to break it down to different classes 
 */
import java.util.*;

import org.jtraning.bankAccount.exceptions.InsufficientFundsException;
import org.jtraning.bankAccount.exceptions.InvalidWithdrawlAmmount;
import org.jtraning.bankAccount.exceptions.NegativeNumberException;



public class UserController{
// INSTANCE VAR
  static HashMap<String,Customer> cNameList = new LinkedHashMap<String,Customer>();//how to handle two customer with same Name
  static HashMap<Long,String> cIdList = new LinkedHashMap<Long,String>();
  
  public static void main(String args[]){
	  
//	  doSomething(new personalCustomer("Praveen"));
	  Scanner sn = new Scanner(System.in);
	long custId;
    double bal;
    int option;
    String custName;
    do{  
      option=0;
      System.out.println("Please Select from menu below");
      System.out.println("1.Create Personal Customer");
//      System.out.println("2.Create Commericial Customer");
      System.out.println("3.Record Transaction");
      System.out.println("4.Make Withdrawl");   
      System.out.println("5.Display Customer");
//      System.out.println("6.Display Customer Summary");
//      System.out.println("7.Display Grand Summary");
//      System.out.println("8.Exit");
//      System.out.println("Please Enter a option");
      try{
       option=sn.nextInt();
      }
      catch(Exception e){
        System.out.println("Please Enter a number");
        option = 9;
      }
//      System.out.println(option+"value is");
      switch(option){
        case 1:	System.out.println("Enter the name of the Customer");
        		String pcName = sn.next();
        		cNameList.put(pcName,new personalCustomer(pcName));
        		custId = cNameList.get(pcName).getCustId();
        		cIdList.put(custId,pcName);
        		bal=cNameList.get(pcName).getCustAcctList().get(custId).getBalance();
        		System.out.println("CustId:"+custId+"Balance:"+bal);
        		break;
//        case 2:break;
        case 3:	 while(true){
		    		try{
		    			System.out.println("Enter Customer Id");
		    			custId = sn.nextLong(); //looping problem
		    			break;
		    		}
		    		catch(Exception e){
		    			System.out.println("Invalid Entry please enter a Numeric value");
		    		}
	    		}
        		if(cIdList.containsKey(custId)){
	        		custName = cIdList.get(custId);
	        		CustomerTransaction ct = new CustomerTransaction();
	        		System.out.println("Enter Gold Weight");
	        		float gWeight = sn.nextFloat();
					try {
						ct.setGoldWeight(gWeight);
					} catch (NegativeNumberException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	        		System.out.println("Enter Silver Weight");
	        		float sWeight = sn.nextFloat();
					try {
						ct.setSilverWeight(sWeight);
					} catch (NegativeNumberException e) {
						// TODO Auto-generated catch block
						e.getMessage();
					}
					float deposit=ct.totalValue();
					cNameList.get(custName).getCustAcctList().get(custId).makeDeposit(deposit);
					System.out.println("New Balance is"+cNameList.get(custName).getCustAcctList().get(custId).getBalance());
        		}
        		else{
        			System.out.println("Customer Does not exist");
        		}
        		break;
        case 4:while(true){
		    		try{
		    			System.out.println("Enter Customer Id");
		    			custId = sn.nextLong(); //looping problem
		    			break;
		    		}
		    		catch(Exception e){
		    			System.out.println("Invalid Entry please enter a Numeric value");
		    		}
				}
        		if(cIdList.containsKey(custId)){
	        		custName = cIdList.get(custId);
	        		System.out.println("Enter Amount to be withdrawn");
	        		double withdraw = sn.nextFloat();
					try {
						cNameList.get(custName).getCustAcctList().get(custId).makeWithdrwal(withdraw);
					} catch (InsufficientFundsException e) {
						// TODO Auto-generated catch block
						e.getMessage();
					} catch (InvalidWithdrawlAmmount e) {
						// TODO Auto-generated catch block
						e.getMessage();
					}
					System.out.println("New Balance is"+cNameList.get(custName).getCustAcctList().get(custId).getBalance());
        		}
        		else{
        			System.out.println("Customer Does not exist");
        		}
        		break;
        case 5:System.out.println("Enter the Customer Name");
        		custName = sn.next();//nextLine check
        		if(cNameList.containsKey(custName)){
	        		System.out.println(cNameList.get(custName).getName());
	        		System.out.println(cNameList.get(custName).getCustId());
	        		System.out.println(cNameList.get(custName).getCustAcctList().get(cNameList.get(custName).getCustId()).getBalance());
	  
        		}
        		else{
        			System.out.println("No Such Customer Exists");
        		}
        		break;
        case 6:System.out.println("Total Number Of Customers are"+cNameList.size());
        		//total Sum Of accounts;
        		break;
//        case 7:break;
//        case 8:break;
//        default:System.out.println("Invalid Option Please choose a valid option");
//                break;
      }

    }while(option!=8);
    
  }
  
//  public static boolean numericEntry(){ // to check and loop on Numeric value;
//	  while(true){
//		try{
//			System.out.println("Enter Customer Id");
//			return true;
//		}
//		catch(Exception e){
//			System.out.println("Invalid Entry please enter a Numeric value");
//		}
//		}	  
//  }
//  
  public static void doSomething(Customer cust){
	  
	  if(cust instanceof commercialCustomer){
		  System.out.println(cust.getName() + " is a commercial customer");
	  } else {
		  System.out.println(cust.getName() + " is a personal customer");
	  }
  }

}
;