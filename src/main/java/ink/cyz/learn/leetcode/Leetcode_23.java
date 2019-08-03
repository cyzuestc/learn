package ink.cyz.learn.leetcode;

import ink.cyz.learn.leetcode.utils.ListNode;
import ink.cyz.use.spider.Utils;

public class Leetcode_23 {
    public static void main(String[] args) {

       ListNode l1 = Utils.getListNode(new int[]{1,4,5});
        ListNode l2 = Utils.getListNode(new int[]{1,2,3});

        ListNode l3 = Utils.getListNode(new int[]{2,6});
       ListNode[] lists = new ListNode[]{l1,l2,l3};
        Utils.print(mergeKLists(lists));
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0)return null;
        while (lists.length >1){
            ListNode[] temp = new ListNode[(lists.length+1)/2];
            for (int i = 0; i < lists.length; i+=2) {
                if (i+1<lists.length)
                    temp[i/2] = mergeTwoLists(lists[i],lists[i+1]);
                else
                    temp[i/2] = lists[i];
            }
            lists = temp;

        }
        return lists[0];
    }
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode pre = dummy;
        while (l1 != null && l2 != null){
            if (l1.val>=l2.val){
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
