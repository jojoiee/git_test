package com.lyjtest.debug.q113;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author NoobProgrammer
 * @title: Solution
 * @projectName leecode
 * @description: TODO
 * @date 2022/1/315:06
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
        TreeNode root = new TreeNode(5);
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(8);
        TreeNode node3 = new TreeNode(6);
        TreeNode node4 = new TreeNode(10);
        root.left = node1;
        root.right = node2;
        node2.left = node3;
        node2.right = node4;
        Solution solution = new Solution();
        List<List<Integer>> lists = solution.pathSum(root, 19);
        System.out.println(lists);
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> resList = new ArrayList<>();
        List<Integer> tempList = new LinkedList<>();
        if (root == null) {
            return resList;
        }
        pathSumImpl(root, targetSum, resList, tempList);
        return resList;

    }

    private void pathSumImpl(TreeNode root, int targetSum, List<List<Integer>> resList, List<Integer> tempList) {
        tempList.add(root.val);
        if (root.left == null && root.right == null && targetSum == root.val) {
            //满足条件的值加入列表
            resList.add(tempList);
            return;
        }
        if (root.left == null && root.right == null) {
            return;
        }
        //回溯
        if (root.left != null) {
            pathSumImpl(root.left, targetSum - root.val, resList, tempList);
            tempList.remove(tempList.size() - 1);
        }

        if (root.right != null) {
            pathSumImpl(root.right, targetSum - root.val, resList, tempList);
            tempList.remove(tempList.size() - 1);
        }
    }
}