package ink.cyz.learn.leetcode;

import java.util.TreeSet;

/**
 * @ Author      : Zink
 * @ Date        : Created in 9:39 2019/8/24
 * @ Description :
 * @ Version     : 1.0
 **/
public class Leetcode_220 {

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Integer> treeSet = new TreeSet();
        for (int i = 0; i < nums.length; i++) {
            int curNum = nums[i];
            Integer celling = treeSet.ceiling(curNum);
            if (celling != null && celling-curNum<=t)return true;
            Integer floor = treeSet.floor(curNum);
            if (floor != null && curNum - floor<=t)return true;
            treeSet.add(curNum);

            if (treeSet.size() > k){
                treeSet.remove(nums[i-k]);
            }
        }

        return false;
    }
}
