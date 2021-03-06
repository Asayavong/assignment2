package com.meritamerica.assignment2;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Objects;

/*
 * @author Reuben Pena
 * @date 3/5/2020
 * @description Account Holder Class used to hold information on the account holder
 * as well as connect checking and savings account information in one place.
 */

public class AccountHolder {
    // Variables of Class
    private String firstName;
    private String middleName;
    private String lastName;
    private String ssn;
    public CheckingAccount checking[] = new CheckingAccount[50];
    public SavingsAccount savings[] = new SavingsAccount[50];
    public CDAccount cdAccount[] = new CDAccount[50];
    private int checkingAccountNum = 0;
    private int savingsAccountNum = 0;
    private int cdAccountNum = 0;


    // Constructors
    public AccountHolder() {
        this.firstName = "John";
        this.middleName = "M";
        this.lastName = "Doe";
        this.ssn = "n/a";
    }

    public AccountHolder(String fn, String mn, String ln, String sn){
        this.firstName = fn;
        this.middleName = mn;
        this.lastName = ln;
        this.ssn = sn;
    }

    // Setters and Getters
    public void setFirstName(String fn){
        this.firstName = fn;
    }

    public String getFirstName(){
        return this.firstName;
    }

    public void setMiddleName(String mn){
        this.middleName = mn;
    }

    public String getMiddleName(){
        return this.middleName;
    }

    public void setLastName(String ln){
        this.lastName = ln;
    }

    public String getLastName(){
        return this.lastName;
    }

    public void setSSN(String sn){
        this.ssn = sn;
    }

    public String getSSN(){
        return this.ssn;
    }

    // Methods

    /* ******************************************
     *********************************************
     * Code from Assignment 2
     *********************************************
     *********************************************
     */

    public CheckingAccount addCheckingAccount(double checkingB){
        double tBalance = 0;
        double tChecking = 0;
        double tSaving = 0;
        tChecking = this.getCheckingBalance();
        tSaving = this.getSavingsBalance();
        tBalance = this.getCheckingBalance();
        double testAdd = checkingB;
        tBalance = tChecking + tSaving + testAdd;
        if (tBalance > 250000){
            System.out.println("Unable to Complete Action, Accounts Exceed Balance Limit.");
            return checking[checkingAccountNum];
        } else {
            checking[checkingAccountNum] = new CheckingAccount(checkingB);
            checkingAccountNum++;
            return checking[checkingAccountNum - 1];
        }
    }

    public CheckingAccount addCheckingAccount(CheckingAccount checkingAccountX){
        double tBalance = 0;
        double tChecking = 0;
        double tSaving = 0;
        tChecking = this.getCheckingBalance();
        tSaving = this.getSavingsBalance();
        double testAdd = checkingAccountX.getBalance();
        tBalance = tChecking + tSaving + testAdd;
        if (tBalance > 250000){
            System.out.println("Unable to Complete Action, Accounts Exceed Balance Limit.");
            return checking[checkingAccountNum];
        } else {
            checking[checkingAccountNum] = checkingAccountX;
            checkingAccountNum++;
            return checking[checkingAccountNum - 1];
        }
    }

    public void getCheckingAccountTest(){
        if(checkingAccountNum == 0){
            System.out.println("There are no checking Accounts for this holder.");
        } else {
            for (int x = 0; x < checkingAccountNum; x++){
                System.out.println("Account " + x + " has a balance of: $" + checking[x].getBalance());
            }
        }
    }

    public CheckingAccount[] getCheckingAccounts(){
        return this.checking;
    }

    public int getNumberOfCheckingAccounts(){
        return this.checkingAccountNum;
    }

    public double getCheckingBalance(){
        double tBalance = 0;
        for(int x = 0; x < checkingAccountNum; x++){
            tBalance += checking[x].getBalance();
        }
        return tBalance;
    }

