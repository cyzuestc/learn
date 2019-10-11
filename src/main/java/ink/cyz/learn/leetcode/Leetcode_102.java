package ink.cyz.learn.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Leetcode_102 {
    @Test
    public void t(){

    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        help(res,root,0);
        return res;
    }

    private void help(List<List<Integer>> res, TreeNode root, int i) {
        if (root == null)return;
        if (res.get(i) == null){
            List<Integer> list = new ArrayList<>();
            res.add(list);
        }
        res.get(i).add(root.val);
        help2(res,root.right,i+1);
        help2(res,root.left,i+1);
    }
    private void help2(List<List<Integer>> res, TreeNode root, int i) {
        if (root == null)return;
        if (res.get(i) == null){
            List<Integer> list = new ArrayList<>();
            res.add(list);
        }
        res.get(i).add(root.val);
        help(res,root.left,i+1);
        help(res,root.right,i+1);
    }
}
