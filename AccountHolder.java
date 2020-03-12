package com.meritamerica.assignment1;


public class AccountHolder {
	private String firstName;
	private String middleName;
	private String lastName;
	private String ssn;
	CheckingAccount checkingAcc[] = new CheckingAccount[50]; 
	SavingsAccount savingsAcc[] = new SavingsAccount[50];
	CDAccount cdAcc[] = new CDAccount[50];
	private int checkingAccNum= 0;
	private int savingsAccNum= 0;
	private int cdAccNum= 0;
	double testChecking = 0;
	double testSavings = 0;
	double totalBalance = 0;
	
	
	
    //constructor 
    //default
	public AccountHolder() {
		this.firstName= "first";
		this.middleName= "middle";
		this.lastName= "last";
		this.ssn="123-45-6789";
	}
	//overloaded constructor
	public AccountHolder(String firstName,
			String middleName, 
			String lastName, 
			String ssn) 
	
	{
		this.firstName= firstName;
		this.middleName= middleName;
		this.lastName= lastName;
		this.ssn= ssn;
		
	}
	
	//methods
	//checking account methods new & adding existing
	public CheckingAccount addCheckingAccount(double openingBalance) {
	        testChecking = this.getCheckingBal();
	        testSavings = this.getSavingsBal();
	        double testAdd = openingBalance;
	        totalBalance = testChecking + testSavings + testAdd;
	        if (totalBalance > 250000){
	            System.out.println("Unable to Complete Action, Accounts Exceed Balance Limit.");
	            return checkingAcc[checkingAccNum];
	        } else {
	            checkingAcc[checkingAccNum] = new CheckingAccount(openingBalance);
	            checkingAccNum++;
	            return checkingAcc[checkingAccNum - 1];
	            }
	        }
		
	        
	public CheckingAccount addCheckingAcount(CheckingAccount prevCheckingAcc) {
		testChecking = this.getCheckingBal();
        testSavings = this.getSavingsBal();
        double testAdd = prevCheckingAcc.getBalance();
        totalBalance = testChecking + testSavings + testAdd;
        if (totalBalance > 250000){
            System.out.println("Unable to Complete Action, Accounts Exceed Balance Limit.");
            return checkingAcc[checkingAccNum];
        } else {
            checkingAcc[checkingAccNum] = prevCheckingAcc;
            checkingAccNum++;
            return checkingAcc[checkingAccNum - 1];
        }
    }
	//savings account new & adding existing
	public SavingsAccount addSavingsAccount(double openingBalance){
        testChecking = this.getCheckingBal();
        testSavings = this.getSavingsBal();
        double testAdd = openingBalance;
        totalBalance = testChecking + testSavings + testAdd;
        if (totalBalance > 250000){
            System.out.println("Unable to Complete Action, Accounts Exceed Balance Limit.");
            return savingsAcc[savingsAccNum];
        } else {
            savingsAcc[savingsAccNum] = new SavingsAccount(openingBalance);
            savingsAccNum++;
            return savingsAcc[savingsAccNum - 1];
        }
    }
	
	public SavingsAccount addSavingsAccount(SavingsAccount prevSavingsAcc){
        testChecking = this.getCheckingBal();
        testSavings = this.getSavingsBal();
        double testAdd = prevSavingsAcc.getBalance();
        totalBalance = testChecking + testSavings + testAdd;
        if (totalBalance > 250000){
            System.out.println("Unable to Complete Action, Accounts Exceed Balance Limit.");
            return savingsAcc[savingsAccNum];
        } else {
            savingsAcc[savingsAccNum] = prevSavingsAcc;
            savingsAccNum++;
            return savingsAcc[savingsAccNum - 1];
        }
    }
	//cd account methods new & existing
	public CDAccount addCDAccount(CDOffering offering, double openingBalance){
        cdAcc[cdAccNum] = new CDAccount(offering, openingBalance);
        cdAccNum++;
        return cdAcc[cdAccNum - 1];
    }
	
	public CDAccount addCDAccount(CDAccount cdAccount){
        if(cdAccount.equals(null)){
            System.out.println("Unable to Complete Action, Null CD Offer.");
            return null;
        }
        this.cdAcc[cdAccNum] = cdAccount;
        cdAccNum++;
        return this.cdAcc[cdAccNum - 1];
    }
		
	
	public String getFirstName() {
		return this.firstName;
	}
	public String getMiddleName() {
		return this.middleName;
	}
	public String getLastName() {
		return this.lastName;
	}
	public String getSSN() {
		return this.ssn;
	}
	
	public int getNumberOfSavingsAccs() {
		return this.savingsAccNum;
	}
	
	  public int getNumberOfCheckingAccs() {
	        return this.checkingAccNum;
	}
	  public int getNumberOfCdAccs() {
		  return this.cdAccNum;
	  }
	// get balances
	public double getCheckingBal() {
		double totalBalance= 0;
		for(int x= 0; x < checkingAccNum; x++) {
			totalBalance += checkingAcc[x].getBalance();
    }
        return totalBalance;
    }
	
	public double getSavingsBal() {
		double totalBalance= 0;
		for(int x= 0; x < savingsAccNum; x++){
			totalBalance += savingsAcc[x].getBalance();
		}
		return totalBalance;
	}
	
	public double getCDBal(){
        for(int x = 0; x < cdAccNum; x++){
            totalBalance += cdAcc[x].getBalance();
        }
        return totalBalance;
	}
        
        public double getCombinedBalance(){
	        totalBalance = this.getCheckingBal();
	        totalBalance += this.getSavingsBal();
	        totalBalance += this.getCDBal();
	        return totalBalance;
	 }
	
        
	
	public void setFirstName(String fN) {
		this.firstName=fN;
	}
	public void setMiddleName(String mN) {
			this.middleName= mN;
	}
	public void setLastName(String lN) {
		this.lastName= lN;
	}
	public void setSSN(String sN) {
		this.ssn= sN;
	}
	
	 


//overridden toString
public String toString() {
	String newString = "Name: " + this.firstName + "" + this.middleName + "" + this.lastName + "\n"
		+"SSN: "+ this.ssn + "\n";
	return newString;
}

}

