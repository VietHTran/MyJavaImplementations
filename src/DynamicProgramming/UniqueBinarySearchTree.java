package DynamicProgramming;

public class UniqueBinarySearchTree {
	//Problem: Given A, how many structurally unique BST’s (binary search trees) that store values 1...A?
	//Example: A=3 => Answer: 5 unique BTS
//	1		1			3		3		2
//   \		 \		   /	   /	   / \
//	  3		  2		  1		  2		  1	  3
//	 /		   \	   \	 /
//	2			3		2	1
	public int numTrees(int a) {
	    if (a==0) return 0;
	    if (a==1) return 1;
	    if (a==2) return 2;
	    //Contain number of combinations possible from 1..A
	    int[] p= new int[a];
	    p[1]=2;
	    p[0]=1;
	    for (int i=2;i<a;i++) {
	        //it is always possible to stick all solutions of 1..(x-1) to the left of x
	        p[i]=p[i-1];
	        //Try to put all values from 1..(x-1) as head
	        for (int j=0;j<i;j++) {
	            //System.out.println("up: "+(a-j-1)+" "+(j-1));
	            //System.out.println("do: "+p[a-j-1]+" "+(j==0?1:p[j-1]));
	        	//Check if the left side of head is empty (only possible when 1(0 in zero-based) is head)
	            if (j!=0) {
	            	//all combination if j is head=all combinations of left side (<j) * all combinations of right side (>j)
	                p[i]+=(p[i-j-1]*p[j-1]);
	            } else {
	            	//all combination if j is head=all combinations of right side
	                p[i]+=p[i-j-1];
	            }
	        }
	    }
	    return p[a-1];
	}
}
