package com.lyjtest.codeThink.binaryTree.node3;

import java.util.*;

/**
 * @author NoobProgrammer
 * @title: TraversalBinaryTree
 * @projectName leecode
 * @description: TODO
 * @date 2021/12/2716:33
 */

//非递归方法
public class TraversalBinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode node1 = new TreeNode(9);
        TreeNode node2 = new TreeNode(20);
        TreeNode node3 = new TreeNode(15);
        TreeNode node4 = new TreeNode(7);
        root.left = node1;
        root.right = node2;
        node2.left = node3;
        node2.right = node4;
        TraversalBinaryTree traversalBinaryTree = new TraversalBinaryTree();
        List<TreeNode> res = new ArrayList<>();
        List<Integer> resList = new ArrayList<>();
        List<TreeNode> treeNodes = traversalBinaryTree.preOrder(root, res);
        List<Integer> list = traversalBinaryTree.middleOrder(root, resList);
        List<TreeNode> treeNodes1 = traversalBinaryTree.infixOrder(root, res);
        System.out.println(treeNodes);
        System.out.println(list);
        System.out.println(treeNodes1);
    }


    //前序遍历
    public List<TreeNode> preOrder(TreeNode root, List<TreeNode> resList) {
        if (root == null) {
            return resList;
        }
        //当前节点加入结果列表
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {


            
            TreeNode node = stack.pop();
            //将弹出栈的节点加入结果列表
            resList.add(node);
            //左右子树分别入栈
            //先右后左
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }

        }
        return resList;
    }


    //前序遍历弹出的节点正好就是需要处理(加入结果列表)的节点
    //中序遍历
    public List<Integer> middleOrder(TreeNode root, List<Integer> resList) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode cur = root;

        while (cur != null || !stack.isEmpty()) {
            //如果cur节点不为空,将左子树入栈
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                //如果当前节点为空，需要处理栈,让cur指向当前栈顶元素的右指针(左指针已经进栈)
                cur = stack.peek();
                TreeNode node = stack.pop();
                //将node的值加入List
                resList.add(node.val);
                cur = cur.right;
            }
        }
        return resList;
    }

    //后序遍历
    public List<TreeNode> infixOrder(TreeNode root, List<TreeNode> resList) {
        if (root == null) {
            return resList;
        }
        //当前节点加入结果列表
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            //将弹出栈的节点加入结果列表
            resList.add(node);
            //左右子树分别入栈
            //先右后左
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }

        //翻转结果数组
        Collections.reverse(resList);
        return resList;
    }


}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public TreeNode(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                '}';
    }
}
