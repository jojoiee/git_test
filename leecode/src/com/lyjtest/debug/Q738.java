package com.lyjtest.debug;

/**
 * @author NoobProgrammer
 * @title: Q738
 * @projectName leecode
 */
public class Q738 {
}

//class Solution {
//    public int monotoneIncreasingDigits(int n) {
//        String s= n + "";
//        int flag = s.length();
//
//        for(int i = s.length() - 1; i > 0; i--) {
//            if(s.charAt(i) < s.charAt(i - 1)) {
//                flag = i;
//                s.charAt(i - 1)--;
//            }
//        }
//        for(int i = flag; i < s.length(); i++) {
//            s.charAt(i) = '9';
//        }
////        return Integer.parseInt(s);
////
//
//    }
//}