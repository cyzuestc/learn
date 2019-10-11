package ink.cyz.learn.leetcode;

public class Leetcode_42 {
    public int trap(int[] height) {
        int max = 0;
        int maxIndex = -1;
        for (int i = 0; i < height.length; i++) {
            if (height[i] > max){
                max = height[i];
                maxIndex = i;
            }
        }

        int res = 0;
        int curMax = 0;
        for (int i = 0; i < maxIndex; i++) {
            if (curMax > height[i])res+= curMax-height[i];
            else curMax = height[i];
        }
        curMax = 0;
        for (int i = height.length-1; i > maxIndex; i--) {
            if (curMax > height[i])res+= curMax-height[i];
            else curMax = height[i];
        }
        return res;
    }
}
