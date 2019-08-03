package ink.cyz.learn.leetcode;

import ink.cyz.learn.leetcode.utils.ListNode;
import ink.cyz.use.spider.Utils;

public class Leetcode_25 {
    public static void main(String[] args) {
        ListNode node = Utils.getListNode(new int[]{1,2,3,4,5});
        Leetcode_25 t = new Leetcode_25();

        Utils.print(t.reverseKGroup(node,2));
    }

    public ListNode reverseKGroup(ListNode head,int k) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = dummy;
        swapPairsKth(cur,k);
        return dummy.next;
    }

    public ListNode swapPairsKth(ListNode preNode,int k) {
        if (preNode == null)return null;
        ListNode preNodeShadow = preNode;
        //验证是否能交换
        for (int i = 0; i < k; i++) {
            if (preNodeShadow.next == null)return preNode;
            preNodeShadow = preNodeShadow.next;
        }
        //      cur             curNext
        //pre>  1>              2>3>4>nextFirst
        //pre>  2>1             3>4>nextFirst
        //pre>  3>2>1           4>nextFirst
        //pre   4>3>2>1         nextFirst>null
        ListNode cur = preNode.next;
        ListNode first = cur;
        ListNode curNext = cur.next;
        for (int i = 1; i < k; i++) {
            Utils.print(cur);
            ListNode newHead = curNext.next;
            curNext.next = cur;
            cur =curNext;
            curNext = newHead;
        }
        first.next = curNext;
        preNode.next = cur;
        return swapPairsKth(first,k);
    }
}
