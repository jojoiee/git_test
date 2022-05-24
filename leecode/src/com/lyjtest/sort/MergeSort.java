package com.lyjtest.sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author NoobProgrammer
 * @title: MergeSort
 * @projectName leecode
 */
//归并排序
public class MergeSort {

    @Test
    public void test() {
        int[] arr = {16, 7, 3, 20, 17, 22,4,5,67,9,90,4,38};
        int[] ints = mergeSort(arr);
        System.out.println(Arrays.toString(ints));
    }

    int[] temp;
    public int[] mergeSort(int[] arr) {
        temp = new int[arr.length];
        mergeSortImpl(arr,0,arr.length - 1);
        return arr;

    }

    private void mergeSortImpl(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = (left + right) / 2;
        mergeSortImpl(arr, left, mid);
        mergeSortImpl(arr, mid + 1, right);
        mergeTwoSide(arr,left,mid,right);

    }

    private void mergeTwoSide(int[] arr, int left, int mid, int right) {
        for(int i = left; i <= right; i++) {
            temp[i] = arr[i];
        }
        int i = left;
        int j = mid + 1;
        for(int k = left; k <= right; k++) {
            if(i == mid + 1) {
                arr[k] = temp[j];
                j++;
            }else if(j == right + 1) {
                arr[k] = temp[i];
                i++;
            }else if(temp[i] <= temp[j]) {
                arr[k] = temp[i];
                i++;
            }else if (temp[i] > temp[j]) {
                arr[k] = temp[j];
                j++;
            }
        }

    }
}
