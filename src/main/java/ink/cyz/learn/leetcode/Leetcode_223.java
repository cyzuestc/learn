package ink.cyz.learn.leetcode;

/**
 * @ Author      : Zink
 * @ Date        : Created in 22:05 2019/8/24
 * @ Description :
 * @ Version     : 1.0
 **/
public class Leetcode_223 {

    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int width1 = C-A;
        int height1 = D-B;
        int width2 = G-E;
        int height2 = H-F;

        int widthAll = Math.max(C,G)-Math.min(A,E);
        int heightAll = Math.min(D,H)-Math.min(B,F);

        int w = width1+width2-widthAll;
        int h = height1+height2-heightAll;
        System.out.println(w+" "+h);
        return w>0&&h>0?w*h:0;
    }
}
