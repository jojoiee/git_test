package com.lyjtest.hot100.question15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author NoobProgrammer
 * @title: ThreeSum
 * @projectName leecode
 * @description: 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，
 * 使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * @date 2021/12/69:31
 */
public class ThreeSum {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> lists = solution.threeSum1(arr);
        System.out.println(lists);
    }
}

//class Solution {
//    public List<List<Integer>> threeSum(int[] nums) {
//        //遍历数组
//        List<List<Integer>> resList = new ArrayList<>();
//        List<Integer> temp = null;
////        for (int i = 0; i < nums.length; i++) {
////            for (int j = i + 1; j < nums.length; j++) {
////                if ((temp = sumZero(nums[i], nums[j], nums)) != null) {
////                    resList.add(temp);
////                }
////            }
////        }
//
//
//        return resList;
//
//    }
//
//    //编写一个方法
//
//    /**
//     * 在数组中寻找等于 -(n1+n2)值的元素，有则返回这三个数组成的排序好的数组,并以从小到大排序,没有返回null
//     */
//    private List<Integer> sumZero(int n1, int n2, int[] nums) {
//        ArrayList<Integer> resList = new ArrayList<>();
//        int target = -(n1 + n2);
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] == target && i != n1 && i != n2) {
//                resList.add(n1);
//                resList.add(n2);
//                resList.add(target);
//                return resList;
//            }
//        }
//        return null;
//    }
//}


//排序+双指针

/**
 * 对于一个有序数组(从小到大排列)
 * 如果存在 a+b+c = 0 a < b < c
 * 那么 在a不变的条件下，b指针向右移动，c指针必然向左移动
 * 不重复的实现：
 * 如果此次枚举的元素与上一轮循环枚举的相同，枚举下一个元素
 */
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> resList = new ArrayList<>();
        //对数组进行排序
        Arrays.sort(nums);
        int first = 0;
        int second = 0;
        int third = 0;
        for (first = 0; first < nums.length; ++first) {
//            如果此次枚举的元素与上一轮循环枚举的相同，枚举下一个元素
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            //右指针指向数组的最后一个元素
            third = nums.length - 1;
            //左指针需要匹配的数值为：
            int target = -nums[first];
            //枚举second指针
            for (second = first + 1; second < nums.length; ++second) {
                //同理需要和上次枚举的数不一样
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                //移动second指针使三数之和增大，移动third指针使三数之和减小

                if (second < third && nums[second] + nums[third] > target) {
                    --third;
                }

                if (second == third) {
                    break;
                }

                //找到目标数加入列表
                if (nums[second] + nums[third] == target) {
                    List<Integer> tempList = new ArrayList<>();
                    tempList.add(nums[first]);
                    tempList.add(nums[second]);
                    tempList.add(nums[third]);
                    resList.add(tempList);
                }
            }
        }


        return resList;
    }

    //方法相同：双指针 + 排序
    public List<List<Integer>> threeSum1(int[] nums) {
        //数据校验：如果数组元素个数小于3返回空列表
        //对数组进行排序
        Arrays.sort(nums);
        ArrayList<List<Integer>> resList = new ArrayList<>();

        if (nums.length < 3) {
            return resList;
        }

        //第一个指针总是指向三个数中最小的，要求：
        //1. nums[first]不能大于0
        //2. first指向的值不能与前一个相同，避免重复
        //为second 和 third指针留位置
        for (int first = 0; first < nums.length - 2; first++) {
            //nums[first] > 0 此时不可能满足三数之和大于0，直接break；
            if (nums[first] > 0) {
                break;
            }
            //first指向的值不能与前一个相同
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }

            //第二个指针从first的下一个开始遍历
            int second = first + 1;
            //第三个指针从数组的最后开始遍历
            int third = nums.length - 1;
            //此时需要寻找的目标数是：
            //second与third指针不能相遇
            while (second < third) {
                //同理，second指向的数字也不能和前一个相同

                //如果三数之和大于0;要向0逼近需要将third指针左移，要保证左移的边界条件:不超过second
                int sum = nums[first] + nums[second] + nums[third];
                if (sum == 0) {
                    List<Integer> tempList = new ArrayList<>();
                    tempList.add(nums[first]);
                    tempList.add(nums[second]);
                    tempList.add(nums[third]);
                    resList.add(tempList);
                    //无论如何先更新到下一个指针
                    second++;
                    third--;
                    //如果重复,并且second < third满足，则移动second 和 third指针
                    while (second < third && nums[second] == nums[second - 1]) {
                        second++;
                    }
                    while (second < third && nums[third] == nums[third + 1]) {
                        third--;
                    }
                } else if (sum > 0) {
                    third--;
                } else {
                    second++;
                }

            }
        }
        return resList;
    }
}