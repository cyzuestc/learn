package ink.cyz.learn.leetcode;

public class Leetcode_11 {
    public static void main(String[] args) {

    }
    public int maxArea(int[] height) {
        int i = 0;
        int j = height.length-1;
        int maxArea = (j-i)*Math.min(height[i],height[j]);
        while (i<j){
            if (height[i]>height[j]){
                j--;
            }else {
                i++;
            }
            maxArea =Math.max(maxArea, (j-i)*Math.min(height[i],height[j]));
        }
        return maxArea;
    }
}
