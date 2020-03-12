package com.meritamerica.assignment1;
import java.util.Date;

public class CDAccount {
	private double balance;
	CDOffering offering = new CDOffering(0,0);
	public java.util.Date date = new java.util.Date();
	private String startDate;
	private long accountNumber= 0;
	
	
	public CDAccount(CDOffering offering, double openingBalance) {
	this.offering = offering;
	this.balance= openingBalance;
	this.accountNumber = (long)(Math.random() * 100000);
	
	}

	public double getBalance() {
	return this.balance;
	}
	
	public double getInterestRate() {
		return this.offering.getInterestRate();
	}
	public int getTerm() {
		 return this.offering.getTerm();
	 }
	public java.util.Date startDate(){
		return this.date;
	}
	 
	 public long getAccountNumber() {
		 return this.accountNumber;
	 }
	 public double futureValue() {
			double futureValue = this.balance * Math.pow(1+getInterestRate(), getTerm());
			return futureValue;
		}
}
