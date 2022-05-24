package com.lyjtest.hot100;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author NoobProgrammer
 * @title: TwoSum
 * @projectName leecode
 * @description: 1.两数之和
 * @date 2021/12/211:43
 */
public class TwoSum {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {3, 2, 4};
        int target = 6;
        int[] ints = solution.twoSum1(arr, target);
        System.out.println(Arrays.toString(ints));
    }

}

class Solution {
    //使用hashmap
    public int[] twoSum(int[] nums, int target) {
        //key保存值，value保存下标
        Map<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(target - nums[i])) {
                return new int[]{hashMap.get(target - nums[i]), i};
            }
            hashMap.put(nums[i], i);
        }
        return null;
    }

    //双层for循环
    public int[] twoSum1(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            int search = target - nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == search) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }
}
