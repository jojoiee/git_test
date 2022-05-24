package com.lyjtest.hot100.question11;

/**
 * @author NoobProgrammer
 * @title: MaxArea
 * @projectName leetcode
 * @description: 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
 * 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0) 。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * <p>
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 * <p>
 * 解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。
 * 在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 * @date 2021/12/516:46
 */

public class MaxArea {
}

class Solution {
    public int maxArea(int[] height) {
        int maxArea = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int area = Math.min(height[i], height[j]) * (j - i);
                if (area > maxArea) {
                    maxArea = area;
                }
            }
        }
        return maxArea;
    }

    //两个指针一个指向短板，一个指向长板
    //如果短板朝内移动：面积可能变大也可能变小：
    //如果长板朝内移动：面积不变或变小
    //因此定义两个指针：总是让其中较短的板朝内移动，才有可能使面积变大并不断更新最大值
    //直到两个指针相遇
    public int maxArea1(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;
        int area;
        while (left < right) {
            //左指针较小
            area = Math.min(height[left], height[right]) * (right - left);
            maxArea = Math.max(area, maxArea);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }


        return maxArea;
    }
}