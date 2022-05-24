package com.lyjtest.searchAndTraceback.offer34;


import java.util.ArrayList;
import java.util.List;

/**
 * @author NoobProgrammer
 * @title: Offer34
 * @projectName leecode
 * @description: TODO
 * @date 2021/12/1316:31
 */
public class Offer34 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(8);
        TreeNode node3 = new TreeNode(11);
        TreeNode node4 = new TreeNode(13);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(7);
        TreeNode node7 = new TreeNode(2);
        TreeNode node8 = new TreeNode(5);
        TreeNode node9 = new TreeNode(1);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node3.left = node6;
        node3.right = node7;
        node2.left = node4;
        node2.right = node5;
        node5.left = node8;
        node5.right = node9;
        Solution solution = new Solution();
        List<List<Integer>> lists = solution.pathSum(root, 22);
        System.out.println(lists);

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

class Solution {
    //存储这条路线经过节点值的List
    private List<Integer> path;
    private List<List<Integer>> resList;

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        //存储这条路线经过节点的List
        path = new ArrayList<>();
        resList = new ArrayList<>();

        if (root == null) {
            return resList;
        }
        recursion(root, target);

        return resList;

    }

    public void recursion(TreeNode node, int target) {

        if (node == null) {
            return;
        }
        path.add(node.val);
        target = target - node.val;
        if (node.left == null && node.right == null && target == 0) {
            //新建一个列表添加路径
            //若直接执行resList.add(path),
            //后续 path 改变时， res 中的 path 对象也会随之改变，因此无法实现结果记录
            resList.add(new ArrayList<>(path));
        }

        recursion(node.left, target);
        recursion(node.right, target);

        //路径恢复
        path.remove(path.size() - 1);

    }


}
