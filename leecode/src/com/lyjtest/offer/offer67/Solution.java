package com.lyjtest.offer.offer67;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author NoobProgrammer
 * @title: Solution
 * @projectName leecode
 * @description: TODO
 * @date 2022/2/419:18
 */
public class Solution {
    public static void main(String[] args) {
//        String s = "42";
//        Solution solution = new Solution();
//        solution.strToInt2(s);

        String s= "500_";
        String[] s1 = s.split("_");
        System.out.println(Arrays.toString(s1));
        System.out.println(s1.length);
        System.out.println(s1[0].equals(""));
    }

    public int strToInt(String str) {
        List<Character> charList = new ArrayList<>();
        //不合法的情况
        int start = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                start++;
            } else {
                break;
            }
        }
        if (str.charAt(start) > '9' || str.charAt(start) < '0' || str.charAt(start) != '-') {
            return 0;
        }
        //则有有效数字出现
        for (int i = start; i < str.length(); i++) {
            if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                charList.add(str.charAt(i));
            }
        }
        //list里面都是数字
        long result = 0;
        for (int i = 0; i < charList.size(); i++) {
            result += (charList.get(i) - 48) * Math.pow(10, charList.size() - i - 1);
        }
        if (result > Integer.MAX_VALUE) {
            return (int) str.charAt(start) == '-' ? (-Integer.MAX_VALUE) : Integer.MAX_VALUE;
        } else {
            int res = (int) result;
            return str.charAt(start) == '-' ? -res : res;
        }
    }
    public int strToInt2(String str) {
        //不合法的情况
        int start = 0;
        int sign = 1;
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == ' ') {
                start++;
            }else {
                break;
            }
        }
        if((str.charAt(start) >'9' || str.charAt(start) < '0') && str.charAt(start) != '-') {
            return 0;
        }
        if(str.charAt(start) == '-') {
            sign = -1;
            start++;
        }
        if(str.charAt(start) == '+'){
            start++;
        }
        int res = 0;
        //res = res * 10 + 当前遍历到的数字
        //则有有效数字出现
        for(int i = start; i < str.length(); i++) {
            //遇到非数字项直接break
            if(str.charAt(i) < '0' || str.charAt(i) > '9') {
                break;
            }
            //判断越界 : binary = 2147483647 / 10 = 214748364
            //两种越界情况：
            //1. 此时res > binary
            //2. res == binary 并且 遍历到的数大于7
            int binary = 214748364;
            if(res > binary || (res == binary && str.charAt(i) > '7')) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            res += res * 10 + (str.charAt(i) - '0');
        }
        return sign * res;
    }
}