    public SavingsAccount addSavingsAccount(double openingBalance){
        double tBalance = 0;
        double tChecking = 0;
        double tSaving = 0;
        tChecking = this.getCheckingBalance();
        tSaving = this.getSavingsBalance();
        tBalance = this.getCheckingBalance();
        double testAdd = openingBalance;
        tBalance = tChecking + tSaving + testAdd;
        if (tBalance > 250000){
            System.out.println("Unable to Complete Action, Accounts Exceed Balance Limit.");
            return savings[savingsAccountNum];
        } else {
            savings[savingsAccountNum] = new SavingsAccount(openingBalance);
            savingsAccountNum++;
            return savings[savingsAccountNum - 1];
        }
    }

    public SavingsAccount addSavingsAccount(SavingsAccount savingsAccountX){
        double tBalance = 0;
        double tChecking = 0;
        double tSaving = 0;
        tChecking = this.getCheckingBalance();
        tSaving = this.getSavingsBalance();
        tBalance = this.getCheckingBalance();
        double testAdd = savingsAccountX.getBalance();
        tBalance = tChecking + tSaving + testAdd;
        if (tBalance > 250000){
            System.out.println("Unable to Complete Action, Accounts Exceed Balance Limit.");
            return savings[savingsAccountNum];
        } else {
            savings[savingsAccountNum] = savingsAccountX;
            savingsAccountNum++;
            return savings[savingsAccountNum - 1];
        }
    }

    public SavingsAccount[] getSavingsAccounts(){
        return this.savings;
    }

    public int getNumberOfSavingsAccounts(){
        return this.savingsAccountNum;
    }

    public double getSavingsBalance(){
        double tBalance = 0;
        for(int x = 0; x < savingsAccountNum; x++){
            tBalance += savings[x].getBalance();
        }
        return tBalance;
    }

    public CDAccount addCDAccount(CDOffering offering, double openingBalance){
        cdAccount[cdAccountNum] = new CDAccount(offering, openingBalance);
        cdAccountNum++;
        return cdAccount[cdAccountNum - 1];
    }

    public CDAccount addCDAccount(CDAccount cdAccount){
        if(cdAccount.equals(null)){
            System.out.println("Unable to Complete Action, Null CD Offer.");
            return null;
        }
        this.cdAccount[cdAccountNum] = cdAccount;
        cdAccountNum++;
        return this.cdAccount[cdAccountNum - 1];
    }

    public CDAccount[] getCDAccounts(){
        return this.cdAccount;
    }

    public int getNumberOfCDAccounts(){
        return this.cdAccountNum;
    }

    public double getCDBalance(){
        double tBalance = 0;
        for(int x = 0; x < cdAccountNum; x++){
            tBalance += cdAccount[x].getBalance();
        }
        return tBalance;
    }

    public double getCombinedBalance(){
        double tBalance;
        tBalance = this.getCheckingBalance();
        tBalance += this.getSavingsBalance();
        tBalance += this.getCDBalance();
        return tBalance;
    }

    public String toString(){
        DecimalFormat format = new DecimalFormat("##.00");
        return "Name: " + this.firstName + " " + this.middleName + " " + this.lastName + "\n"
                + "SSN: " + this.ssn + "\n";
    }

    /*
    * Was going to override both methods however decided not to edit
    * from default.
    * */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountHolder that = (AccountHolder) o;
        return checkingAccountNum == that.checkingAccountNum &&
                savingsAccountNum == that.savingsAccountNum &&
                cdAccountNum == that.cdAccountNum &&
                Objects.equals(firstName, that.firstName) &&
                Objects.equals(middleName, that.middleName) &&
                Objects.equals(lastName, that.lastName) &&
                Objects.equals(ssn, that.ssn) &&
                Arrays.equals(checking, that.checking) &&
                Arrays.equals(savings, that.savings) &&
                Arrays.equals(cdAccount, that.cdAccount);
    }

    @Override
    public int hashCode() {

        int result = Objects.hash(firstName, middleName, lastName, ssn, checkingAccountNum, savingsAccountNum, cdAccountNum);
        result = 31 * result + Arrays.hashCode(checking);
        result = 31 * result + Arrays.hashCode(savings);
        result = 31 * result + Arrays.hashCode(cdAccount);
        return result;
    }
}