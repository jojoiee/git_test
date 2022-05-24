package com.lyjtest.binaryTree.tranversal;


import java.util.*;

/**
 * @author NoobProgrammer
 * @title: PreOrder
 * @projectName leecode
 * @description: TODO
 * @date 2022/1/2910:01
 */
public class PreOrder {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode treeNode1 = new TreeNode(2);
        TreeNode treeNode2 = new TreeNode(3);
        TreeNode treeNode3 = new TreeNode(4);
        TreeNode treeNode4 = new TreeNode(5);
        TreeNode treeNode5 = new TreeNode(6);
        TreeNode treeNode6 = new TreeNode(7);
        root.left = treeNode1;
        root.right = treeNode6;
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode3.left = treeNode4;
        treeNode3.right = treeNode5;
        PreOrder preOrder = new PreOrder();
        preOrder.preOrder(root);
        preOrder.unifyMethod(root);
    }

    //前序遍历迭代法
    public void preOrder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> resList = new ArrayList<>();
        if (root == null) {
            return;
        }

        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode top = stack.pop();
            resList.add(top.val);
            if (top.right != null) {
                stack.push(top.right);
            }
            if (top.left != null) {
                stack.push(top.left);
            }

        }
        System.out.println(Arrays.toString(resList.toArray()));

    }

    public void unifyMethod(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> resList = new ArrayList<>();
        if (root != null) {
            stack.push(root);
        }
        while (!stack.isEmpty()) {
            TreeNode top = stack.pop();
            if (top != null) {
                //后序遍历 中 左 右 -> 入栈顺序 右 左 中
                if (top.right != null) {
                    stack.push(top.right);
                }
                if (top.left != null) {
                    stack.push(top.left);
                }
                stack.push(top);
                stack.push(null);

            } else {
                TreeNode pop = stack.pop();
                resList.add(pop.val);
            }
        }
        System.out.println(resList);
        int x = (int) (Math.pow(2,10) - 1);


    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public TreeNode(int val) {
        this.val = val;
    }
}
