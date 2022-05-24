package com.lyjtest.hot100.question3;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author NoobProgrammer
 * @title: LengthOfLongestSubstring
 * @projectName leecode
 * @description: 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3
 * @date 2021/12/216:02
 */
public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String str = "abcabcbb";
        int i = solution.lengthOfLongestSubstring(str);
        System.out.println(i);
    }
}

class Solution {

    //官方解答：滑动窗口：一个窗口中与新添加进的字符相同的一定是这个窗口的第一个字符
    //左指针指向每个子串的起始位置，右指针向后遍历，直到包围的字符串存在相同字符
    //此时左指针加一，将之前左指针指向的字符抛弃，右指针继续遍历，然后循环

    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> hashSet = new HashSet<>();
        int right = -1;//右指针
        int longest = 0;//最长字串

        for (int i = 0; i < s.length(); i++) { //i表示左指针
            //如果下一个字符hash表中有：把这个字符从哈希表中删除,即当前左指针的前一个位置
            //因为一轮循环结束 左指针已经前进一位
            if (i != 0) {
                hashSet.remove(s.charAt(i - 1));
            }
            //右指针不超出字符串范围 并且 hashset集合中没有下一个字符
            while (right + 1 < s.length() && !hashSet.contains(s.charAt(right + 1))) {
                hashSet.add(s.charAt(right + 1));
                ++right;
            }
            //这个循环退出就表示right指针的下一个字符与当前i所指的字符相同
            //right - i + 1就是这一轮找到的最大字串
            longest = Math.max(right - i + 1, longest);

        }
        return longest;
    }


    public int lengthOfLongestSubstring1(String s) {
        int longest = 0;
        int num = 0;//不重复字符串的连续个数
        HashSet<Object> hashSet = new HashSet<>();
        //暴力匹配：
        for (int i = 0; i < s.length(); ) {

            if (hashSet.add(s.charAt(i))) {//如果这个字母放进去了
                num++;
                i++;
                if (num > longest) {
                    longest = num;

                }
            } else {
                hashSet.clear();//如果这个字母放不进去,把set清空
                if (num > longest) {
                    longest = num;

                }
                i = i - num + 1;
                num = 0;
            }


        }
        return longest;
    }
}