package ink.cyz.learn.leetcode;

import java.util.Stack;

/**
 * @ Author      : Zink
 * @ Date        : Created in 21:47 2019/8/25
 * @ Description :
 * @ Version     : 1.0
 **/
public class Leetcode_150 {

    public int evalRPN(String[] tokens) {
        if (tokens.length == 0)return 0;
        Stack<Integer> stack = new Stack<>();
        for (String s : tokens){
            switch (s){
                case "+":
                    stack.push(stack.pop()+stack.pop());
                case "-":
                    stack.push(-stack.pop()+stack.pop());
                case "*":
                    stack.push(stack.pop()*stack.pop());
                case "/":
                    int a = stack.pop();
                    stack.push(stack.pop()/a);
                default:
                    stack.push(Integer.valueOf(s));
            }
        }
        return stack.pop();
    }
}
