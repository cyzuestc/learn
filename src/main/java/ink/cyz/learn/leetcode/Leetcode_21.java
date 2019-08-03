package ink.cyz.learn.leetcode;

import ink.cyz.learn.leetcode.utils.ListNode;

public class Leetcode_21 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode pre = dummy;
        while (l1 != null && l2 != null){
            if (l1.val>l2.val){
                pre.next = l2;
                l2 = l2.next;
                pre = pre.next;
            }else {
                pre.next = l1;
                l1 = l1.next;
                pre = pre.next;
            }
        }
        if (l1 == null){
            pre.next = l2;
        }
        if (l2 == null){
            pre.next = l1;
        }
        return dummy.next;
    }
}
