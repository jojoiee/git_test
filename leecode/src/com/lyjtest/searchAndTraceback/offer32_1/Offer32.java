package com.lyjtest.searchAndTraceback.offer32_1;


import java.util.*;

/**
 * @author NoobProgrammer
 * @title: Offer32
 * @projectName leecode
 * @description: TODO
 * @date 2021/12/1117:34
 */
public class Offer32 {
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

    //广度优先+队列
    public int[] levelOrder(TreeNode root) {


        if (root == null) {
            return new int[]{};
        }
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> resList = new ArrayList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            //poll出一个节点，将其加入结果列表，并将其左子树和右子树加入
            TreeNode node = queue.poll();
            resList.add(node.val);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }

        }
        //将list中的数据复制到数组中
        int[] resArray = new int[resList.size()];
        for (int i = 0; i < resArray.length; i++) {
            resArray[i] = resList.get(i);
        }
        return resArray;

    }


}
