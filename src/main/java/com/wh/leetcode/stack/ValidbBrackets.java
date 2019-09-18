package com.wh.leetcode.stack;

import sun.tools.attach.HotSpotVirtualMachine;

import java.util.Stack;

/**
 * @Auther: wwh
 * @Date: 2019-09-17 23:45
 * @Description: 检查括号的有效性，因为有效的表达式的子表达式也是有效表达式，所以利用栈这种数据结构来不断剔除有效的括号  只需要最后看栈中是否还有元素即可，
 */
public class ValidbBrackets {
        public boolean isValid(String s) {
            Stack<Character> stack = new Stack<>();
            char[] chars = s.toCharArray();
            for (char aChar : chars) {
                if (stack.size() == 0) {
                    stack.push(aChar);
                } else if (isSame(stack.peek(), aChar)) {
                    stack.pop();
                } else {
                    stack.push(aChar);
                }
            }
            return stack.size() == 0;
        }

        private boolean isSame(char c1, char c2) {
            return (c1 == '(' && c2 == ')') || (c1 == '[' && c2 == ']') || (c1 == '{' && c2 == '}');
        }

    public static void main(String[] args) {
        ValidbBrackets validbBrackets = new ValidbBrackets();
         boolean d =  validbBrackets.isValid("{{}]}");
        System.out.println(d);
    }
    
}
