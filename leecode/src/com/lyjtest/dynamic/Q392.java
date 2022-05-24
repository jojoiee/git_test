package com.lyjtest.dynamic;

import org.junit.Test;

import java.util.stream.IntStream;

/**
 * @author NoobProgrammer
 * @title: Q392
 * @projectName leecode
 */
public class Q392 {

    @Test
    public void test() {
        String s = "abc";
        String t = "ahbgdc";
        boolean b = isSubsequence(s, t);
        int[] nums = {1, 2};
        int[] ints = IntStream.of(nums)
                .boxed()
                .sorted((o1, o2) -> Math.abs(o1) - Math.abs(o2))
                .mapToInt(Integer::intValue).toArray();
    }

    public boolean isSubsequence(String s, String t) {
        int lenS = s.length();
        int lenT = t.length();
        //dp[i][j] : i-1结尾的s子串,与j-1结尾的t子串，相同子序列的长度为dp[i][j]
        int[][] dp = new int[lenS + 1][lenT + 1];
        for (int i = 1; i <= lenS; i++) {
            for (int j = 1; j <= lenT; j++) {
                //当前位置字符相等，最长字串是不包括这两个相同字符的子串+1
                if (s.charAt(i - 1) == t.charAt(i - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    //不相等的话,最长子串相当于是t字符不包括当前字符的子串的长度
                    //因为当前位置不能为构成字串做出贡献
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }
        return dp[lenS][lenT] == lenS;

    }
}
