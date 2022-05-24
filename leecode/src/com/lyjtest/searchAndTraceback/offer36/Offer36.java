package com.lyjtest.searchAndTraceback.offer36;

import javax.swing.tree.TreeNode;

/**
 * @author NoobProgrammer
 * @title: Offer36
 * @projectName leecode
 * @description: TODO
 * @date 2021/12/1317:15
 */
public class Offer36 {
    public static void main(String[] args) {
        Node root = new Node(4);
        Node node1 = new Node(2);
        Node node2 = new Node(5);
        Node node3 = new Node(1);
        Node node4 = new Node(3);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        Solution solution = new Solution();
        Node node = solution.treeToDoublyList(root);
    }

}


class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};

class Solution {
    Node head;
    Node pre;

    public Node treeToDoublyList(Node root) {
        if(root == null){
            return null;
        }
        dfs(root);
        //遍历完成后head指向头指针，pre指向尾指针
        head.left = pre;
        pre.right = head;
        return head;

    }

    public void dfs(Node node) {
        if (node == null) {
            return;
        }

        //递归左子树
        dfs(node.left);
        //如果pre为null,则该节点为头节点
        if (pre == null) {
            head = node;
        } else {
            //修改节点的引用
            pre.right = node;
            node.left = pre;
        }
        //向后移动pre
        pre = node;
        //递归右子树
        dfs(node.right);

    }
}