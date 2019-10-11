package ink.cyz.learn.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @ Author      : Zink
 * @ Date        : Created in 16:38 2019/8/25
 * @ Description :
 * @ Version     : 1.0
 **/
public class Leetcode_230 {
    int K;
    int index = 0;
    int res;
    public int kthSmallest(TreeNode root, int k) {
        this.K = k;
        getKth(root);
        return this.res;
    }
    public void getKth(TreeNode root){
        if (root == null)return ;
         getKth(root.left);
         this.index++;
         if (this.index == this.K){
             res = root.val;
             return;
         }
        getKth(root.right);
    }
}
