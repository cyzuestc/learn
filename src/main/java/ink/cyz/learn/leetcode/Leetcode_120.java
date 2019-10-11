package ink.cyz.learn.leetcode;

import java.util.List;

public class Leetcode_120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < triangle.size(); i++) {
            List<Integer> upList = triangle.get(i-1);
            List<Integer> curList = triangle.get(i);
            for (int j = 0; j < curList.size(); j++) {
                int cur = curList.get(j);
                int upleft = j==0?Integer.MAX_VALUE:upList.get(j-1);
                int upRight = j == curList.size()-1?Integer.MAX_VALUE:upList.get(j);
                curList.set(j,Math.min(upleft,upRight)+cur);
            }
        }
        for (int i = 0; i < triangle.get(triangle.size()-1).size(); i++) {
            min = Math.min(min,triangle.get(triangle.size()-1).get(i));
        }
        return min;
    }
}
