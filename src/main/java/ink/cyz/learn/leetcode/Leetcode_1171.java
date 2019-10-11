package ink.cyz.learn.leetcode;

import ink.cyz.learn.leetcode.utils.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode_1171 {
     public ListNode removeZeroSumSublists(ListNode head) {
         ListNode cur = head;
         List<Integer> list = new ArrayList<>();
         List<Integer> remove = new ArrayList<>();
         while (cur!= null){
             list.add(cur.val);
         }

        return cur;
    }
}
