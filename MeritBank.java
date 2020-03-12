package com.meritamerica.assignment1;

public class MeritBank {
	static int accHolderNum = 0;
	static int cdOfferingNum = 0;
	static AccountHolder accHolderArray[] = new AccountHolder[50];
	static CDOffering cdOffering[] = new CDOffering[50];
	
	
	public static void addAccountHolder(AccountHolder newaccHolder) {
		accHolderArray[accHolderNum] = newaccHolder;
		accHolderNum++;
		
	}
	
	static AccountHolder[] getAccountHolders() {
		return accHolderArray;
	}
	
	
	static CDOffering[] getCdOfferings() {
		return cdOffering;
	}
	
	
	 static CDOffering getBestCDOffering(double depositAmount){
	        int best = 0;
	        double tv;
	        double fv;
	        if (cdOfferingNum < 2){
	            System.out.println("Unable to complete action. Need more CD Offers.");
	            return cdOffering[0];
	        }
	        for(int x = 0; x < cdOffering.length; x++){
	            double pv = depositAmount;
	            tv = pv * (Math.pow((1 + cdOffering[x].getInterestRate()), cdOffering[x].getTerm()));
	            fv = pv * (Math.pow((1 + cdOffering[best].getInterestRate()), cdOffering[best].getTerm()));
	            if (tv > fv){
	                best = x;
	            }
	        }
	        return cdOffering[best];
	    }
	   static CDOffering getSecondBestCDOffering(double depositAmount){
	        int best = 0;
	        int second = 0;
	        double tv;
	        double fv;
	        double sv;
	        if (cdOfferingNum < 2){
	            System.out.println("Unable to complete action. Need more CD Offers.");
	            return null;
	        }
	        for(int x = 0; x < cdOffering.length; x++){
	            double pv = depositAmount;
	            tv = pv * (Math.pow((1 + cdOffering[x].getInterestRate()), cdOffering[x].getTerm()));
	            fv = pv * (Math.pow((1 + cdOffering[best].getInterestRate()), cdOffering[best].getTerm()));
	            sv = pv * (Math.pow((1 + cdOffering[second].getInterestRate()), cdOffering[second].getTerm()));
	            if (tv > fv){
	                second = best;
	                best = x;
	            }
	            else if(tv > sv && tv != fv){
	                second = x;
	            }
	        }
	        return cdOffering[second];
	    }
	
	   static void clearCDOfferings(){
	        CDOffering newArr[] = null;
	        cdOffering = newArr;
	        cdOfferingNum = 0;
	    }

	    static void setCDOfferings(CDOffering[] offers){
	        cdOffering = offers;
	        cdOfferingNum = offers.length;
	    }

	    static double totalBalances(){
	        double totalBalance = 0;
	        for(int x = 0; x < accHolderNum; x++){
	            totalBalance += accHolderArray[x].getCombinedBalance();
	        }
	        return totalBalance;
	    }

	    static long getNextAccountNumber(){
	        return (long)(Math.random() * 100000);
	    }
	
	

}
