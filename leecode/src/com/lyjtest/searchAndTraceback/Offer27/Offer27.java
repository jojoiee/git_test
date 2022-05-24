package com.lyjtest.searchAndTraceback.Offer27;

import java.util.Stack;

/**
 * @author NoobProgrammer
 * @title: Offer27
 * @projectName leecode
 * @description: TODO
 * @date 2021/12/1115:46
 */
public class Offer27 {
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    //递归法
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode temp = root.left;
        root.left = mirrorTree(root.right);
        root.right = mirrorTree(temp);
        return root;

    }

    //使用栈
    public TreeNode mirrorTree1(TreeNode root) {
        if (root == null) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()) {
            TreeNode node = stack.pop();
            //将该节点的左右节点入栈
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
            //交换该节点的左右节点
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;

        }
        return root;
    }


}