package ink.cyz.learn.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @ Author      : Zink
 * @ Date        : Created in 19:31 2019/8/22
 * @ Description :
 * @ Version     : 1.0
 **/
public class Leetcode_216 {
    @Test
    public void t(){
        System.out.println(combinationSum3(5,9));
    }
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        ArrayList list = new ArrayList();
        combinationSum3(k,n,1,list);
        return res;
    }

    private void combinationSum3(int k, int n, int i, ArrayList list) {
        System.out.println(list);
        if (n ==0 && k == 0)res.add(new ArrayList<>(list));
        if (n <= 0 || k <= 0)return;

        for (int j = i; j <= 9-k+1; j++) {
            list.add(j);
            combinationSum3(k-1,n-j,j+1,list);
            list.remove(list.size()-1);
        }
    }
}
