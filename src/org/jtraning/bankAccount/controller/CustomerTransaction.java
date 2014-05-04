package org.jtraning.bankAccount.controller;

import java.awt.geom.Arc2D.Float;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.UUID;

import org.jtraning.bankAccount.exceptions.NegativeNumberException;

public class CustomerTransaction {
	private static final float goldPrice = 34;
	private static final float silverPrice =  16;
	private float goldWeight;
	private float silverWeight;
	private float totalValue;
	private static HashMap<UUID,Customer> transCust= new LinkedHashMap<UUID,Customer>();
	UUID transcId;
	Date date;
	public CustomerTransaction(){
		transcId = UUID.randomUUID();
		date = new Date();
	}
	
	public float getGoldWeight() {
		return goldWeight;
	}
	public void setGoldWeight(float goldWeight) throws NegativeNumberException {
		if(goldWeight<0){
			NegativeNumberException nne = new NegativeNumberException();
			throw nne;
		}
		else{
			this.goldWeight = goldWeight;
		}
	}
	public float getSilverWeight() {
		return silverWeight;
	}
	public void setSilverWeight(float silverWeight) throws NegativeNumberException  {
		if(silverWeight<0){
			NegativeNumberException nne = new NegativeNumberException();
			throw nne;
		}
		else{
			this.silverWeight = silverWeight;
		}
		
	}
	public float totalValue(){
		totalValue = (goldWeight * goldPrice) + (silverWeight * silverPrice);
		return totalValue;
	}

	public static HashMap<UUID,Customer> getTransCust() {
		return transCust;
	}

	public static void setTransCust(HashMap<UUID,Customer> transCust) {
		CustomerTransaction.transCust = transCust;
	}
}
