package ink.cyz.learn.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode_39 {

    @Test
    public void t(){
        int[] c= {2,3,6,7};
        long t1 = System.currentTimeMillis();
        System.out.println(combinationSum(c,7));
        long t2 = System.currentTimeMillis();
        System.out.println(t2-t1);
    }

    List<List<Integer>> res = new ArrayList<>();
    int[] c ;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
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


        for (int i = 0; i < target/c[index]+1; i++) {
            for (int j = 0; j < i; j++) {
                list.add(c[index]);
            }
            help(target-c[index]*i,index+1,list);
            for (int j = 0; j < i; j++) {
                list.remove(list.size()-1);
            }
        }
    }

}
