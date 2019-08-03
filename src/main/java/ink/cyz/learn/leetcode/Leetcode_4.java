package ink.cyz.learn.leetcode;

public class Leetcode_4 {

    public static void main(String[] args) {
        int[] num2 = {1,2};
        int[] num1 = {3};
        System.out.println(findKth(2,0,num1,0,num2));
    }
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int l1 = nums1.length;
        int l2 = nums2.length;
        int k1 = (l1+l2)/2+1;
        int k2 = (l1+l2-1)/2+1;
        return ((double)findKth(k1,0,nums1,0,nums2)+
                (double)findKth(k2,0,nums1,0,nums2))/2;
    }
    public static int findKth(int k,int start_1,int[] num1,int start_2,int[] num2){
       if (start_1>=num1.length){
           return num2[start_2+k-1];
       }
       if (start_2>=num2.length){
           return num1[start_1+k-1];
       }
       int mid_1 = Integer.MAX_VALUE;
       int mid_2 = Integer.MAX_VALUE;
       if (k == 1)return Math.min(num1[start_1],num2[start_2]);
       if (num1.length>k/2-1+start_1){
           mid_1 = num1[k/2-1+start_1];
       }
       if (num2.length>k/2-1+start_2){
           mid_2 = num2[k/2-1+start_2];
       }
       if (mid_1>mid_2){
           return findKth(k-k/2,start_1,num1,start_2+k/2,num2);
       }else {
           return findKth(k-k/2,start_1+k/2,num1,start_2,num2);
       }
    }
}


