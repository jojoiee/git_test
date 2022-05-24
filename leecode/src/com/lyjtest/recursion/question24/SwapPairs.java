package com.lyjtest.recursion.question24;

/**
 * @author NoobProgrammer
 * @title: SwapPairs
 * @projectName leecode
 * @description: 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。
 * 你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
 * @date 2021/12/611:50
 */
public class SwapPairs {
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}


class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode temp = head.next;
//        temp.next = head.next.next;
//        head = head.next;
//        head.next = temp;
        head.next = swapPairs(temp.next);
        temp.next = head;
        return temp;

    }
}