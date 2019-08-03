package ink.cyz.learn.leetcode;

import java.util.Stack;

public class Leetcode_20 {

    public static void main(String[] args) {
        String s = ")";
        System.out.println(isValid(s));
    }
    public static boolean isValid(String s) {
        if (s.isEmpty()||s.trim().isEmpty())return true;
        Stack<Character> stack = new Stack();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (isLeft(c)){
                stack.push(c);
            }else {
                if (stack.isEmpty())return false;
                char top = stack.peek();
                switch (c){
                   case ')':
                       if (top == '('){
                           stack.pop();
                           break;
                       }else {
                           return false;
                       }
                   case ']':
                       if (top == '['){
                           stack.pop();
                           break;
                       }else {
                           return false;
                       }
                    case '}':
                        if (top == '{'){
                            stack.pop();
                            break;
                        }else {
                            return false;
                        }
                }
            }
        }
        return stack.isEmpty();
    }
    public static boolean isLeft(char c){
        if (c == '('|| c == '[' || c == '{')return true;
        return false;
    }
}
