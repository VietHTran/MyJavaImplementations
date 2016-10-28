package SegmentTree;

//Note about segment tree:
//- Useful if mostly used for works with wide set of interval (query) O(logn) time complexity
//- Not very useful when mainly used for update O(logn) time complexity
//- Trade space for time improvement
public class SegmentTree {
	//l(left interval), r(right interval), m(middle index), val(value of Node)
	int l,r,m,val;
	//2 Child of Node
	SegmentTree left,right;
	public SegmentTree(int l, int r, int val) {
		this.l=l;
		this.r=r;
		m=(l+r)/2;
		this.val=val;
		left=null;
		right=null;
	}
	//change the value of a specific element in the original list by val
	public void addition(int i,int val) {
		this.val+=val;
		//this is leaf
		if (l==r) {
			return;
		} 
		//the index is in the lower half 
		else if (m>=i) {
			left.addition(i, val);
		}
		//the index is in the higher half
		else {
			right.addition(i, val);
		}
	}
	//find specific element in the original list the contains a specific value
	public int findIndex(int val) {
		//Found the correct index in the original list
		if (this.val==val && l==r) {
			return r;
		}
		//Go left if the current value is larger than the search value
		//Go right and search for search value-current value if current value is smaller
		if (left!=null && left.val>=val) {
			return left.findIndex(val);
		} else {
			if (right!=null) {
				return right.findIndex(val-left.val);
			} else {
				return -1;
			}
		}
	}
}
