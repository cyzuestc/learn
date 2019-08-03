package ink.cyz.learn.leetcode;

import ink.cyz.learn.leetcode.utils.ListNode;

public class Leetcode_24 {

    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = dummy;
        swapPairsOnce(cur);
        return dummy.next;
    }

    public ListNode swapPairsOnce(ListNode preNode) {
        if (preNode.next != null && preNode.next.next != null){
            //preNode>first>second>nextFirst
            ListNode firstNode = preNode.next;
            ListNode secondNode = firstNode.next;
            ListNode nextFirstNode = secondNode.next;

            preNode.next = secondNode;
            secondNode.next = firstNode;
            firstNode.next = nextFirstNode;
            return swapPairsOnce(firstNode);
        }
        return preNode;
    }
}
