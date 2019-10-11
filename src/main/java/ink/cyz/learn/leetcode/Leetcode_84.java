package ink.cyz.learn.leetcode;

import org.junit.Test;

import java.util.Stack;

/**
 * @ Author      : Zink
 * @ Date        : Created in 16:19 2019/8/24
 * @ Description :
 * @ Version     : 1.0
 **/
public class Leetcode_84 {

    @Test
    public void t(){
        int[] a = {5,4,1,2};
        largestRectangleArea(a);
    }
    public int help(int[] heights,int i,int j){
        if (heights.length <1)return 0;
        if (i == j)return heights[i];
        boolean sorted = true;
        int minIndex = i;
        for (int k = i+1; k <= j; k++) {
            if (sorted && heights[k] < heights[k-1]){
                sorted = false;
            }
            minIndex = heights[k] < heights[minIndex]?k:minIndex;
        }
        int l = help(heights,i,minIndex-1);
        int r = help(heights,minIndex+1,j);
        return Math.max(Math.max(l,r),heights[minIndex]*(j-i+1));
    }
    public int largestRectangleArea(int[] heights) {
        int max = 0;
        Stack<Integer> stack = new Stack();
        stack.push(-1);
        for (int i = 0; i < heights.length; i++) {
            if (stack.peek() == -1 || heights[stack.peek()]<= heights[i]){
                stack.push(i);
            }
            else {
                int lastIndex = stack.pop();
                max = Math.max(max,heights[lastIndex]*(i-stack.peek()-1));
                i--;
            }
        }
        int i = heights.length;
        while (stack.peek() != -1){
            int lastIndex = stack.pop();
            max = Math.max(max,heights[lastIndex]*(i-stack.peek()-1));
        }
        System.out.println(max);

        return max;
    }
}
