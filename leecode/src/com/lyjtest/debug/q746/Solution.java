package com.lyjtest.debug.q746;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author NoobProgrammer
 * @title: Solution
 * @projectName leecode
 * @description: TODO
 * @date 2022/1/1021:20
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] cost = {10,15,20};
        int i = solution.minCostClimbingStairs(cost);
        System.out.println(i);
    }

    @Test
    public int minCostClimbingStairs(int[] cost) {
        //分为两种情况：从0开始 从1开始
        int[][] dp = new int[cost.length + 1][2];

        dp[1][0] = cost[0];
        dp[2][1] = cost[1];
        for(int i = 2; i <= cost.length; i++) {
            dp[i][0] = Math.min(dp[i - 1][0] + cost[i - 1],dp[i - 2][0] +cost[i - 2]);
        }

        for(int i = 3; i <= cost.length; i++) {
            dp[i][1] = Math.min(dp[i - 1][1] + cost[i - 1],dp[i - 2][1] +cost[i - 2]);
        }

        for(int[] array : dp) {
            System.out.println(Arrays.toString(array));
        }

        return Math.min(dp[cost.length][0],dp[cost.length][1]);
    }
}