package com.lyjtest.debug.bagQuestion;

import org.junit.Test;

import java.util.Arrays;


/**
 * @author NoobProgrammer
 * @title: Solution
 * @projectName leecode
 * @description: TODO
 * @date 2022/1/1220:44
 */
public class Solution {

    @Test
    public void bagSolution() {
        //
        int[] weight = {1, 3, 4};
        int[] value = {15, 20, 30};
        int totalWeight = 4;

        int[][] dp = new int[weight.length][totalWeight + 1];
        //初始化 第一行从 下标为1开始均为物品0的价值
        for (int i = weight[0]; i < totalWeight + 1; i++) {
            dp[0][i] = value[0];
        }

        //动态规划：
        //递推公式 ：
        //dp[i][j] : 表示在[0-i]中选择物品，放进背包重量为j的情况下获得的最大价值
        //从上到下从左到右填写
        for (int i = 1; i < weight.length; i++) {

            for (int j = 0; j < totalWeight + 1; j++) {
                if (j < weight[i]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i]] + value[i]);
                }
            }
        }
//        for(int i = 1; i < weight.length; i++) {
//
//            for(int j = 1; j < totalWeight + 1; j++) {
//
//            }
//        }

        //打印dp数组
        for (int[] ints : dp) {
            System.out.println(Arrays.toString(ints));
        }

    }

    //使用一维数组解决背包问题
    @Test
    public void bagSolutionArray() {
        int[] weight = {1, 3, 4};
        int[] value = {15, 20, 30};
        int totalWeight = 4;
        //dp[j] : 容量为j的背包，能背的物品价值为高为dp[j]
        int[] dp = new int[totalWeight + 1];
        //初始化dp均为0
        //先遍历向包内存放的物品
        for (int i = 0; i < weight.length; i++) {
            //从后向前遍历背包容量 防止物品重用
            for (int j = totalWeight; j >= weight[i]; j--) {
//                if (j - weight[i] > 0) {
                dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
//                }
            }
        }
        System.out.println(Arrays.toString(dp));



    }

}


