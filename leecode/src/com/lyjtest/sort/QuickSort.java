package com.lyjtest.sort;

import java.util.Arrays;

/**
 * @author NoobProgrammer
 * @title: QuickSort
 * @projectName leecode
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {4,3,5,7,2,5};
        quickSort(arr,0,arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int i = partition(arr, left, right);
        //分割
        quickSort(arr, left, i - 1);
        quickSort(arr, i + 1, right);

    }


    private static int partition(int[] arr, int left, int right) {

        //以left为基准数
        int i = left;
        int j = right;
        int base = arr[left];
        while (i < j) {
            while (i < j && arr[j] >= base) {
                j--;
            }
            while (i < j && arr[i] <= base) {
                i++;
            }

            //i和j位置的元素相互交换
            swap(arr, i, j);
        }
        //循环退出时i指向l应该存在的位置
        swap(arr, left, i);
        return i;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
