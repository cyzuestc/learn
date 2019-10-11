package ink.cyz.learn.leetcode;

import java.util.Stack;

/**
 * @ Author      : Zink
 * @ Date        : Created in 17:06 2019/8/25
 * @ Description :
 * @ Version     : 1.0
 **/
public class TreeNode {

      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }

      @Override
      public String toString() {
            return print();
      }

      String print(){
            Stack<TreeNode> up = new Stack<>();
            Stack<TreeNode> down = new Stack<>();
            up.push(this);
            StringBuilder sb = new StringBuilder();
            while (!up.empty()){
                  while (!up.isEmpty()) {
                        TreeNode node = up.pop();
                        if (node != null) {
                              sb.append(node.val + " ");

                              down.push(node.left);
                              down.push(node.right);
                        } else {
                              sb.append("null" + " ");
                        }
                  }
                  Stack<TreeNode> temp = new Stack();
                  temp = up;
                  up = down;
                  down = temp;
            }
            return sb.toString();
      }
}
