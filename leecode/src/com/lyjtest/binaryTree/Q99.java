package com.lyjtest.binaryTree;


import org.junit.Test;

/**
 * @author NoobProgrammer
 * @title: Q99
 * @projectName leecode
 */
public class Q99 {

    @Test
    public void test() {
        TreeNode treeNode = new TreeNode(1);
        TreeNode treeNode1 = new TreeNode(2);
        TreeNode treeNode2 = new TreeNode(3);
        treeNode.left = treeNode2;
        treeNode2.right = treeNode1;
        recoverTree(treeNode);
    }

    TreeNode pre;
    //二叉搜索树的中序遍历是有序的
    TreeNode[] wrongArray = new TreeNode[2];

    public void recoverTree(TreeNode root) {
        if (root == null) {
            return;
        }
        midOrder(root);
        TreeNode temp = wrongArray[0];
        wrongArray[0] = wrongArray[1];
        wrongArray[1] = temp;
    }

    private void midOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        midOrder(node.left);
        if (pre != null && pre.val > node.val) {
            wrongArray[0] = pre;
            wrongArray[1] = node;
        }
        pre = node;
        midOrder(node.right);
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
