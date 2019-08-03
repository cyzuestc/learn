package ink.cyz.learn.leetcode;

import java.util.*;

public class Leetcode_47 {
    public static void main(String[] args) {
        Leetcode_47 t = new Leetcode_47();
        System.out.println(t.permuteUnique(new int[]{1,2,3}));
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        Set[] set = new HashSet[nums.length];
        List<List<Integer>> res = new ArrayList<>();
        int[] visited = new int[nums.length];
        ArrayList<Integer> tmp = new ArrayList<>();
        backtrack(res,visited,tmp,nums);
        return res;
    }

    private void backtrack(List<List<Integer>> res, int[] visited, ArrayList<Integer> tmp, int[] nums) {
        if (nums.length == tmp.size()){
            res.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i] == 1 ||  (i>0 && visited[i-1] == 1 && nums[i] == nums[i-1]))continue;
            visited[i] = 1;
            tmp.add(nums[i]);
            backtrack(res,visited,tmp,nums);
            visited[i] = 0;
            tmp.remove(tmp.size()-1);
        }
    }
}
