package ink.cyz.learn.leetcode;

import ink.cyz.use.spider.Utils;
import org.junit.Test;

public class Leetcode_374 {
    @Test
    public void t(){
        System.out.println(guessNumber(2126753390));
    }

    public int guessNumber(int n) {
        int l = 1;
        int r = n;
        while(l<r){

            int i = (l>>1)+(r>>1)+(l%2==1&&r%2==1?1:0);
            int res = guess(i);
            if(res == 0)return i;
            if(res == -1)r = i-1;
            if(res == 1)l = i+1;
        }
        return l;
    }

    private int guess(int i) {
        if (i==1702766719)return 0;
        if (i>1702766719)return -1;
        return 1;
    }

}
