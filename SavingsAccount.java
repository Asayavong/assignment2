package com.meritamerica.assignment1;

public class SavingsAccount {
	private double interestRate = 0.01;
	private double balance = 0;
	private long accountNumber= 0;
	
	//constructors
	public SavingsAccount(double openingBalance) {
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
		double futureValue = this.balance * Math.pow(1+.01, years);
		return futureValue;
	}
	
	//overridden toString
	
	public String toString() {
		String newString = "Savings Account Balance: " + this.balance + "\n"
				+ "Savings Account Interest Rate: " + this.interestRate + "\n"
				+ "Savings Account Balance in 3 years: " + this.futureValue(3); 
		return newString;
	
	}
	
	
}



