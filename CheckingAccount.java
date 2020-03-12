package com.meritamerica.assignment1;

public class CheckingAccount {
	private double balance = 0;
	private double interestRate= 0.0001;
	private long accountNumber= 0;
	
	
	//constructor
	public CheckingAccount(double openingBalance) {
		this.balance = openingBalance;
		
	}
	
	public double getBalance() {
		return this.balance;
	}
	public double getInterestRate() {
		return this.interestRate;
	}
	public long getAccountNumber() {
		return this.accountNumber;
	}
	
	public boolean withdraw(double amount) {
		if(amount > 0 && amount <= balance) {
		this.balance -= amount;
		return true;
		} else {
		System.out.println("not enough funds");
		return false;
		}
	}
	
	public boolean deposit(double amount) {
		if(amount >= 0) {
			this.balance += amount;
			return true;
		}else {
			return false;
		}
	}
	public double futureValue(int years) {
		double futureValue = this.balance * Math.pow(1+.0001, years);
		return futureValue;
	}
	
	//overridden toString
	public String toString() {
		String newString = "Checking Account Balance: " + this.balance + "\n"
				+ "Checking Account Interest Rate: " + this.interestRate + "\n"
				+ "Checking Account Balance in 3 years: " + this.futureValue(3);
		return newString;
		
	}
	
	
}