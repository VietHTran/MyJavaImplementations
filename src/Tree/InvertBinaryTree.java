package Tree;

public class InvertBinaryTree {
	//Given a binary tree, invert the binary tree and return it. 
	//This is what you do when you don't program Homebrew
	
	public void traverse(Tree cur) {
        if (cur==null) {
            return;
        }
        Tree tmp=cur.left;
        cur.left=cur.right;
        cur.right=tmp;
        traverse(cur.left);
        traverse(cur.right);
    }
    public Tree invertTree(Tree root) {
        if (root==null) {
            return null;
        }
        if (root.left==null && root.right==null) {
            return root;
        }
        traverse(root);
        return root;
    }
}
