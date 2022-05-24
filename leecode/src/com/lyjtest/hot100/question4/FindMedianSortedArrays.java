package com.lyjtest.hot100.question4;

import java.util.Arrays;

/**
 * @author NoobProgrammer
 * @title: FindMedianSortedArrays
 * @projectName leecode
 * @description: 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。
 * 请你找出并返回这两个正序数组的 中位数 。
 * 输入：nums1 = [1,3], nums2 = [2]
 * 输出：2.00000
 * 解释：合并数组 = [1,2,3] ，中位数 2
 * @date 2021/12/410:37
 */
public class FindMedianSortedArrays {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr1 = {0, 0, 0, 0, 0};
        int[] arr2 = {-1, 0, 0, 0, 0, 0, 1};
        double medianSortedArrays = solution.findMedianSortedArrays(arr1, arr2);
        System.out.println(medianSortedArrays);
    }
}

class Solution {
    /*
    二分查找
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        boolean isOdd = (nums1.length + nums2.length) % 2 == 1;
        if (isOdd) {
            int k = (nums1.length + nums2.length) / 2 + 1;
            return getKElement(nums1, nums2, k);
        } else {
            int k = (nums1.length + nums2.length) / 2;
            return (getKElement(nums1, nums2, k) + getKElement(nums1, nums2, k + 1)) / 2.0;
        }
    }

    //查找两个数组排序后位于k处的元素
    private int getKElement(int[] nums1, int[] nums2, int k) {
        int lengthS1 = nums1.length;
        int lengthS2 = nums2.length;
        //当前数组的起始位置
        int indexS1 = 0;
        int indexS2 = 0;

        while (true) {
            //边界情况
            //一个数组遍历到了最后，就将另一个数组的第k个元素返回
            if (indexS1 == lengthS1) {
                return nums2[indexS2 + k - 1];
            }
            if (indexS2 == lengthS2) {
                return nums1[indexS1 + k - 1];
            }
            //如果k == 1就将两个数组的第一个元素的较小值返回
            if (k == 1) {
                return Math.min(nums1[indexS1], nums2[indexS2]);
            }


            //一般情况
            int half = k / 2;
            int newIndexS1 = Math.min(lengthS1, indexS1 + half) - 1;
            int newIndexS2 = Math.min(lengthS2, indexS2 + half) - 1;
            if (nums1[newIndexS1] <= nums2[newIndexS2]) {
                //此时距离要查询的第k个数接近了
                k -= (newIndexS1 - indexS1 + 1);
                //将数组1的前newIndexS1个元素移除：通过改变起始坐标
                indexS1 = newIndexS1 + 1;

            } else {
                k -= (newIndexS2 - indexS2 + 1);
                indexS2 = newIndexS2 + 1;

            }

        }
    }
}