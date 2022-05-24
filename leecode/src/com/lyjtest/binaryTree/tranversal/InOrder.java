package com.lyjtest.binaryTree.tranversal;

import com.lyjtest.hot100.q53.Solution;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author NoobProgrammer
 * @title: MidOrder
 * @projectName leecode
 * @description: TODO
 * @date 2022/1/2910:07
 */
public class InOrder {

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
        InOrder inOrder = new InOrder();
        inOrder.inOrder(root);
        inOrder.unifyMethod(root);
    }

    public void inOrder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> resList = new ArrayList<>();
        if(root == null) {
            return;
        }
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            //cur一直向左遍历
            if(cur != null) {
                //将访问到的节点都入栈
                stack.push(cur);
                cur = cur.left;
            }else {
                cur = stack.pop(); //处理最后一个入栈的元素
                resList.add(cur.val);
                cur = cur.right;
            }
        }
        System.out.println(resList);


    }

    //前中后序遍历使用迭代法的统一写法：
    //将访问到的节点放入栈中，并且标记要处理的节点
    //标记的方法:待处理节点进入栈时，在其后额外添加一个NULL节点
    public void unifyMethod(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> resList = new ArrayList<>();
        if(root != null) {
            stack.push(root);
        }
        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            if(pop != null) {
                if(pop.right != null) {
                    stack.push(pop.right);  //迭代法遍历时需要后遍历的先进栈
                }
                stack.push(pop);
                stack.push(null);//标记-> 下一个元素就是需要加入结果集的元素
                if(pop.left != null) {
                    stack.push(pop.left);
                }
                //pop出空指针意味着下一个元素就是要添加进resList的元素
            }else {
                TreeNode top = stack.pop();
                resList.add(top.val); //加入结果集
            }

        }
        System.out.println(resList);


    }
}
