package ink.cyz.learn.leetcode;

import java.util.Stack;

public class Leetcode_1161 {
    public int maxLevelSum(TreeNode root) {
        int max = root.val;
        int maxIndex = 1;
        Stack<TreeNode> up = new Stack<>();
        Stack<TreeNode> down = new Stack<>();
        up.push(root);
        int curLevel = 1;
        int curSum = 0;
        while (!up.empty()){
            while (!up.empty()){
                TreeNode node = up.pop();
                curSum += node.val;
                if (node.left!=null)down.push(node.left);
                if (node.right!=null)down.push(node.right);
            }
            if (curSum>max){
                max = curSum;
                maxIndex = curLevel;
            }
            curLevel++;
            curSum = 0;
            Stack<TreeNode> temp = new Stack<>();
            temp = up;
            up = down;
            down = temp;
        }
        return maxIndex;
    }
}
