package ink.cyz.learn.leetcode;

import ink.cyz.learn.leetcode.utils.ListNode;

public class Leetcode_19 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = dummy.next;
        //链表的长度
        int len = 0;
        while (cur!= null){
            len++;
            cur = cur.next;
        }
        cur = dummy;
        for (int i = 0; i < len-n; i++) {
            cur = cur.next;
        }
        if (cur.next != null)
        cur.next = cur.next.next;
        return dummy.next;
    }
}
