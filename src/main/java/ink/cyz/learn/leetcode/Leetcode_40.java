package ink.cyz.learn.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode_40 {
    @Test
    public void t(){
        int[] c = {1,1,2,5,6,7,10};
        System.out.println(combinationSum2(c,8));
    }
    List<List<Integer>> res = new ArrayList<>();
    int[] c ;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        c = candidates;
        List<Integer> list = new ArrayList<>();
        help(target,0,list);
        return res;
    }

    public void help(int target,int index,List<Integer> list){
        if (target == 0){
            res.add(new ArrayList<>(list));
            return;
        }
        if (index >= c.length || target < c[index])return;

        int duplicate = 1;
        for (int i = index; i < c.length; i++) {
            if (i+1 >= c.length || c[i+1] != c[i]){
                break;
            }
            duplicate++;
        }

        for (int i = 0; i < duplicate+1; i++) {
            for (int j = 0; j < i; j++) {
                list.add(c[index]);
            }
            help(target-c[index]*i,index+duplicate,list);
            for (int j = 0; j < i; j++) {
                list.remove(list.size()-1);
            }
        }
    }
}
