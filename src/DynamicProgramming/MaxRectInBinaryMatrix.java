package DynamicProgramming;

import java.util.ArrayList;

//Problems: Given a 2D binary matrix filled with 0’s and 1’s
//Find the largest rectangle containing all ones and return its area.
//Example:
//1 1 1
//0 1 1
//1 0 0
//Answer: 4 (point (0,1) and point (2,2) form an 4x4 all-one rectangle)
public class MaxRectInBinaryMatrix {
	public int maximalRectangle(ArrayList<ArrayList<Integer>> a) {
	    if (a==null || a.size()==0) {
	        return 0;
	    }
	    int max=0;
	    int cur=0;
	    ArrayList<Integer> holder=a.get(0);
	    //Calculate the maximum area in the first row
	    //In the example above --> max=3 (1 1 1)
	    for (int i=0;i<holder.size();i++) {
	        if (holder.get(i)==1) {
	            cur++;
	        } else {
	            if (cur>max) {
	                max=cur;
	            }
	            cur=0;
	        }
	    }
	    if (cur>max) {
	        max=cur;
	    }
	    
	    for (int i=1;i<a.size();i++) {
	        holder=a.get(i);
	        //streak[i] store the continuous occurrence of 
	        //columns that has number of 1s appear continuously 
	        //from the rows above to the current row is >=i
	        //In the example above
	        //1 1 1
	        //0 2 2
	        //1 0 0
	        int[] streak= new int[i+2];
	        for (int k=0;k<holder.size();k++) {
	            if (holder.get(k)==1) {
	            	//Number of consecutive columns with 1s + 1
	                holder.set(k,a.get(i-1).get(k)+1);
	                //Length of column of 1s
	                cur=holder.get(k);
	                //Update the column 1s streak
	                for (int j=cur;j>=1;j--) {
	                    streak[j]++;
	                }
	                //If the previous column of 1s streak breaks when previous row's length is higher the current ones
	                if (k>0 && holder.get(k-1)>cur){
	                    int prev=holder.get(k-1);
	                    for (int u=prev;u>cur;u--) {
	                    	//Calculate and update area if necessary
	                    	//u is length of column of 1s (height)
	                    	//streaks[u] is columns of 1s in current row (width) 
	                        int area=u*streak[u];
	                        if (area>max) {
	                            max=area;
	                        }
	                        //Reset streak
	                        streak[u]=0;
	                    }
	                }
	            } else {
	            	//If encounter 0 --> Reset all column streaks
	                for (int u=1;u<streak.length;u++) {
	                    if (streak[u]==0) {
	                        continue;
	                    }
	                    int area=u*streak[u];
	                    if (area>max) {
	                        max=area;
	                    }
	                    streak[u]=0;
	                }
	            }
	        }
	        //Check all the remaining streaks
	        for (int k=1;k<streak.length;k++) {
	            if (streak[k]==0) {
	                continue;
	            }
	            int area=k*streak[k];
	            if (area>max) {
	                max=area;
	            }
	        }
	    }
	    return max;
	}
}
