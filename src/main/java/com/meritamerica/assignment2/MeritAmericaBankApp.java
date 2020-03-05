package com.meritamerica.assignment2;

public class MeritAmericaBankApp {
	public static void main(String[] args) {
		CDOffering[] CDOfferings = new CDOffering[5];

		CDOfferings[0] = new CDOffering(1,1.8/100);
		CDOfferings[1] = new CDOffering(2,1.9/100);
		CDOfferings[2] = new CDOffering(10,2.2/100);
		CDOfferings[3] = new CDOffering(5,2.5/100);
		CDOfferings[4] = new CDOffering(1,1.8/100);

		MeritBank.setCDOfferings(CDOfferings);

		AccountHolder ah1 = new AccountHolder();
		ah1.addCheckingAccount(1000);
		ah1.addSavingsAccount(10000);
		ah1.addCheckingAccount(5000);
		ah1.addSavingsAccount(50000);
		ah1.addCheckingAccount(50000);
		ah1.addSavingsAccount(500000);
		ah1.addCheckingAccount(5000);
		ah1.addSavingsAccount(50000);
		CDAccount ah1CD = new CDAccount(MeritBank.getBestCDOffering(1000), 1000);
		ah1.addCDAccount(ah1CD);
		MeritBank.addAccountHolder(ah1);
		AccountHolder ah2 = new AccountHolder("Reuben", "E", "Pena", "111222333");
		ah2.addCheckingAccount(1000);
		ah2.addSavingsAccount(10000);
		CDAccount ah2CD = new CDAccount(MeritBank.getSecondBestCDOffering(1000), 1000);
		ah2.addCDAccount(ah2CD);
		MeritBank.addAccountHolder(ah2);
		MeritBank.clearCDOfferings();
		AccountHolder ah3 = new AccountHolder();
		CDAccount ah3CD = new CDAccount(MeritBank.getSecondBestCDOffering(1000), 1000);
		ah3.addCDAccount(ah3CD);
		ah3.addCheckingAccount(1000);
		ah3.addSavingsAccount(10000);
		MeritBank.addAccountHolder(ah3);
		System.out.println(MeritBank.totalBalances());
	}
}