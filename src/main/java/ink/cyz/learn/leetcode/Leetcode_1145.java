package ink.cyz.learn.leetcode;

import org.junit.Test;

public class Leetcode_1145 {
    @Test
    public void t(){

    }
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        TreeNode xNode = getNode(root,x);
        int left = count(xNode.left);
        int right = count(xNode.right);
        int up = n-left-right-1;
         if (left>n/2||right>n/2||up>n/2)return true;
        return false;
    }

    private int count(TreeNode n) {
        if (n==null)return 0;
        return 1+count(n.left)+count(n.right);
    }

    private TreeNode getNode(TreeNode root, int x) {
        if (root == null)return null;
        if (x == root.val)return root;
        TreeNode x2 = getNode(root.left,x);
        if (x2 == null)return getNode(root.right,x);
        return x2;
    }

}
