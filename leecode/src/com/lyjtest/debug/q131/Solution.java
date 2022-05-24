package com.lyjtest.debug.q131;

import java.util.ArrayList;
import java.util.List;

/**
 * @author NoobProgrammer
 * @title: Solution
 * @projectName leecode
 * @description: TODO
 * @date 2022/1/515:21
 */
public class Solution {

    List<List<String>> resList = new ArrayList<>();
    List<String> path = new ArrayList<>();

    public List<List<String>> partition(String s) {
        StringBuilder sb = new StringBuilder();
        backTrace(s,sb,0);
        return resList;
    }

    private void backTrace(String s, StringBuilder sb, int index) {
        if(index == s.length()) {
            resList.add(new ArrayList<>(path));
            //重置path
            path = new ArrayList<>();
            return;
        }

        for(int i = index; i < s.length(); i++) {
            //看当前sb里的字符串是不是回文串
            if(isPartition(sb.toString())) {
                //是回文串就将sb加入path,并清空sb从下一个字符开始拼接
                path.add(sb.toString());
                sb = new StringBuilder();
            }
            //如果不是
            sb.append(s.charAt(i));
            backTrace(s, sb, index + 1);
            sb.deleteCharAt(index);
        }
    }

    private boolean isPartition(String s) {
        int left = 0;
        int right = s.length() - 1;
        while(left <= right) {
            if(s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
//            Integer.parseInt()
            right--;
        }
        return true;
    }


}