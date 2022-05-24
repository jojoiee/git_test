package com.lyjtest.debug;

import java.util.*;

/**
 * @author NoobProgrammer
 * @title: Solution
 * @projectName leecode
 * @description: TODO
 * @date 2021/12/3022:35
 */


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Solution {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(2);

        root.right = node1;
        node1.left = node2;
        Solution solution = new Solution();
        int[] mode = solution.findMode(root);
        System.out.println(Arrays.toString((mode)));
    }

    //记录上一个节点
    TreeNode pre;
    int sum = 0; //记录相同值连续的个数
    Map<Integer, Integer> map = new HashMap<>();

    public int[] findMode(TreeNode root) {
        List<Integer> resList = new ArrayList<>();
        if (root == null) {
            return new int[]{};
        }
        findModeMap(root);
        //在map中找合适的值
        int maxTime = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            maxTime = Math.max(maxTime, entry.getValue());
        }
        //将值为maxTime的key加入数组
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == maxTime) {
                resList.add(entry.getKey());
            }
        }
        //列表转换为数组
        int[] resArray = new int[resList.size()];
        for (int i = 0; i < resList.size(); i++) {
            resArray[i] = resList.get(i);
        }
        return resArray;

    }

    public void findModeMap(TreeNode node) {
        if (node == null) {
            return;
        }
        //前序遍历
        findModeMap(node.left);
        //如果不是遍历到的第一个节点
        if (pre != null) {
            if (pre.val == node.val) {
                sum++;
                map.put(pre.val, sum);
            } else {
                map.put(pre.val, sum);
                sum = 0;
            }
        }
        //更新pre
        pre = node;

        findModeMap(node.right);
    }

}