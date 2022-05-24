package com.lyjtest.codeThink.stringTest;

/**
 * @author NoobProgrammer
 * @title: Solution
 * @projectName leecode
 * @description: TODO
 * @date 2021/12/2715:53
 */

public class Solution {

    public static void main(String[] args) {
        String s= "the sky is blue";
        Solution solution = new Solution();
        String s1 = solution.reverseWords(s);
        System.out.println(s1);
    }

    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder(s);
        removeSpace(sb);
        //将字符串整体反转
        reverseString(sb, 0, sb.length() - 1);
        //每个单词的开始和结束位置
        int start = 0;
        int end = 0;
        //标记是否进入单词的区间
        //1. 如果当前位置是空格，置为true;
        //2. 下一次循环就进入单词区间(只有一个空格)
        //3.如果本次循环entry为true
        boolean entry = false;

        //将每个单词分别翻转
        for (int i = 0; i < s.length() - 1; i++) {
            if (!entry) {
                start = i;
                entry = true;
            }
            //如果在单词区间内，并且i指向空格，并且它的前一个字符不是空格
            //找到了一个单词，将其反转，并置entry为false
            if (entry && s.charAt(i) == ' ' && s.charAt(i - 1) != ' ') {
                end = i - 1;
                reverseString(sb, start, end);
                entry = false;
            }
            //翻转最后一个结尾不是空格的单词
            if (entry && (i == s.length() - 1) && s.charAt(i) != ' ') {
                end = i;
                reverseString(sb, start, end);
                entry = false;
            }

        }
        return sb.toString();
    }

    //将给定字符串反转的方法
    private void reverseString(StringBuilder sb, int left, int right) {

        while (left < right) {
            char temp = sb.charAt(left);
            sb.setCharAt(left,sb.charAt(right));
            sb.setCharAt(right,temp);
            left++;
            right--;
        }

    }


    private void removeSpace(StringBuilder sb) {
        //去除字符串开头的空格
        int fastIndex = 0;
        int slowIndex = 0;
        int length = sb.length();
        //让快指针指向字符串的第一个非空格字符
        while (length > 0 && sb.charAt(fastIndex) == ' ') {
            fastIndex++;
        }

        //如果fast指针遇到空格连续空格，删除多余的空格
        //即fast指针继续向前，slow指针不动
        while (fastIndex < length) {
            //如果快指针指向的字符及其上一个是空格，slow不动 fast++
            if (fastIndex - 1 > 0 && sb.charAt(fastIndex - 1)== sb.charAt(fastIndex) && sb.charAt(fastIndex) == ' ') {
                fastIndex++;
            } else {
                sb.setCharAt(slowIndex,sb.charAt(fastIndex));
                slowIndex++;
                fastIndex++;
            }
        }
        //去除末尾的空格
        if (slowIndex < length - 1 && sb.charAt(slowIndex - 1) == ' ') {

            sb.delete(slowIndex,length);
//            return sb.substring(0,slowIndex - 1);
//            return res.subString(0, slowIndex - 1);
        }

    }
}
