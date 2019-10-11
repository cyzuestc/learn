package ink.cyz.learn.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @ Author      : Zink
 * @ Date        : Created in 23:28 2019/8/23
 * @ Description :
 * @ Version     : 1.0
 **/
public class leetcode_219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set set = new HashSet(k+1);
        for (int i = 0; i < k+1 && i<nums.length; i++) {
            if (set.contains(nums[i]))return true;
            set.add(nums[i]);
        }
        for (int i = k+1; i < nums.length; i++) {
            set.remove(nums[i-k-1]);
            if (set.contains(nums[i]))return true;
            set.add(nums[i]);
        }
        return false;
    }
}
