package com.lyjtest.offer.offer12;

import java.util.ArrayList;
import java.util.List;

/**
 * @author NoobProgrammer
 * @title: Solution
 * @projectName leecode
 */
// n 位 0~9 的全排列
public class Solution {
    List<String> resList = new ArrayList<>();

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.printNumbers(2);
        System.out.println(solution.resList);
    }
    int[] used = new int[9];

    public List<String> printNumbers(int n) {
        //n位 0~9 的全排列：
        backTrace(n, 0, new StringBuilder());
        return resList;
    }

    private void backTrace(int n, int depth, StringBuilder stringBuilder) {
        if (depth == n) {
            resList.add(stringBuilder.toString());
            return;
        }
        //不遍历当前数字
        for (int i = 0; i <= 9; i++) {
            stringBuilder.append(i);
            backTrace(n, depth + 1, stringBuilder);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
    }
}
