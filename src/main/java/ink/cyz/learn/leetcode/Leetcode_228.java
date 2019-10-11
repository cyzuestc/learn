package ink.cyz.learn.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @ Author      : Zink
 * @ Date        : Created in 16:38 2019/8/25
 * @ Description :
 * @ Version     : 1.0
 **/
public class Leetcode_228 {

public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        if (nums.length == 0)return res;
        int left = nums[0];
        int last = nums[0];
        int cur = 0;
    for (int i = 1; i <= nums.length; i++) {
        if (i == nums.length){
            cur = nums[i-1]+2;
        }else
            cur = nums[i];

        if (cur == last+1){
            last = cur;
        }
        else {
            if (left != last){
                res.add(left+"->"+last);
            }else {
                res.add(left+"");
            }
            left = cur;
            last = cur;
        }
    }

    return res;
    }
}
