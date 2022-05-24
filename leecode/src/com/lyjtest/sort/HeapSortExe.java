package com.lyjtest.sort;

import java.util.Arrays;

/**
 * @author NoobProgrammer
 * @title: HeapSortExe
 * @projectName leecode
 */
public class HeapSortExe {
    public static void main(String[] args) {
        int []arr = {7,6,7,11,5,12,3,0,1};
        System.out.println("排序前："+ Arrays.toString(arr));
        sort(arr);
        System.out.println("排序前："+Arrays.toString(arr));
    }

    public static void sort(int[] arr) {
        //构建大顶堆 arr.length / 2 - 1是最后一个非叶子节点
        for(int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustHeap(arr,i,arr.length);
        }

        //交换大顶堆顶部元素与最后一个元素
        for(int i = arr.length - 1; i >= 0; i--) {
            swap(arr,0,i);
            adjustHeap(arr,0,i);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    //调整大顶堆
    private static void adjustHeap(int[] arr, int i, int length) {
        int temp = arr[i];
        //从i节点的第一个左子节点为止，找最大值，赋给i所在的位置
        for(int k = 2 * i + 1; k < length; k = 2 * k + 1) {
            if(k + 1 < length && arr[k] < arr[k + 1]) {
                k++; //找到左子节点和右子节点的较大值
            }
            if(arr[k] > temp) {
                arr[i] = arr[k]; //把较大值赋给父节点的位置
                i = k ; //交换后的子树是否满足大顶堆
            }else {
                break;
            }
        }
        arr[i] = temp;
    }

}
