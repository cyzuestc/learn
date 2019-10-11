package ink.cyz.learn.leetcode;

import ink.cyz.learn.leetcode.utils.ListNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Leetcode_95 {
    @Test
    public void t(){
        System.out.println(generateTrees(3));
    }
    public List<TreeNode> generateTrees(int n) {
        if (n == 0)return new ArrayList<TreeNode>();
        List<TreeNode>[] dp = new List[n+1];
        TreeNode node = new TreeNode(1);
        List<TreeNode> list = new ArrayList<>();
        list.add(node);
        dp[0] = new ArrayList<TreeNode>();
        dp[1] = list;



        for (int i = 2; i <=n ; i++) {
            List<TreeNode> l = new ArrayList<>();
            dp[i] = l;
            for (int j = 1; j < i; j++) {
                addList(l,dp[j],dp[i-j-1],i,j);
            }
            addList2(l,dp[i-1],i);
        }
        return dp[n];
    }

    private void addList2(List<TreeNode> l, List<TreeNode> treeNodes, int i) {
        for (int j = 0; j < treeNodes.size(); j++) {
            TreeNode node = new TreeNode(i);
            node.left = copy(treeNodes.get(j),0);
            l.add(node);
        }
    }

    private TreeNode copy(TreeNode treeNode,int x) {
        if (treeNode == null)return null;
        TreeNode t = new TreeNode(treeNode.val+x);
        t.left = copy(treeNode.left,x);
        t.right = copy(treeNode.right,x);
        return t;

    }

    private void addList(List<TreeNode> l, List<TreeNode> up, List<TreeNode> down,int i,int j) {
        for (TreeNode t : up){
            for (TreeNode d : down){
                TreeNode node = new TreeNode(i);
                TreeNode thisNode = copy(t,0);
                TreeNode upBiggest = getBiggestNode(thisNode);
                upBiggest.right = node;
                node.left = copy(d,j+1);
                l.add(thisNode);
            }
            if (down.size() == 0){
                TreeNode node = new TreeNode(i);
                TreeNode thisNode = copy(t,0);
                TreeNode upBiggest = getBiggestNode(thisNode);
                upBiggest.right = node;
                l.add(thisNode);
            }
        }
    }

    private TreeNode getBiggestNode(TreeNode up) {
        if (up.right!= null)return getBiggestNode(up.right);
        else return up;
    }
}
