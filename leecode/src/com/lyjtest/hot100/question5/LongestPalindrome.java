package com.lyjtest.hot100.question5;

import java.util.Arrays;

/**
 * @author NoobProgrammer
 * @title: LongestPalindrome
 * @projectName leecode
 * @description: 给你一个字符串 s，找到 s 中最长的回文子串。
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 * @date 2021/12/415:30
 */
public class LongestPalindrome {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "bb";
//        for (boolean[] booleans1 : booleans) {
//            System.out.println(Arrays.toString(booleans1));
//        }
        String s1 = solution.longestPalindromeMid(s);
        System.out.println(s1);
    }
}

class Solution {
    //暴力破解法：
    public String longestPalindromeViolence(String s) {
        //数据校验

        if (s == null || s.length() == 0) {
            return null;
        }

        int len = s.length();
        if (len < 2) {
            return s;
        }
        char[] charArray = s.toCharArray();
        int begin = 0;
        int maxLen = 1;

        //左指针的位置： 从0 到len-1
        for (int i = 0; i < len - 1; i++) {
            //右指针从左指针的下一个位置遍历到数组末尾
            for (int j = i + 1; j < len; j++) {
                //如果是回文子串并且这次的结果更大
                if (isPalindrome(charArray, i, j) && maxLen < j - i + 1) {
                    begin = i;
                    maxLen = j - i + 1;
                }
            }
        }
        return s.substring(begin, begin + maxLen);

    }

    //判断字符数组是不是回文串：
    private boolean isPalindrome(char[] charArray, int left, int right) {
        while (left < right) {
            if (charArray[left] != charArray[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    //动态规划 p[i,j]表示第i开始第j为止，是否构成回文串
    //规律：回文子串之外两个字符相等的话，这个大字串也是回文子串
    // p[i+1,j-1] = true if(char[i] == char[j]) -> p[i,j] = true;
    //边界条件 p[i,j] = true; i= j的情况
    //p[i,i+1] = true ; i与i+1字符相等的情况
    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }
        int maxLen = 1;
        int begin = 0;
        boolean[][] dp = new boolean[len][len];
        char[] sCharArray = s.toCharArray();
        //子串长度为1的字符都是回文子串
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        //子串长度从2开始遍历 , 巧妙
        for (int L = 2; L < len; L++) {
            //左字符从第一个字符开始遍历
            for (int i = 0; i < len; i++) {
                //则右字符的位置在 j-i+1 = L
                int j = L + i - 1;
                //如果右边界越界，退出当前循环
                if (j > len - 1) {
                    break;
                }
                //如果左右字符不相同，则从i到j，长度为L的字符不是回文串：
                if (sCharArray[i] != sCharArray[j]) {
                    dp[i][j] = false;
                    //如果相等：1.子串长度为3，直接返回true
                    //    2.子串长度大于等于3，如果 dp[i+1,j-1] 为true则返回true
                } else {
                    if (L < 4) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }

                }

                //得到本次循环的最大值
                if (dp[i][j] && j - i + 1 > maxLen) {
                    begin = i;
                    maxLen = j - i + 1;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }

    //中心扩散法：分为奇数和偶数情况：
    //奇数：从字串的一个中心向两边扩散
    //偶数：从两个中心向两边扩散
    public String longestPalindromeMid(String s) {

        int len = s.length();
        if (len < 2) {
            return s;
        }
        char[] charArray = s.toCharArray();
        //对字串的每个位置做中心扩散
        int start = 0;
        int end = 0;
        for (int i = 0; i < len; i++) {
            int maxOdd = midSpread(i, i, charArray);
            int maxEven = midSpread(i, i + 1, charArray);
            int max = Math.max(maxOdd, maxEven);
            if (max > end - start) {
                start = i - (max - 1) / 2;
                end = i + max / 2;
            }
        }
        return s.substring(start, end + 1);

    }

    //返回回文子串的长度
    private int midSpread(int left, int right, char[] charArray) {
        //奇数情况左右指针指向一个位置向两边

        while (left >= 0 && right < charArray.length && charArray[left] == charArray[right]) {
            //要防止左右指针越界
            left--;
            right++;

        }

        //退出循环表示没匹配到回文串,返回字串长度
        return right - left - 1;
    }

}