package com.lyjtest.debug.q538;



/**
 * @author NoobProgrammer
 * @title: Solution
 * @projectName leecode
 * @description: TODO
 * @date 2022/1/313:54
 */
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
//        int i = solution.gtNums(root, root.val, 0);

//        System.out.println(i);
    }


    private void gtNums(TreeNode root , int sum) {
//        if (root == null) {
//            return sum;
//        }
//        if (root.val < num) {
//            return gtNums(root.right, num, sum);
//        }
//        int leftSum = gtNums(root.left, num, sum + root.val);
//        int rightSum = gtNums(root.right, num, sum + root.val);
//        return leftSum + rightSum;


    }


}

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
