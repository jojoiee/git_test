package com.lyjtest.searchAndTraceback.offer37;


import java.util.LinkedList;
import java.util.Queue;

/**
 * @author NoobProgrammer
 * @title: Offer37
 * @projectName leecode
 * @description: TODO
 * @date 2021/12/1416:15
 */
public class Offer37 {
    public static void main(String[] args) {
//        TreeNode root = new TreeNode(1);
//        TreeNode node1 = new TreeNode(2);
//        TreeNode node2 = new TreeNode(3);
//        TreeNode node3 = new TreeNode(4);
//        TreeNode node4 = new TreeNode(5);
//        root.left = node1;
//        root.right = node2;
//        node2.left = node3;
//        node2.right = node4;
        Codec codec = new Codec();
        TreeNode root = null;
        String serialize = codec.serialize(root);
        System.out.println(serialize);
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

class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        queue.add(root);
        while (queue.size() > 0) {
            for (int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
                if (node != null) {
                    //如果当前节点不为空，node左右节点入队列
                    sb.append(node.val).append(",");
                    queue.add(node.left);
                    queue.add(node.right);

                } else {
                    //如果当前节点为空
                    if (queue.size() >= 1) {
                        sb.append("null,");
                    } else {
                        sb.append("null");
                    }

                }
            }
            //
        }
        return sb.toString();

    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if("[]".equals(data) || "null".equals(data)){
            return null;
        }
        //将序列化后的字符串分割为字符串数组
        String[] nodeVal = data.split(",");

        Queue<TreeNode> queue = new LinkedList<>();

        //新建根节点并将其入队
        TreeNode root = new TreeNode(Integer.parseInt(nodeVal[0]));
        queue.add(root);
        //初始化指针指向索引为1的位置
        //每出队列一个节点，将i向后移动两次,这两次分别代表left和right指针

        int i = 1;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            //
            if (!"null".equals(nodeVal[i])) {
                node.left = new TreeNode(Integer.parseInt(nodeVal[i]));
                //将该点入队列
                queue.add(node.left);
            }
            //如果指针指向null，直接
            //i指针向后移动
            i++;
            if (!"null".equals(nodeVal[i])) {
                node.right = new TreeNode(Integer.parseInt(nodeVal[i]));
                queue.add(node.right);
            }
            i++;

        }
        return root;
    }
}