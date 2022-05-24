package com.lyjtest.sort;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author NoobProgrammer
 * @title: QuickSortByLoop
 * @projectName leetcode
 */
public class QuickSortByLoop {
    public static void main(String[] args) {
        int[] arr = {4,3,5,7,2,5};
        quickSortImpl(arr,0,arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSortImpl(int[] arr, int left, int right) {
        if(left >= right) {
            return;

        }
        Stack<Integer> stack = new Stack<>();
        stack.push(left);
        stack.push(right);
        while(!stack.isEmpty()) {
            right = stack.pop();
            left = stack.pop();
            int pivot = partition(arr,left,right);
            if(left < pivot - 1) {
                stack.push(left);
                stack.push(pivot - 1);
            }
            if(right > pivot + 1) {
                stack.push(pivot + 1);
                stack.push(right);
            }
        }
    }

    private static int partition(int[] arr, int left, int right) {
        int i = left;
        int j = right;
        int base = arr[left];
        while(i < j) {
            while(i < j && arr[j] >= base) {
                j--;
            }
            while(i < j && arr[i] <= base ) {
                i++;
            }
            swap(arr,i,j);
        }
        swap(arr,left,i);
        return i;

    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
