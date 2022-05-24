package com.lyjtest.binaryTree.tranversal;

import java.util.*;

/**
 * @author NoobProgrammer
 * @title: PostOrder
 * @projectName leecode
 * @description: TODO
 * @date 2022/1/2910:19
 */
public class PostOrder {
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
        PostOrder postOrder = new PostOrder();
        postOrder.postOrder(root);
        postOrder.unifyMethod(root);

    }


    //层序遍历的后序遍历：
    //前序遍历 中左右 -> 改变入栈顺序 -> 中右左 -> 翻转result数组 -> 左右中
    public void postOrder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> resList = new ArrayList<>();
        if (root == null) {
            return;
        }

        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode top = stack.pop();
            resList.add(top.val);
            if (top.left != null) {
                stack.push(top.left);
            }
            if (top.right != null) {
                stack.push(top.right);
            }

        }

        Collections.reverse(resList);
        System.out.println(resList);


    }

    public void unifyMethod(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> resList = new ArrayList<>();
        if(root != null) {
            stack.push(root);
        }
        while (!stack.isEmpty()) {
            TreeNode top = stack.pop();
            if(top != null) {
                //后序遍历 左 右 中 -> 入栈顺序 中 右 左
                stack.push(top);
                stack.push(null);
                if(top.right != null) {
                    stack.push(top.right);
                }
                if(top.left != null) {
                    stack.push(top.left);
                }

            }else {
                TreeNode pop = stack.pop();
                resList.add(pop.val);
            }
        }
        System.out.println(resList);

    }
}
