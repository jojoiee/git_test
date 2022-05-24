package com.lyjtest.hot100.q53;

import java.util.Stack;

/**
 * @author NoobProgrammer
 * @title: Solution
 * @projectName leecode
 * @description: TODO
 * @date 2022/1/2211:17
 */
public class Solution {
    public static void main(String[] args) {
        Solution.Status solution = new Status();
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        Status info = solution.getInfo(nums, 0, 8);
        System.out.println(info.mSum);
    }
    //一种数据结构 —— 线段树
    public static class Status {
        //维护四个属性：
        //在区间[l,r]内
        int lSum;//以l为左端点的最大子段和
        int rSum;//以r为右端点的最大子段和
        int mSum;//[l,r]内的最大子段和
        int iSum;//[l,r]的区间和

        public Status(int lSum, int rSum, int mSum, int iSum) {
            this.lSum = lSum;
            this.rSum = rSum;
            this.mSum = mSum;
            this.iSum = iSum;
        }

        public Status() {
        }

        //查询数组nums ， 在[l,r]内的各个属性
        public Status getInfo(int[] nums, int l, int r) {
            if (l == r) {
                return new Status(nums[l], nums[l], nums[l], nums[l]);
            }
            //分
            int m = (l + r) / 2;
            Status left = getInfo(nums, l, m);
            Status right = getInfo(nums, m + 1, r);
            //对于大于1的区间：
            //iSum = 左子区间的iSum + 右子区间的iSum
            //lSum : max(左子区间的lSum,左子区间的iSum+右子区间的lSum)
            //rSum : max(右子区间的rSum,右子区间的iSum+左子区间的rSum)
            //mSum : max(左子区间的mSum,右子区间的mSum,左子区间的rSum + 右子区间的lSum)
            return total(left, right);
        }

        private Status total(Status left, Status right) {
            Status total = new Status();
            total.iSum = left.iSum + right.iSum;
            total.lSum = Math.max(left.lSum, left.iSum + right.lSum);
            total.rSum = Math.max(right.rSum, right.iSum + left.rSum);
            total.mSum = Math.max(Math.max(left.mSum, right.mSum), left.rSum + right.lSum);
            return total;
        }
    }

}
