package ink.cyz.learn.leetcode;

/**
 * @ Author      : Zink
 * @ Date        : Created in 22:27 2019/8/24
 * @ Description :
 * @ Version     : 1.0
 **/
public class Leetcode_224 {

    public int calculate(String s) {
//        s = s.replaceAll(" ","").replaceAll("\\(","").replaceAll("\\)","");

        char[] ch = s.toCharArray();
        int res = 0;
        int cur = 0;
        boolean plus = true;
        for (char c : ch){
            if (c == '+'){
                if (plus)res += cur;
                else res -= cur;
                cur = 0;
                plus = true;
            }else if (c == '-'){
                if (plus)res += cur;
                else res -= cur;
                cur = 0;
                plus = false;
            }else if (c>='0' && c<='9'){
                cur = cur*10+(c-'0');
            }
        }
        return res;
    }
}
