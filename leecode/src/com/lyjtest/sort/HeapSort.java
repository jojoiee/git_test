package com.lyjtest.sort;

import java.util.Arrays;

/**
 * @author NoobProgrammer
 * @title: HeapSort
 * @projectName leetcode
 */
public class HeapSort {

    public static void main(String[] args) {
        HeapSort heapSort = new HeapSort();
        int[] arr = {16, 7, 3, 20, 17, 22,4,5,67,9,90,4,38};
        heapSort.heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }


    private void heapSort(int[] arr) {
        //创建堆结构：
        //对arr中的非叶子节点从下至上，从右至左调整结构
        //(arr.length - 1) /2 -> 最后一个结点的父节点 -> 最后一个非叶子节点
        for(int i = (arr.length - 1) /2; i >= 0; i--) {
            adjustHeap(arr,i,arr.length - 1);

        }
        //将堆顶元素(数组中的最大值，与队尾元素交换 -> 即区分为有序和无序队列)
        for(int i = arr.length - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            //交换完毕之后，重新生成堆
            adjustHeap(arr,0,i);

        }

    }


    /**
     * 将给定的数组，按照父节点为parent构建为大顶堆
     * @param arr
     * @param parent 对此节点的子节点进行排序 -> parent节点大于下面的叶子节点
     * @param length 最后一个待排序的元素索引
     */
    private void adjustHeap(int[] arr, int parent, int length) {
        //保存当前父节点 (如果有比父节点大的会被替换)
        int temp = arr[parent];
        //当前父节点的左子节点索引
        int lChild = 2 * parent +1;
        while(lChild < length) {
            int rChild = lChild + 1;
            //如果右子节点比左子节点大
            if(rChild < length && arr[rChild] > arr[lChild]) {
                lChild++;
            }
            //如果子节点不存在比parent大的数，break
            if(arr[lChild] <= temp) {
                break;
            }
            //负责就要换父节点，父节点交换之后，它下面的子节点也可能需要变化
            arr[parent] = arr[lChild];
            parent = lChild;
            lChild = 2 * parent +1;
        }
        //最后将暂存的temp赋给当前parent指向的位置:被交换过的节点
        arr[parent] = temp;
    }

}


