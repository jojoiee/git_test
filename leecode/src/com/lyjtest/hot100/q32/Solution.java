package com.lyjtest.hot100.q32;

import org.junit.Test;

import java.util.Stack;

/**
 * @author NoobProgrammer
 * @title: Solution
 * @projectName leecode
 * @description: TODO
 * @date 2022/1/1719:09
 */

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.longestValidParentheses(")()())");
    }

    public int longestValidParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        //从前往后入栈括号
        for (int i = 0; i < s.length(); i++) {
            stack.push(s.charAt(i));
        }
        int result = 0;
        int rightNum = 0;
        while (!stack.isEmpty()) {
            char c = stack.pop();
            if (c == '(') {
                if (rightNum == 0) {
                    continue;
                } else {
                    result++;
                    rightNum--;
                }
            }
            if (c == ')') {
                //
                char top = stack.peek();
                rightNum++;
                while (!stack.isEmpty() && top == ')') {
                    stack.pop();
                    rightNum++;
                }
            }

        }
        return result;

    }
}
