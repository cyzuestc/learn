package ink.cyz.learn.test;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @ Author      : Zink
 * @ Date        : Created in 18:12 2019/10/7
 * @ Description :
 * @ Version     : 1.0
 **/
public class Main {
    @Test
    public void t(){
        int[][] turns1 = {{10},{10},{10},{10},{10},{10},{10},{10},{10},{10},{10},{10}};
        Assert.assertEquals(300,calculate(turns1));
        int[][] turns2 = {{10},{10},{10},{10},{10},{10},{10},{10},{10},{10},{3,7}};
        Assert.assertEquals(283,calculate(turns2));
        int[][] turns3 = {{5,5},{5,5},{5,5},{5,5},{5,5},{5,5},{5,5},{5,5},{5,5},{5,5},{5}};
        Assert.assertEquals(150,calculate(turns3));
        int[][] turns4 = {{10},{10},{10},{10},{10},{10},{10},{10},{10},{1,9},{10}};
        Assert.assertEquals(271,calculate(turns4));
        int[][] turns5 = {{10},{10},{10},{10},{10},{10},{10},{10},{10},{10},{3,8}};
        Assert.assertEquals(-1,calculate(turns5));
        int[][] turns6 = {{11,-1},{-1,-4}};
        Assert.assertEquals(-1,calculate(turns6));
    }
    int calculate(int[][] turns){
        int res = 0;
        int head10 = 0;
        List<Integer> t = new ArrayList<>();
        //至少10轮
        if(turns.length<10){
            System.out.println("至少10轮");
            return -1;
        }
        //转换为一维,得10分时直接将下次,下下次的分相加
        for (int i = 0; i <turns.length ; i++) {
            int[] turn = turns[i];
            t.add(turn[0]);
            if (turn.length>1){
                if (turn[1]+turn[0] > 10)return -1;
                t.add(turn[1]);
            }

            if (i<10)head10 += turn.length;
        }
        //是否为第一次击球
        boolean first = true;
        for (int i = 0; i < head10; i++) {
            if (t.get(i) <0||t.get(i)>10){
                System.out.println("分值错误,应该位于0~10");
                return -1;
            }
            if (first){
                //第一次全中
                if (t.get(i) == 10){
                    res += 10;
                    //越界判断
                    if (i+2>=t.size()){
                        System.out.println("击球数不足");
                        return -1;
                    }
                    res += t.get(i+1);
                    res += t.get(i+2);
                }else {
                    first = false;
                    res += t.get(i);
                }
                //第二次击球
            }else {
                //补中
                if (t.get(i)+t.get(i-1)==10){
                    res += t.get(i);
                    if (i+1 >= t.size())return -1;
                    res += t.get(i+1);
                //没补中
                }else if (t.get(i)+t.get(i-1)<10){
                    res += t.get(i);
                //两次击球数>10
                }else {
                    System.out.println("击球数>10");
                    return -1;
                }
                first = true;
            }
        }

        return res;
    }
}
