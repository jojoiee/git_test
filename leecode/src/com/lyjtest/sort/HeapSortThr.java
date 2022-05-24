package com.lyjtest.sort;

/**
 * @author NoobProgrammer
 * @title: HeapSortThr
 * @projectName leecode
 */
public class HeapSortThr {
    public static void main(String[] args) {

    }

    public static void heapSort(int[] nums) {
        for (int i = nums.length / 2 - 1; i >= 0; i--) {
            adjustHeap(nums, i, nums.length);
        }
        //交换大顶堆顶部元素与最后一个元素
        for(int i = nums.length - 1; i >= 0; i--) {
            swap(nums,0,i);
            adjustHeap(nums,0,i);
        }
    }

    private static void adjustHeap(int[] nums, int i, int length) {
        int temp = nums[i];
        for (int j = 2 * i + 1; j < length; j = 2 * j + 1) {
            if(j + 1 < length && nums[j] < nums[j + 1]) {
                j++;
            }
            if(nums[j] > temp) {
                swap(nums,j,i);
                i = j;
            }else {
                break;
            }
        }
        nums[i] = temp;
    }

    private static void swap(int[] nums, int j, int i) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
