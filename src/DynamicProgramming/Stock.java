package DynamicProgramming;

import java.util.ArrayList;

public class Stock {
//	If you were only permitted to complete at most one transaction (ie, buy one and sell 
//	one share of the stock), design an algorithm to find the maximum profit.
	public int maxProfitI(final ArrayList<Integer> a) {
	    if (a==null || a.size()==0 || a.size()==1) {
	        return 0;
	    }
	    int max=0;
	    int min=a.get(0);
	    //Find maximum of a[i]-a[j] where i>j
	    for (int i=1;i<a.size();i++) {
	        int v=a.get(i);
	        if (v>min) {
	        	//Check max value if the current price minus minimum price of previous day is larger
	        	//Update max (if necessary)
	            if (v-min>max) {
	                max=v-min;
	            }
	        } else if (v<min) {
	        	//Replace minimum value --> Increase the difference in price
	            min=v;
	        }
	    }
	    return max;
	}
	
	//Given an array for which the ith element is the price of a given stock on day i.
	//Design an algorithm to find the maximum profit. You may complete as many transactions 
	//as you like (ie, buy one and sell one share of the stock multiple times). However, 
	//you may not engage in multiple transactions at the same time (ie, you must sell the stock 
	//before you buy again).
	public int maxProfitII(final ArrayList<Integer> a) {
	    if (a==null || a.size()==0 || a.size()==1) {
	        return 0;
	    }
	    int sum=0;
	    //Sell stock whenever a stock price of the next day is higher than the current day
	    for (int i=1;i<a.size();i++) {
	        int v=a.get(i-1);
	        int u=a.get(i);
	        if (u>v) {
	            sum+=(u-v);
	        }
	    }
	    return sum;
	}
}
