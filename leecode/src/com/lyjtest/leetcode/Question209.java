package com.lyjtest.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author NoobProgrammer
 * @title: Question209
 * @projectName leecode
 * @description: TODO
 * @date 2021/12/1619:15
 */
public class Question209 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {2,3,1,2,4,3};
        int i = solution.minSubArrayLen(7, nums);

    }
}

class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int size = nums.length;
        int sum = 0;
        List<Integer> List = new ArrayList<>();
        //记录最小的数组长度
        int minlength = size;
        for(int i = 0; i < size; i++) {
            int j = i;
            while (j < size && sum < target){
                sum += nums[j];
                List.add(nums[j]);
                j++;
            }
            if(sum == target){
                minlength = Math.min(List.size(), minlength);
                List.clear();
            }
            sum = 0;
        }
        return minlength;
    }
}