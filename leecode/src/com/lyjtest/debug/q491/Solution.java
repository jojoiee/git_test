package com.lyjtest.debug.q491;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author NoobProgrammer
 * @title: Solution
 * @projectName leecode
 */
public class Solution {
    public static void main(String[] args) {
        int[] nums = {4,6,7,7};
        Solution solution = new Solution();
        solution.findSubsequences(nums);
    }
    List<List<Integer>> resList = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    Set<Integer> set = new HashSet<>();
    public List<List<Integer>> findSubsequences(int[] nums) {
        backTrace(nums,0);
        return resList;

    }


    private void backTrace(int[] nums, int startIndex) {
        for(int i = startIndex; i < nums.length; i++) {
            if(set.contains(nums[i])) {
                continue;
            }
            set.add(nums[startIndex]);
            //如果当前能组成递增子序列,加入结果集
            if(path.size() == 0 || nums[i] >= path.get(path.size() - 1)) {
                path.add(nums[i]);
                if(path.size() >= 2) {
                    resList.add(new ArrayList<>(path));
                }

                backTrace(nums, i + 1);
                path.remove(path.size() - 1);
            }
        }
    }
}
