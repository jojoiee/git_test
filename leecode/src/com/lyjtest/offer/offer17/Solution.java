package com.lyjtest.offer.offer17;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author NoobProgrammer
 * @title: solution
 * @projectName leecode
 */
public class Solution {

    @Test
    public void test() {
        int[] ints = printNumbers(3);
        System.out.println(Arrays.toString(ints));
    }

    List<String> resList = new ArrayList<>();
    int start; //字符串的左边界
    int nine; //表示9的个数， 如果 n - start == nine 说明每一位都是9

    public List<String> printNumbersImpl(int n) {
        StringBuilder stringBuilder = new StringBuilder();
        start = n - 1;
        backTrace(0, n, stringBuilder);
        return resList;

    }

    public int[] printNumbers(int n) {
        resList = printNumbersImpl(n);
        int[] array = new int[resList.size()];
        for(int i = 0; i < resList.size(); i++) {
            array[i] = Integer.parseInt(resList.get(i));
        }
        return array;
    }

    private void backTrace(int depth, int n, StringBuilder stringBuilder) {
        if (depth == n) {
            //截取字符串左边界之后的值
            String exclusionZero = stringBuilder.toString().substring(start);
            if (!"0".equals(exclusionZero)) {
                resList.add(exclusionZero);
            }
            if (n - start == nine) {
                start--; //如果每一位都是9，start要前进一位
            }
            return;

        }
        for (int i = 0; i <= 9; i++) {
            if (i == 9) {
                nine++;
            }
            stringBuilder.append(i);
            backTrace(depth + 1, n, stringBuilder);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
        //一轮循环只会出现一次9
        nine--;

    }

}
