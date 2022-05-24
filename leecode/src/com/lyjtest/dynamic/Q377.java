package com.lyjtest.dynamic;

/**
 * @author NoobProgrammer
 * @title: Q377
 * @projectName leecode
 * @description: TODO
 * @date 2022/2/722:00
 */
public class Q377 {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        int target = 4;
        combinationSum4(nums,target);
    }
    public static int combinationSum4(int[] nums, int target) {
        //求排列数的多重背包问题
        int[] dp = new int[target + 1];
        //dp[j] : 目标数为j的组合总数为 dp[j];
        //dp[j] += dp[j - nums[i]];
        dp[0] = 1;

        //求排列数 -> 外层遍历背包(目标数)，内存遍历物品(nums数组)
        for (int i = 1; i <= target; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i - nums[j] >= 0) {
                    dp[i] += dp[i - nums[j]];
                }
            }
        }
        return dp[target];
    }

}
