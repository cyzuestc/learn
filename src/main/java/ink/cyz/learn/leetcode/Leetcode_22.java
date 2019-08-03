package ink.cyz.learn.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode_22 {
    public static void main(String[] args) {
        System.out.println(generateParenthesis(5));
    }
    public static List<String> generateParenthesis(int n) {
        List list = new ArrayList();
       generateParenthesis(n,0,0,list,"");
       return list;
    }

    private static void generateParenthesis(int n, int x, int y, List list, String s) {
        if (x == n && y == n){
            list.add(s);
        }
        else if (x == n && y < n){
            generateParenthesis(n,x,y+1,list,s+")");
        }
        else if (x < n && x == y){
           generateParenthesis(n,x+1,y,list,s+"(");
        }
        else if (x < n && x > y ){
            generateParenthesis(n,x+1,y,list,s+"(");
            generateParenthesis(n,x,y+1,list,s+")");
        }
    }
}

