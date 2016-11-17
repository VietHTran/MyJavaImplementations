package Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class InorderPreorderConstruction {
	//Given preorder and inorder traversal of a tree, construct the binary tree.
	//You may assume that duplicates do not exist in the tree.
	// Example: 
	//Preorder : [1, 2, 3]
    //Inorder  : [2, 1, 3]
	//Result:
	//	1
	// / \
	//2   3
	public Tree construction (ArrayList<Integer> preorder, ArrayList<Integer> inorder) {
		if (preorder==null || preorder.size()==0) {
	        return null;
	    }
	    HashMap<Integer,Integer> map= new HashMap<Integer,Integer>();
	    Stack<Tree> cur= new  Stack<Tree>();
	    Stack<Integer> lim= new Stack<Integer>();
	    int length=inorder.size();
	    for (int i=0;i<length;i++) {
	        int u=inorder.get(i);
	        map.put(u,i);
	    }
	    Tree head=new Tree(preorder.get(0));
	    cur.push(head);
	    lim.push(length-1);
	    for (int i=1;i<length;i++) {
	        Tree u=cur.peek();
	        int v=preorder.get(i);
	        int vv=map.get(v);
	        int l=lim.peek();
	        Tree ln= new Tree(v);
	        //System.out.println(u.val+" "+ln.val+" "+l);
	        while (vv>l) {
	            cur.pop();
	            lim.pop();
	            u=cur.peek();
	            l=lim.peek();
	            //System.out.println(u.val+" "+ln.val+" "+l);
	        }
	        int uv=map.get(u.val);
	        if (uv>vv) {
	            u.left=ln;
	            lim.push(uv);
	        } else {
	            u.right=ln;
	            lim.push(l);
	        }
	        cur.push(ln);
	        //System.out.println(u.val+" "+ln.val+"  "+uv+" "+vv+" "+v);
	    }
	    return head;
	}
}
