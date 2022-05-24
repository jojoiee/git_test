package com.lyjtest.searchAndTraceback.offer26;

/**
 * @author NoobProgrammer
 * @title: Ofer26
 * @projectName leecode
 * @description: 树的子结构
 * @date 2021/12/1115:13
 */
public class Offer26 {
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
    //找到二叉树A中的根节点与二叉树B相同的节点
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) {
            return false;
        }
        return recur(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);

    }

    /**
     * @param aRoot 二叉树A的一个节点
     * @param B     要匹配的子树
     * @return B是否为aNode的子树
     */
    public boolean recur(TreeNode aRoot, TreeNode B) {
        if (B == null) {
            return true;
        }
        if (aRoot == null || aRoot.val != B.val) {
            return false;
        } else {
            //判断aRoot的左右节点与B是否相等
            return recur(aRoot.left, B.left) && recur(aRoot.right, B.right);
        }
    }

}