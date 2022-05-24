package com.lyjtest.hot100.question20;

import java.util.Stack;

/**
 * @author NoobProgrammer
 * @title: IsValid
 * @projectName leecode
 * @description: 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * @date 2021/12/516:19
 */
public class IsValid {
    public static void main(String[] args) {
        String s = "]";
        Solution solution = new Solution();
        boolean valid = solution.isValid(s);
        System.out.println(valid);
    }
}

class Solution {
    public boolean isValid(String s) {

        //创建一个栈存放符号，遇到左括号"( [ {"入栈，遇到右括号") ] }"，出栈，
        // 看出栈的这个是不是与之相匹配的括号
        // 如果是，匹配下一个，如果不是返回false
        Stack<Character> brackets = new Stack<>();
        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == '(' || charArray[i] == '[' || charArray[i] == '{') {
                brackets.push(charArray[i]);
            } else {
                //匹配到右括号：
                //如果当前brackets为空 返回false；
                if (brackets.size() == 0) {
                    return false;
                }
                //否则出栈一个字符，看他是否与之匹配
                Character pop = brackets.pop();
                if (!(isMatch(pop, charArray[i]))) {
                    return false;
                }
            }
        }
        return brackets.size() == 0;

    }

    //判断左右括号匹配的函数

    /**
     * @param c1 总是出栈的字符 左括号
     * @param c2 此次待比较的字符 右括号
     */
    private boolean isMatch(char c1, char c2) {
        if (c1 == '(' && c2 == ')') {
            return true;
        } else if (c1 == '[' && c2 == ']') {
            return true;
        } else if (c1 == '{' && c2 == '}') {
            return true;
        } else {
            return false;
        }
    }
}
