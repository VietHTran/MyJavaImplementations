package SegmentTree;
import java.util.*;

public class SegmentTreeSolution {
	//Test if Tree is generated correctly
	//<left> <parent> <right>
	private static void testTree(SegmentTree node) {
		if (node.left!=null) {
			testTree(node.left);
		}
		System.out.print(node.val+" ");
		if (node.right!=null) {
			testTree(node.right);
		}
	}
	//This is used for OrderByPeopleHeights problem
	public static SegmentTree generateTree(int l, int r) {
		SegmentTree node= new SegmentTree(l,r,(r-l+1));
		//Stop when there is only 1 element in the segment
		if (l!=r) {
			int mid=(l+r)>>1;
			node.left=generateTree(l,mid);
			node.right=generateTree(mid+1,r);
		}
		return node;
	}
	//Given a list of heights of each person and a list of number of people taller than that person
	//Return actual order of persons’s height
	public static ArrayList<Integer> OrderByPeopleHeights(
			ArrayList<Integer> heights, 
			ArrayList<Integer> infronts) {
		ArrayList<Integer> result= new ArrayList<Integer>(heights);
		//map the heights with the infronts value in order to trace infronts value after sorting heights
		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
		if (heights==null || heights.size()==0) {
			return result;
		}
		int length=heights.size();
		for (int i=0;i<length;i++) {
		    map.put(heights.get(i),infronts.get(i));
		}
		//Storing the number of empty slot between intervals
		SegmentTree root=generateTree(0,length-1);
		//Sort the list according to heights
		Collections.sort(heights);
		for (int i=0;i<length;i++) {
			int u=map.get(heights.get(i));
			//find the x where from 0 to x the number of empty slot in front of is u (+1 including itself)
			int ind=root.findIndex(u+1);
			//reduce the number of empty slots
			root.addition(ind, -1);
			//fix the result list based on the position found
			result.set(ind,heights.get(i));
		}
		return result;
	}
}
