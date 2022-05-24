package com.lyjtest.searchAndTraceback.offer32_3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author NoobProgrammer
 * @title: Offer32_3
 * @projectName leecode
 * @description: TODO
 * @date 2021/12/1216:16
 */
public class Offer32_3 {
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
        Solution solution = new Solution();
        List<List<Integer>> lists = solution.levelOrder(root);
        System.out.println(lists);
    }
}

class Solution {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> resList = new ArrayList<>();
        if (root == null) {
            return resList;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        int index = 0;//表示当前节点的深度
        queue.add(root);
        //存放每层节点

        //存放最终节点

        while (!queue.isEmpty()) {
            //初始化temp集合
            List<Integer> temp = new ArrayList<>();
            //队列的长度表示该层节点的个数
            //queue.size会改变，因此不能作为上限
            for (int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
                //将该节点加入临时集合
                temp.add(node.val);
                //将该节点的左子子树加入队列
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            //循环结束表示该层已经遍历完毕,将temp中的数据加入resList
            if (index % 2 == 1) {
                //将temp逆序
                temp = reverse(temp);

            }
            resList.add(temp);
            index++;//深度加一
        }
        return resList;

    }

    //列表逆序的方法
    public List<Integer> reverse(List<Integer> list) {
        List<Integer> temp = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            temp.add(list.get(list.size() - i - 1));
        }
        return temp;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}