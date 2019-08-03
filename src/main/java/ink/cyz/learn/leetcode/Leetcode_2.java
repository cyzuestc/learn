package ink.cyz.learn.leetcode;


import ink.cyz.learn.leetcode.utils.ListNode;
import ink.cyz.use.spider.Utils;

public class Leetcode_2 {
   public static void main(String[] args) {
      ListNode l1 = Utils.getListNode(new int[]{2,4,3});
      ListNode l2 = Utils.getListNode(new int[]{5,6,4});
      Utils.print(addTwoNumbers(l1,l2));

   }
   public static ListNode addTwoNumbers(ListNode l1,ListNode l2){
      if (l1 == null)return l2;
      if (l2 == null)return l1;

      boolean jinwei = false;
      ListNode dummy = new ListNode(-1);
      ListNode pre = dummy;
      while (l1 != null || l2 != null){
         int sum = (l1!=null?l1.val:0) + (l2!=null?l2.val:0) + (jinwei?1:0);
         if (sum>9)jinwei = true;
         else jinwei = false;
         ListNode next = new ListNode(sum%10);
         pre.next = next;
         pre = pre.next;
         if (l1 != null)l1 = l1.next;
         if (l2 != null)l2 = l2.next;
      }
      if (jinwei){
         pre.next = new ListNode(1);
      }
      return dummy.next;
   }
}
